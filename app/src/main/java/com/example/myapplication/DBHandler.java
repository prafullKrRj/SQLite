package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.PrecomputedText;

import java.util.ArrayList;
import java.util.List;


public class DBHandler extends SQLiteOpenHelper {


    private static final String D_NAME = "database";
    private static final int version = 1;
    private static final String TABLE_NAME = "users";
    private static final String KEY_NAME = "name";
    private static final String KEY_PHONE = "phoneNumber";

    public DBHandler(Context context) {
        super(context, D_NAME, null, version);
    }



    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL("create Table users(id Integer primary key, name TEXT, phoneNumber TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop Table if exists "+TABLE_NAME);
    }
    public void insertData(Contact contact){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_NAME, contact.getName());
        contentValues.put(KEY_PHONE, contact.getPhoneNumber());
        database.insert(TABLE_NAME,null, contentValues);
        database.close();
    }

    public List<Contact> getAllContacts(){
        List<Contact> contactList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        // Generate the query to read from the database
        String select = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(select, null);

        //Loop through now
        if(cursor.moveToFirst()){
            do{
                Contact contact = new Contact();
                contact.setId(Integer.parseInt(cursor.getString(0)));
                contact.setName(cursor.getString(1));
                contact.setPhoneNumber(cursor.getString(2));
                contactList.add(contact);
            }while(cursor.moveToNext());
        }
        return contactList;
    }
}
