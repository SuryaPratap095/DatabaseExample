package com.example.suryasolanki.databaseexample;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by surya.solanki on 11/8/2016.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_actvity);
        SqliteHelper sqliteHelper=new SqliteHelper(this);
      //  sqliteHelper.onCreate();
    }
}
