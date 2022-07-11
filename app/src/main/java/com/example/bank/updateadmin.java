package com.example.bank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class updateadmin extends AppCompatActivity {
EditText idtxt , nametxt , passtxt , conftxt ;
DB db ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updateadmin);
        db = new DB(this) ;
        idtxt = (EditText) findViewById(R.id.idtxt);
        nametxt = (EditText) findViewById(R.id.nametxt);
        passtxt = (EditText) findViewById(R.id.passtxt);
        conftxt = (EditText) findViewById(R.id.confpasstxt);
    }
    public  void onupdateadminclick(View view)
    {
        if (idtxt.getText().toString().isEmpty() || nametxt.getText().toString().isEmpty() || passtxt.getText().toString().isEmpty() || conftxt.getText().toString().isEmpty())
        {
            Toast.makeText(this, "Please enter data", Toast.LENGTH_SHORT).show();
        }else
        {
            if (passtxt.getText().toString().equals(conftxt.getText().toString()))
            {
                boolean result = db.updateadmin(idtxt.getText().toString() , nametxt.getText().toString() , passtxt.getText().toString());
                if (result)
                {
                    Toast.makeText(this, "Updtaed this admin", Toast.LENGTH_SHORT).show();
                    idtxt.setText("");
                    nametxt.setText("");
                    passtxt.setText("");
                    conftxt.setText("");
                }
            }
        }
    }
}