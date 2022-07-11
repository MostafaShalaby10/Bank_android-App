package com.example.bank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class updateuser extends AppCompatActivity {
EditText idtxt , nametxt , passtxt , confpasstxt , phonetxt , balancetxt ;
DB db ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updateuser);
        db = new DB(this);
        idtxt = (EditText) findViewById(R.id.idtxt);
        nametxt = (EditText) findViewById(R.id.nametxt);
        passtxt = (EditText) findViewById(R.id.passtxt);
        confpasstxt = (EditText) findViewById(R.id.confpasstxt);
        phonetxt = (EditText) findViewById(R.id.phonetxt);
        balancetxt = (EditText) findViewById(R.id.balancetxt);
    }
    public void onupdateuserclick(View view)
    {
        if (idtxt.getText().toString().isEmpty() || nametxt.getText().toString().isEmpty() || passtxt.getText().toString().isEmpty() || confpasstxt.getText().toString().isEmpty() || phonetxt.getText().toString().isEmpty() || balancetxt.getText().toString().isEmpty())
        {
            Toast.makeText(this, "Please enter data", Toast.LENGTH_SHORT).show();
        }
        else
        {
            if (passtxt.getText().toString().equals(confpasstxt.getText().toString()))
            {
                boolean result = db.updateuser(idtxt.getText().toString() , nametxt.getText().toString() , passtxt.getText().toString() , Double.parseDouble(balancetxt.getText().toString()) , phonetxt.getText().toString());
                if (result)
                {
                    Toast.makeText(this, "Update this user", Toast.LENGTH_SHORT).show();
                    idtxt.setText("");
                    nametxt.setText("");
                    passtxt.setText("");
                    confpasstxt.setText("");
                    phonetxt.setText("");
                    balancetxt.setText("");
                }
            }
        }
    }
}