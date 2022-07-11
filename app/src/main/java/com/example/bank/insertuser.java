package com.example.bank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class insertuser extends AppCompatActivity {
EditText nametxt , passtxt , confpasstxt , balancetxt , phonetxt ,idtxt ;
DB db ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertuser);
        nametxt = (EditText) findViewById(R.id.nametxt);
        passtxt = (EditText) findViewById(R.id.passtxt);
        confpasstxt= (EditText) findViewById(R.id.confpasstxt);
        balancetxt = (EditText) findViewById(R.id.balancetxt);
        idtxt = (EditText) findViewById(R.id.idtxt);
        phonetxt = (EditText) findViewById(R.id.phonetxt);
        db = new DB(this);
    }
    public void oninsertuserclick(View view)
    {
        if (idtxt.getText().toString().isEmpty() ||nametxt.getText().toString().isEmpty() || passtxt.getText().toString().isEmpty() || confpasstxt.getText().toString().isEmpty() ||balancetxt.getText().toString().isEmpty() || phonetxt.getText().toString().isEmpty())
        {
            Toast.makeText(this, "Please enter data", Toast.LENGTH_SHORT).show();
        }else
        {
            if (passtxt.getText().toString().equals(confpasstxt.getText().toString()))
            {
                boolean result = db.insertuser(idtxt.getText().toString() ,nametxt.getText().toString() , passtxt.getText().toString() , Double.parseDouble(balancetxt.getText().toString() ) , phonetxt.getText().toString());
                if (result)
                {
                    Toast.makeText(this, "added one user", Toast.LENGTH_SHORT).show();
                    idtxt.setText("");
                    nametxt.setText("");
                    passtxt.setText("");
                    confpasstxt.setText("");
                    phonetxt.setText("");
                    balancetxt.setText("");
                }else
                {
                    Toast.makeText(this, "Can't insert this user", Toast.LENGTH_SHORT).show();
                }
            }else
            {
                Toast.makeText(this, "Passwords don't match", Toast.LENGTH_SHORT).show();
            }
        }
    }
}