package com.example.bank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class insertadmin extends AppCompatActivity {
EditText nametxt , passtxt , confpasstxt , idtxt ;
DB db ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertadmin);
        db = new DB(this);
        nametxt = (EditText) findViewById(R.id.nametxt);
        passtxt = (EditText) findViewById(R.id.passtxt);
        idtxt = (EditText) findViewById(R.id.idtxt);
        confpasstxt = (EditText) findViewById(R.id.confpasstxt);
    }
    public void oninsertadminclick(View view)
    {
        if ( idtxt.getText().toString().isEmpty() ||nametxt.getText().toString().isEmpty() || passtxt.getText().toString().isEmpty() || confpasstxt.getText().toString().isEmpty())
        {
            Toast.makeText(this, "Please enter data", Toast.LENGTH_SHORT).show();
        }else
        {
            if (passtxt.getText().toString().equals(confpasstxt.getText().toString()))
            {
                boolean result = db.insertadmin(idtxt.getText().toString() ,nametxt.getText().toString() , passtxt.getText().toString());
                if (result)
                {
                    Toast.makeText(this, "Added one admin", Toast.LENGTH_SHORT).show();
                    nametxt.setText("");
                    idtxt.setText("");
                    passtxt.setText("");
                    confpasstxt.setText("");            }
                else
                    Toast.makeText(this, "Can't add this admin", Toast.LENGTH_SHORT).show();
            }else
                Toast.makeText(this, "Passwords don't match", Toast.LENGTH_SHORT).show();
        }
    }
}