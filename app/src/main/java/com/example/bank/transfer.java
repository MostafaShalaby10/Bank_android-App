package com.example.bank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class transfer extends AppCompatActivity {
EditText amounttxt ;
ListView lst ;
DB db ;
String index= null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer);
        amounttxt = (EditText) findViewById(R.id.amounttxt);
        lst = (ListView) findViewById(R.id.lst);
        db = new DB(this);
        lst.setOnItemClickListener((adapterView, view, i, l) ->
        {
           index =   (String) adapterView.getAdapter().getItem(i);
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        ArrayAdapter arrayAdapter =null ;
        ArrayList arrayList = db.getallusers2();
        if (arrayList.isEmpty())
        {
            Toast.makeText(this, "There is no users", Toast.LENGTH_SHORT).show();
            lst.setAdapter(arrayAdapter);
        }else
        {
            arrayAdapter = new ArrayAdapter(this , android.R.layout.simple_list_item_1 , arrayList);
            lst.setAdapter(arrayAdapter);
        }
    }

    public void ontransferclick(View view) {
        if (amounttxt.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please enter data", Toast.LENGTH_SHORT).show();
        } else {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String data = bundle.getString("id");

        boolean result = db.getbalance(data, Double.parseDouble(amounttxt.getText().toString()));
        if (result) {
            boolean result1 = db.withdrawal(data, Double.parseDouble(amounttxt.getText().toString()));
            if (result1) {
                if (index==null)
                {
                    Toast.makeText(this, "Please choose the receiver", Toast.LENGTH_SHORT).show();
                }
                else
                {


                boolean result2 = db.deposit(index, Double.parseDouble(amounttxt.getText().toString()));
                if (!result2)
                    Toast.makeText(this, "Error in deposit", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(this, "Transfer successful", Toast.LENGTH_SHORT).show();
            }} else {
                Toast.makeText(this, "Error in withdrawal", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "There is no enough money", Toast.LENGTH_SHORT).show();
        }
    }
    }

}