package com.example.bank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class signinuser extends AppCompatActivity {
EditText idtxt , passtxt;
DB db ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signinuser);
        db = new DB(this);
        idtxt = (EditText) findViewById(R.id.idtxt);
        passtxt = (EditText) findViewById(R.id.passtxt);
    }

    public void onclick(View view)
    {
        if (idtxt.getText().toString().isEmpty() || passtxt.getText().toString().isEmpty())
        {
            Toast.makeText(this, "Please enter data", Toast.LENGTH_SHORT).show();
        }else
        {
            boolean result = db.loginuser(idtxt.getText().toString() , passtxt.getText().toString());
            if (result)
            {
                Intent intent = new Intent(signinuser.this , userhomepage.class);
                intent.putExtra("id" ,idtxt.getText().toString() );
                startActivity(intent);
                idtxt.setText("");
                passtxt.setText("");
            }
            else
                Toast.makeText(this, "Incorrect username or password", Toast.LENGTH_SHORT).show();
        }
    }
}