package com.example.bank;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;


import java.util.ArrayList;

public class DB extends SQLiteOpenHelper {
    private static final String DBname = "Bank";
    private static final String usertable = "dataofuser";
    private static final String admintable = "dataofadmin";
    private static final int version_code = 1;
    Context context;

    public DB(Context context) {
        super(context, DBname, null, version_code);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL("create table " + usertable + "(id text primary key  , name text , pass text ,balance integer , phone text)");
            db.execSQL("create table " + admintable + "(id text primary key  , name text , pass text )");
        } catch (Exception e) {
            Toast.makeText(context, "Error in oncreate method", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        try {
            db.execSQL("Drop table if exists " + usertable);
            db.execSQL("Drop table if exists " + admintable);
            onCreate(db);
        } catch (Exception e) {
            Toast.makeText(context, "Error in onupgrade method", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean insertuser(String id , String name, String pass, double balance, String phone) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", id);
        contentValues.put("name", name);
        contentValues.put("pass", pass);
        contentValues.put("balance", balance);
        contentValues.put("phone", phone);

        long result = db.insert(usertable, null, contentValues);
        if (result == -1) {
            return false;
        } else
            return true;
    }

    public boolean insertadmin( String id ,String name, String pass) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", id);
        contentValues.put("name", name);
        contentValues.put("pass", pass);

        long result = db.insert(admintable, null, contentValues);
        if (result != -1)
            return true;
        else
            return false;
    }

    public boolean updateuser(String id, String name, String pass, double balance, String phone) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", id);
        contentValues.put("name", name);
        contentValues.put("pass", pass);
        contentValues.put("balance", balance);
        contentValues.put("phone", phone);
        long result = db.update(usertable, contentValues, " id=?", new String[]{id});
        if (result > 0)
            return true;
        else
            return false;
    }

    public boolean updateadmin(String id, String name, String pass) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", id);
        contentValues.put("name", name);
        contentValues.put("pass", pass);
        long result = db.update(admintable, contentValues, " id=?", new String[]{id});
        if (result > 0)
            return true;
        else
            return false;
    }

    public boolean deleteuser(String id) {
        boolean flag = true;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from " + usertable + " where id=?", new String[]{id});
        if (cursor.moveToNext())
            flag = false;

        if (flag == false) {
            SQLiteDatabase db1 = getWritableDatabase();
            db1.delete(usertable, "id=?", new String[]{id});
            return true;
        } else
            return false;
    }

    public boolean deleteadmin(String id) {
        boolean flag = true;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from " + admintable + " where id=?", new String[]{id});
        if (cursor.moveToNext())
            flag = false;

        if (flag == false) {
            SQLiteDatabase db1 = getWritableDatabase();
            db1.delete(admintable, "id=?", new String[]{id});
            return true;
        } else
            return false;
    }

    public ArrayList searchuser(String id) {
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select id , name , balance  , phone from " + usertable + " where id=?", new String[]{id});
        if (cursor.moveToNext()) {
            String idd = cursor.getString(0);
            String name = cursor.getString(1);
            String balance = cursor.getString(2);
            String phone = cursor.getString(3);
            arrayList.add("ID : " + idd + "\nname : " + name + "\nbalance : " + balance + "\nphone : " + phone);
        }
        return arrayList;
    }

    public ArrayList searchadmin(String id) {
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select id , name  from " + admintable + " where id=?", new String[]{id});
        if (cursor.moveToNext()) {
            String idd = cursor.getString(0);
            String name = cursor.getString(1);
            arrayList.add("ID : " + idd + "\nname : " + name);
        }
        return arrayList;
    }

    public ArrayList getallusers() {
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select id , name , balance  , phone from " + usertable, null);
        while (cursor.moveToNext()) {
            String idd = cursor.getString(0);
            String name = cursor.getString(1);
            String balance = cursor.getString(2);
            String phone = cursor.getString(3);
            arrayList.add("ID : " + idd + "\nname : " + name + "\nbalance : " + balance + "\nphone : " + phone);
        }
        return arrayList;
    }

    public ArrayList getalladmins() {
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select id , name  from " + admintable, null);
        while (cursor.moveToNext()) {
            String idd = cursor.getString(0);
            String name = cursor.getString(1);

            arrayList.add("ID : " + idd + "\nname : " + name);
        }
        return arrayList;
    }

    public boolean loginuser(String id, String pass) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from " + usertable + " where id =? and pass =?", new String[]{id, pass});
        if (cursor.moveToNext())
            return true;
        else
            return false;
    }

    public boolean loginadmin(String id, String pass) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from " + admintable + " where id =? and pass =?", new String[]{id, pass});
        if (cursor.moveToNext())
            return true;
        else
            return false;
    }

    public boolean deposit(String id, double quantity) {
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select balance from " + usertable + " where id =?", new String[]{id});
        if (cursor.moveToNext()) {
            double bal = cursor.getDouble(0);
            double newbal = bal + quantity;

            SQLiteDatabase db1 = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("balance", newbal);
            long result = db.update(usertable, contentValues, " id=?", new String[]{id});
            if (result > 0)
                return true;
            else
                return false;
        } else
            return false;
    }

    public boolean withdrawal(String id, double quantity) {
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select balance from " + usertable + " where id =?", new String[]{id});
        if (cursor.moveToNext()) {
            double bal = cursor.getDouble(0);
            double newbal = bal - quantity;

            SQLiteDatabase db1 = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("balance", newbal);
            long result = db.update(usertable, contentValues, " id=?", new String[]{id});
            if (result > 0)
                return true;

            else

                return false;

        } else

            return false;

    }

    public boolean getbalance(String id, double balance) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select balance from " + usertable + " where id =?", new String[]{id});
        if (cursor.moveToNext()) {
            double bal = cursor.getDouble(0);
            if (balance <= bal)
                return true;
            else
                return false;
        }
        return false;
    }
    public ArrayList getallusers2() {
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select id , name , balance  , phone from " + usertable, null);
        while (cursor.moveToNext()) {
            String idd = cursor.getString(0);
            String name = cursor.getString(1);
            String balance = cursor.getString(2);
            String phone = cursor.getString(3);
            arrayList.add( idd );
        }
        return arrayList;
    }
}
