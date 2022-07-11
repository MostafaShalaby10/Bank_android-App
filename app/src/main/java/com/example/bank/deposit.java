package com.example.bank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class deposit extends AppCompatActivity {
EditText amounttxt ; 
DB db ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposit);
        db = new DB(this);
        amounttxt = (EditText) findViewById(R.id.amounttxt);
    }
    public void setondepositeclick(View view)
    {
        if (amounttxt.getText().toString().isEmpty())
        {
            Toast.makeText(this, "Please enter number", Toast.LENGTH_SHORT).show();
        }else
        {

            Intent intent = getIntent();
            Bundle bundle = intent.getExtras();
            String data = bundle.getString("id");

            boolean result = db.deposit(data , Double.parseDouble(amounttxt.getText().toString()));
            if (result)
                Toast.makeText(this, "Deposit successfully", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this, "Deposit fail", Toast.LENGTH_SHORT).show();
        }
    }
}