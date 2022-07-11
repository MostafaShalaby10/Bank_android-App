package com.example.bank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class searchadmin extends AppCompatActivity {
    EditText idtxt ;
    ListView lst ;
    DB db ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchadmin);
        idtxt = (EditText) findViewById(R.id.idtxt);
        lst = (ListView) findViewById(R.id.lst);
        db = new DB(this);
    }
    public void onsearchaminclick(View view)
    {
        if (idtxt.getText().toString().isEmpty())
        {
            Toast.makeText(this, "Please enter data", Toast.LENGTH_SHORT).show();
        }else
        {
            ArrayAdapter arrayAdapter = null ;
            ArrayList arrayList = db.searchadmin(idtxt.getText().toString());
            if (arrayList.isEmpty())
            {
                Toast.makeText(this, "Can't find this admin", Toast.LENGTH_SHORT).show();
                lst.setAdapter(arrayAdapter);
            }
            else
            {
                arrayAdapter = new ArrayAdapter(this , android.R.layout.simple_list_item_1 , arrayList);
                lst.setAdapter(arrayAdapter);
            }
        }
    }
}