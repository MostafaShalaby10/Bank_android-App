package com.example.bank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class withdrawal extends AppCompatActivity {
    EditText amounttxt ;
    DB db ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withdrawal);
        db = new DB(this);
        amounttxt = (EditText) findViewById(R.id.amounttxt);
    }
    public void setonwithdrawalclick(View view)
    {
        if (amounttxt.getText().toString().isEmpty())
        {
            Toast.makeText(this, "Please enter number", Toast.LENGTH_SHORT).show();
        }else
        {
            
            Intent intent = getIntent();
            Bundle bundle = intent.getExtras();
            String data = bundle.getString("id");

            boolean res = db.getbalance(data ,Double.parseDouble(amounttxt.getText().toString()) );
            if (res) {
                boolean result = db.withdrawal(data , Double.parseDouble(amounttxt.getText().toString()));
                if (result)
                    Toast.makeText(this, "withdrawal successfully", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(this, "withdrawal fail", Toast.LENGTH_SHORT).show();
            }else
            {
                Toast.makeText(this, "There is no enough money", Toast.LENGTH_SHORT).show();
            }
           
        }

    }
}