package lv.goexanimo.demo.firstapp;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    //Define EXTRA_MESSAGE
    public final static String EXTRA_MESSAGE = "lv.goexanimo.firstapp.MESSAGE";
    public String UserID = "Placeholder";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UserID = "PH";
        setContentView(R.layout.activity_main);
    }

    /** Called when the user clicks the Send button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText scoreA = (EditText) findViewById(R.id.scoreA);
        EditText scoreB = (EditText) findViewById(R.id.scoreB);
        EditText name = (EditText) findViewById(R.id.name);
        EditText kills = (EditText) findViewById(R.id.kills);
        EditText deaths = (EditText) findViewById(R.id.deaths);
        EditText assists = (EditText) findViewById(R.id.assists);

        int KDA = 0;
        if (Integer.parseInt(deaths.getText().toString()) > 0) {
            KDA = (Integer.parseInt(kills.getText().toString()) + Integer.parseInt(assists.getText().toString())) / Integer.parseInt(deaths.getText().toString());
        } else{
            KDA = 1337;
        }
        String message = "User ID = " + UserID.toString() + "\nRecieved : \nTeam Name A Score : " + scoreA.getText().toString() + "\nTeam Name B Score : " + scoreB.getText().toString() + "\nMVP : " + name.getText().toString() + "\nK/D/A:KDA : " + kills.getText().toString() + "/" + deaths.getText().toString()  + "/" + assists.getText().toString() + ":" + String.valueOf(KDA);

        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

}
