package com.example.bank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class signupadmin extends AppCompatActivity {
    EditText nametxt , passtxt , confpasstxt , idtxt ;
    DB db ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupadmin);
        db = new DB(this);
        nametxt = (EditText) findViewById(R.id.nametxt);
        passtxt = (EditText) findViewById(R.id.passtxt);
        idtxt = (EditText) findViewById(R.id.idtxt);
        confpasstxt = (EditText) findViewById(R.id.confpasstxt);
    }
    public void oninsertadminclick(View view)
    {
        if (idtxt.getText().toString().isEmpty() ||nametxt.getText().toString().isEmpty() || passtxt.getText().toString().isEmpty() || confpasstxt.getText().toString().isEmpty())
        {
            Toast.makeText(this, "Please enter data", Toast.LENGTH_SHORT).show();
        }else
        {
            if (passtxt.getText().toString().equals(confpasstxt.getText().toString()))
            {
                boolean result = db.insertadmin(idtxt.getText().toString() ,nametxt.getText().toString() , passtxt.getText().toString());
                if (result)
                {
                    Toast.makeText(this, "Created an account", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(signupadmin.this , adminhomepage.class);
                    startActivity(intent);
                }
                else
                    Toast.makeText(this, "Can't create this account", Toast.LENGTH_SHORT).show();
            }else
                Toast.makeText(this, "Passwords don't match", Toast.LENGTH_SHORT).show();
        }
    }
}