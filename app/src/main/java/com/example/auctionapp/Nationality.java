package com.example.auctionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Nationality extends AppCompatActivity {

    public static boolean playersCompleted=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nationality);
          int foreign= 15;
          int indian= 10;
    }



    public void pick (View view){

        Button nation = (Button)view;
        int country= Integer.parseInt(nation.getTag().toString());

        int target= MainActivity.action+country;

        switch(target){
            case 11:
                Bidding.Name= MainActivity.batsman;
                Bidding.url= MainActivity.batsmanURL;
                Bidding.str= "Batsman";
                break;
            case 12:
                Bidding.Name= MainActivity.allRounder;
                Bidding.url= MainActivity.allRounderURL;
                Bidding.str= "All Rounder";
                break;
            case 13:
                Bidding.Name= MainActivity.bowler;
                Bidding.url= MainActivity.bowlerURL;
                Bidding.str= "Bowler";
                break;
            case 14:
                Bidding.Name= MainActivity.keeper;
                Bidding.url= MainActivity.keeperURL;
                Bidding.str= "WKB";
                break;

            case 16:
                Bidding.Name= MainActivity.batsmanF;
                Bidding.url= MainActivity.batsmanURLF;
                Bidding.str= "Batsman";
                break;
            case 17:
                Bidding.Name= MainActivity.allRounderF;
                Bidding.url= MainActivity.allRounderURLF;
                Bidding.str= "All Rounder";
                break;
            case 18:
                Bidding.Name= MainActivity.bowlerF;
                Bidding.url= MainActivity.bowlerURLF;
                Bidding.str= "Bowler";
                break;
            case 19:
                Bidding.Name= MainActivity.keeperF;
                Bidding.url= MainActivity.keeperURLF;
                Bidding.str= "WKB";
                break;
        }

        Intent intent1 = new Intent(this, phase.class);
        startActivity(intent1);


    }



}