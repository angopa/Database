package com.paezand.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {

            SQLiteDatabase myDatabase = this.openOrCreateDatabase("Users", MODE_PRIVATE, null);

            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS newUsers (name VARCHAR, age INTEGER(3), id INTEGER PRIMARY KEY)");

//            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS users(name VARCHAR, age INT(3))");

//            myDatabase.execSQL("INSERT INTO newUsers (name, age) VALUES ('Rob', 34)");

//            myDatabase.execSQL("INSERT INTO newUsers (name, age) VALUES ('Andres', 32)");

//            myDatabase.execSQL("UPDATE users SET age=33 WHERE name = 'Andres'");

//            myDatabase.execSQL("DELETE FROM users WHERE name = 'Andres' LIMIT 1");
            
            Cursor c = myDatabase.rawQuery("SELECT * FROM users", null);

            int nameIndex = c.getColumnIndex("name");
            int ageIndex = c.getColumnIndex("age");
//            int idIndex = c.getColumnIndex("id");

            c.moveToFirst();

            while(c != null) {
                Log.d("name: ", c.getString(nameIndex));
                Log.d("age: ", Integer.toString(c.getInt(ageIndex)));
//                Log.d("id: ", Integer.toString(c.getInt(idIndex)));
                c.moveToNext();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
