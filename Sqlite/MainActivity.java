package com.example.myapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        DatabaseHelper db = new DatabaseHelper(this);
        db.insertStudent(1, "Alice", "Kathmandu");
        db.insertStudent(2, "Bob", "Pokhara");
        db.insertStudent(3, "Charlie", "Biratnagar");
        db.insertStudent(4, "Diana", "Lalitpur");
        db.insertStudent(5, "Eve", "Bhaktapur");
        
        ListView listView = findViewById(R.id.list_view);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, db.getAllStudents());
        listView.setAdapter(adapter);
    }
}
