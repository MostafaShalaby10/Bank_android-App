package com.example.bank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class userprofile extends AppCompatActivity {
ListView lst ;
DB db ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userprofile);
        db = new DB(this);
        lst = (ListView) findViewById(R.id.lst);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String data = bundle.getString("id");
        ArrayAdapter arrayAdapter = null ;
        ArrayList arrayList = db.searchuser(data);

        if (arrayList.isEmpty())
        {
            Toast.makeText(this, "There is no data", Toast.LENGTH_SHORT).show();
            lst.setAdapter(arrayAdapter);
        }else
        {
            arrayAdapter = new ArrayAdapter(this , android.R.layout.simple_list_item_1 , arrayList);
            lst.setAdapter(arrayAdapter);
        }
    }
    public void ontransferclick(View view)
    {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String data = bundle.getString("id");

        Intent intent1 = new Intent(userprofile.this , transfer.class);
        intent1.putExtra("id" , data);
        startActivity(intent1);
    }
}