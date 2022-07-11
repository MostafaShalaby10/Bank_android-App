package com.example.bank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class deleteadmin extends AppCompatActivity {
    EditText idtxt ;
    DB db ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deleteadmin);

        db = new DB(this);
        idtxt = (EditText) findViewById(R.id.idtxt);
    }
    public void ondeleteadminclick(View view)
    {
        if (idtxt.getText().toString().isEmpty())
            Toast.makeText(this, "Please enter data", Toast.LENGTH_SHORT).show();
        else
        {
            boolean result = db.deleteadmin(idtxt.getText().toString());
            if (result)
            {
                Toast.makeText(this, "Deleted this admin", Toast.LENGTH_SHORT).show();
                idtxt.setText("");
            }else
                Toast.makeText(this, "Can't delete this admin", Toast.LENGTH_SHORT).show();
        }
    }
}