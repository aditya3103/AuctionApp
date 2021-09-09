package com.example.auctionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class phase extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phase);

        Button p1 = (Button)findViewById(R.id.phase1);
        Button p2 = (Button)findViewById(R.id.phase2);

        if(Nationality.playersCompleted){
            p1.setEnabled(false);
            p2.setEnabled(true);
        } else {
            p1.setEnabled(true);
            p2.setEnabled(false);
        }

    }

    public void phaseMove(View view) {
        Button p1 = (Button)findViewById(R.id.phase1);
        Button p2 = (Button)findViewById(R.id.phase2);
        if (Nationality.playersCompleted==false) {

            Intent intent = new Intent(this, Bidding.class);
            startActivity(intent);
            p1.setEnabled(false);
            p2.setEnabled(true);
        }
        else {
if(Bidding.unsoldURL.size()>0) {
    //load unsold players and start bidding class
    Bidding.Name = Bidding.unsoldPlayers;
    Bidding.url = Bidding.unsoldURL;
    Intent intent = new Intent(this, Bidding.class);
    Bidding.unsoldRound = true;
    startActivity(intent);
    p1.setEnabled(false);
    p2.setEnabled(false);
} else {
    Nationality.playersCompleted = false;
    p1.setEnabled(true);
    p2.setEnabled(false);
finish();
}
        }
    }



}