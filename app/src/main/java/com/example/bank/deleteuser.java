package com.example.bank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class deleteuser extends AppCompatActivity {
EditText idtxt ;
DB db ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deleteuser);
        db = new DB(this);
        idtxt = (EditText) findViewById(R.id.idtxt);
    }
    public void ondeleteuserclick(View view)
    {
        if (idtxt.getText().toString().isEmpty())
            Toast.makeText(this, "Please enter data", Toast.LENGTH_SHORT).show();
        else
        {
            boolean result = db.deleteuser(idtxt.getText().toString());
            if (result)
            {
                Toast.makeText(this, "Deleted this user", Toast.LENGTH_SHORT).show();
                idtxt.setText("");
            }else
                Toast.makeText(this, "Can't delete this user", Toast.LENGTH_SHORT).show();
        }
    }
}