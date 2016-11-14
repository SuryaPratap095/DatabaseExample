package com.example.suryasolanki.databaseexample;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by surya.solanki on 11/8/2016.
 */

public class MainActivity extends AppCompatActivity {

    SqliteHelper sqliteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_actvity);
        sqliteHelper=new SqliteHelper(this);

        sqliteHelper.InsertPerson("Surya","8952979627","Suryapratap.in@gmail.com","Pune","KP");
      //  sqliteHelper.onCreate();

       ArrayList<Person> arrayList=sqliteHelper.getAllContacts();

        for(Person p:arrayList){
            Toast.makeText(this,"Person Name: "+p.getName()+"Phone "+p.getPhone_num()+"email "+p.getEmail() +"City "+p.getCity()
                +"Street "+p.getStreet(),Toast.LENGTH_SHORT);
        }
    }
}
