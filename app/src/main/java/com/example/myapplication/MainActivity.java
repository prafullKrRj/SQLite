package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBHandler db = new DBHandler(this);
        Contact prafull = new Contact("Prafull", "9634079844");
        db.insertData(prafull);

        Contact vashu = new Contact("Vashu", "1234679890");
        db.insertData(vashu);

        Contact divya = new Contact("Divya", "6926827638");
        db.insertData(divya);


        ArrayList<String> arrayList = new ArrayList<>();
        List<Contact> list = db.getAllContacts();
        for (Contact contact: list){
            arrayList.add(contact.getName()+" "+contact.getPhoneNumber());
        }
        listView = findViewById(R.id.list_item);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(adapter);

    }
}