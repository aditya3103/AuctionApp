package com.example.auctionapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.badge.BadgeUtils;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.MissingFormatArgumentException;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.net.ssl.HttpsURLConnection;

public class Bidding extends AppCompatActivity {
    public static ArrayList<String> url = new ArrayList<>();
   // public static ArrayList<String> Role = new ArrayList<>();
    public static ArrayList<String> Name = new ArrayList<>();
    public static ArrayList<Integer> playerHistory = new ArrayList<>();
    //public static String str= null;
    public static float playerVal= 0.00f;
    public static int teamTag=0;
    public static String str =null;
    public static int i=1;
    public static ArrayList<String> unsoldPlayers= new ArrayList<>();
    public static ArrayList<String> unsoldURL= new ArrayList<>();
    public static boolean unsoldRound= false;
    public static ArrayList<String> soldList = new ArrayList<>();
    public static String bidTeamStr=null;

    Random random1 = new Random();
    public int rand=0;




    public static ArrayList<String> rcbFinalTeam = new ArrayList<>();
    public static ArrayList<String> cskFinalTeam = new ArrayList<>();
    public static ArrayList<String> srhFinalTeam = new ArrayList<>();
    public static ArrayList<String> kkrFinalTeam = new ArrayList<>();
    public static ArrayList<String> rrFinalTeam = new ArrayList<>();
    public static ArrayList<String> pbksFinalTeam = new ArrayList<>();
    public static ArrayList<String> dcFinalTeam = new ArrayList<>();
    public static ArrayList<String> miFinalTeam = new ArrayList<>();

    public void showPurse(View view){
        Intent purseIntent = new Intent(this, PurseList.class);
        startActivity(purseIntent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bidding);
        Button sold = (Button)findViewById(R.id.sold);
        sold.setEnabled(false);
        pickPlayer();
        Button unsold = (Button)findViewById(R.id.unsoldButton);
        unsold.setEnabled(true);
        TextView count = (TextView)findViewById(R.id.countText);
        count.setText(str+ " "+String.valueOf(i++)+"/"+String.valueOf(Name.size()));
        Button button = (Button)findViewById(R.id.button);
        button.setVisibility(View.INVISIBLE);
    }

    public class ImageDownloader extends AsyncTask<String, Void, Bitmap> {
        @Override
        protected Bitmap doInBackground(String... urls) {
            try {
                URL url = new URL(urls[0]);
                HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
                connection.connect();
                InputStream in = connection.getInputStream();
                Bitmap bitmap = BitmapFactory.decodeStream(in);
                return bitmap;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public void unsold(View view){
        //do something for unsold player
        MainActivity.bidVal=0.25f;


        if(!unsoldRound) {
            unsoldPlayers.add(Name.get(rand));
            unsoldURL.add(url.get(rand));
        }

        TextView count = (TextView)findViewById(R.id.countText);
        count.setText(str+ " "+String.valueOf(i++)+"/"+String.valueOf(Name.size()));
        if(playerHistory.size()==Name.size()){

            Name.clear();
            url.clear();
            playerHistory.clear();
            i=1;
            if(unsoldRound) {
                unsoldRound = false;
                unsoldPlayers.clear();
                unsoldURL.clear();
                Nationality.playersCompleted=false;
                i=1;
                finish();

            }
            else
            Nationality.playersCompleted=true;
            finish();
        }
        playerVal=0.0f;
        TextView textView = (TextView)findViewById(R.id.textView);
        textView.setText("Current Bid: N/A");

        Button sold = (Button)findViewById(R.id.sold);
        sold.setEnabled(false);

        pickPlayer();

    }

    public void sold(View view) {
        //do something for sold player
        MainActivity.bidVal=0.25f;
        soldList.add(Name.get(rand).toString()+" "+String.valueOf(playerVal)+"      " +bidTeamStr);
        if(playerHistory.size()==Name.size()){
            Name.clear();
            url.clear();
            playerHistory.clear();
            if(unsoldRound) {
                unsoldRound = false;
                unsoldPlayers.clear();
                unsoldURL.clear();
                Nationality.playersCompleted=false;
                finish();
                i=1;
            }
            else {
                Nationality.playersCompleted = true;
            }
                i=1;
            finish();
        }

        TextView count = (TextView)findViewById(R.id.countText);
        count.setText(str+ " "+String.valueOf(i++)+"/"+String.valueOf(Name.size()));

        Button unsold = (Button)findViewById(R.id.unsoldButton);
        unsold.setEnabled(true);
                switch(teamTag){
            case 1:
                MainActivity.rcbPurse-=playerVal;
                rcbFinalTeam.add(Name.get(rand)+" "+playerVal+"Cr");
                break;
            case 2:
                MainActivity.cskPurse-=playerVal;
                cskFinalTeam.add(Name.get(rand)+" "+playerVal+"Cr");
                break;
            case 3:
                MainActivity.srhPurse-=playerVal;
                srhFinalTeam.add(Name.get(rand)+" "+playerVal+"Cr");

                break;
            case 4:
                MainActivity.kkrPurse-=playerVal;
                kkrFinalTeam.add(Name.get(rand)+" "+playerVal+"Cr");
                break;
            case 5:
                MainActivity.rrPurse-=playerVal;
                rrFinalTeam.add(Name.get(rand)+" "+playerVal+"Cr");

                break;
            case 6:
                MainActivity.pbksPurse-=playerVal;
                pbksFinalTeam.add(Name.get(rand)+" "+playerVal+"Cr");
                break;
            case 7:
                MainActivity.dcPurse-=playerVal;
                dcFinalTeam.add(Name.get(rand)+" "+playerVal+"Cr");
                break;
            case 8:
                MainActivity.miPurse-=playerVal;
                miFinalTeam.add(Name.get(rand)+" "+playerVal+"Cr");
                break;

        }

        playerVal=0.0f;
        TextView textView = (TextView)findViewById(R.id.textView);
textView.setText("Current Bid: N/A");

        Button sold = (Button)findViewById(R.id.sold);
        sold.setEnabled(false);
        pickPlayer();


    }




    public void bid (View view){
        Button sold = (Button)findViewById(R.id.sold);
        sold.setEnabled(true);

        Button unsold = (Button)findViewById(R.id.unsoldButton);
        unsold.setEnabled(false);

        Button teamButton = (Button)view;
        if(playerVal>=6.00)
            MainActivity.bidVal=0.5f;
        playerVal+=MainActivity.bidVal;

        teamTag = Integer.parseInt(teamButton.getTag().toString());
        bidTeamStr=teamButton.getText().toString();
        TextView textView = (TextView)findViewById(R.id.textView);
        String bidStr= "Current Bid: "+ String.valueOf(playerVal)+"Cr"+ " "+teamButton.getText().toString();
        textView.setText(bidStr);
    }

    public void pickPlayer(){
        try {
            rand = random1.nextInt(Name.size());
            if(playerHistory.contains(rand)){
                while(playerHistory.contains(rand)) {
                    Random r2 = new Random();
                    rand = r2.nextInt(Name.size());
                }
            }

            playerHistory.add(rand);
            ImageDownloader imageDownloader = new ImageDownloader();
            Bitmap bitmap = imageDownloader.execute("https://www.cricbuzz.com/" + url.get(rand)).get();
            ImageView imageView = (ImageView) findViewById(R.id.playerImage);
            imageView.setImageBitmap(bitmap);
            TextView textView = (TextView) findViewById(R.id.playerNameText);
            textView.setText(Name.get(rand));

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void unsoldList(){

    }







}