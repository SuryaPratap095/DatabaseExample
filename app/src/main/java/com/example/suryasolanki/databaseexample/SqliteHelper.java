package com.example.suryasolanki.databaseexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ArrayAdapter;

import com.example.suryasolanki.databaseexample.Constants;

import java.util.ArrayList;

/**
 * Created by surya.solanki on 11/8/2016.
 */

public class SqliteHelper extends SQLiteOpenHelper {



    public SqliteHelper(Context context){
        super(context,Constants.DB_NAME,null,Constants.DB_VERSION);
    };
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
       String Contacts_table_create="Create table "+Constants.TABLE_CONTACTS +"("+Constants.CON_CONTACTS_ID+"INTEGER PRIMARY KEY, "
               + Constants.CON_NAME + "TEXT, "+ Constants.CON_EMAIL + "TEXT, " + Constants.CON_CITY+"TEXT, "+ Constants.CON_STREET
               +"TEXT, "+Constants.CON_PHONE+"FLOAT"+");";

        sqLiteDatabase.execSQL(Contacts_table_create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("Drop table if exists"+Constants.TABLE_CONTACTS);
        onCreate(sqLiteDatabase);

    }

    public void InsertPerson(String name,String phone_num, String email,String city, String street ){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",name);
        contentValues.put("phone_num",phone_num);
        contentValues.put("email",email);
        contentValues.put("City",city);
        contentValues.put("street",street);
        sqLiteDatabase.insert(Constants.TABLE_CONTACTS,null,contentValues);
    }

    public ArrayList<String> getAllContacts(){
        ArrayList<String> arrayList=new ArrayList<String>();

        SQLiteDatabase sqLiteDatabase= this.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("Select * from"+Constants.TABLE_CONTACTS+";",null);
        cursor.moveToFirst();
        while(cursor.isAfterLast()==false){
            arrayList.add(cursor.getString(cursor.getColumnIndex(Constants.CON_NAME)));
            cursor.moveToNext();
        }
        return arrayList;
    }
}
