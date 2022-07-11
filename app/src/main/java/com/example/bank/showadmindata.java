package com.example.bank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class showadmindata extends AppCompatActivity {
    ListView lst ;
    DB db ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showadmindata);
        db = new DB(this) ;
        lst = (ListView) findViewById(R.id.lst);
    }
    @Override
    protected void onStart() {
        super.onStart();
        ArrayAdapter arrayAdapter = null ;
        ArrayList arrayList = db.getalladmins();
        if (arrayList.isEmpty())
        {
            Toast.makeText(this, "There is no data", Toast.LENGTH_SHORT).show();
            lst.setAdapter(arrayAdapter);
        }
        else
        {
            arrayAdapter = new ArrayAdapter(this , android.R.layout.simple_list_item_1 , arrayList);
            lst.setAdapter(arrayAdapter);
        }
    }
}