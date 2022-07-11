package com.example.bank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class userhomepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userhomepage);
    }
    public void onprofileclick(View view)
    {
        Intent intent = getIntent() ;
        Bundle bundle = intent.getExtras();
        String data = bundle.getString("id");

        Intent intent1 = new Intent(userhomepage.this , userprofile.class);
        intent1.putExtra("id" , data);
        startActivity(intent1);
    }
    public void ontransferclick(View view)
    {
        Intent intent = getIntent() ;
        Bundle bundle = intent.getExtras();
        String data = bundle.getString("id");

        Intent intent1 = new Intent(userhomepage.this , transfer.class);
        intent1.putExtra("id" , data);
        startActivity(intent1);
    }
    public void ondepositclick(View view)
    {
        Intent intent = getIntent() ;
        Bundle bundle = intent.getExtras();
        String data = bundle.getString("id");

        Intent intent1 = new Intent(userhomepage.this , deposit.class);
        intent1.putExtra("id" , data);
        startActivity(intent1);
    }
    public void onwithdrawalclick(View view)
    {
        Intent intent = getIntent() ;
        Bundle bundle = intent.getExtras();
        String data = bundle.getString("id");

        Intent intent1 = new Intent(userhomepage.this , withdrawal.class);
        intent1.putExtra("id" , data);
        startActivity(intent1);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){

            case R.id.logout:
                Intent intent2 = new Intent(userhomepage.this , MainActivity.class);
                startActivity(intent2);
                break;
        }
        return  super.onOptionsItemSelected(item);
    }
}