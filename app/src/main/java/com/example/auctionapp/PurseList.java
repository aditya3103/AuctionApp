package com.example.auctionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class PurseList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purse_list);

        ListView listView = (ListView)findViewById(R.id.myList);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("RCB "+String.valueOf(MainActivity.rcbPurse)+"Cr");
        arrayList.add("CSK "+String.valueOf(MainActivity.cskPurse)+"Cr");
        arrayList.add("SRH "+String.valueOf(MainActivity.srhPurse)+"Cr");
        arrayList.add("KKR "+String.valueOf(MainActivity.kkrPurse)+"Cr");
        arrayList.add("RR "+String.valueOf(MainActivity.rrPurse)+"Cr");
        arrayList.add("PBKS "+String.valueOf(MainActivity.pbksPurse)+"Cr");
        arrayList.add("DC "+String.valueOf(MainActivity.dcPurse)+"Cr");
        arrayList.add("MI "+String.valueOf(MainActivity.miPurse)+"Cr");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);
    }


}