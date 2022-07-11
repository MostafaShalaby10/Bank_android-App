package com.example.bank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class adminhomepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminhomepage);
    }
    public void insertuser(View view)
    {
        Intent intent = new Intent(adminhomepage.this , insertuser.class);
        startActivity(intent);
    }public void insertadmin(View view)
    {
        Intent intent = new Intent(adminhomepage.this , insertadmin.class);
        startActivity(intent);
    }public void updateuser(View view)
    {
        Intent intent = new Intent(adminhomepage.this , updateuser.class);
        startActivity(intent);
    }public void updateadmin(View view)
    {
        Intent intent = new Intent(adminhomepage.this , updateadmin.class);
        startActivity(intent);
    }public void deleteuser(View view)
    {
        Intent intent = new Intent(adminhomepage.this , deleteuser.class);
        startActivity(intent);

    }public void deleteadmin(View view)
    {
        Intent intent = new Intent(adminhomepage.this , deleteadmin.class);
        startActivity(intent);
    }public void searchuser(View view)
    {
        Intent intent = new Intent(adminhomepage.this , searchuser.class);
        startActivity(intent);
    }public void searchadmin(View view)
    {
        Intent intent = new Intent(adminhomepage.this , searchadmin.class);
        startActivity(intent);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case  R.id.showadmindata:
                Intent intent = new Intent(adminhomepage.this , showadmindata.class);
                startActivity(intent);
                break;
            case R.id.showuserdata:
                Intent intent1 = new Intent(adminhomepage.this , showuserdata.class);
                startActivity(intent1);
                break;
            case R.id.logout:
                Intent intent2 = new Intent(adminhomepage.this , MainActivity.class);
                startActivity(intent2);
                break;
        }
        return  super.onOptionsItemSelected(item);
    }

}