package com.example.suryasolanki.databaseexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.example.suryasolanki.databaseexample.Constants;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Created by surya.solanki on 11/8/2016.
 */

public class SqliteHelper extends SQLiteOpenHelper {

    public SqliteHelper(Context context){
        super(context,Constants.DB_NAME,null,Constants.DB_VERSION);
    };
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
       String Contacts_table_create="Create table "+Constants.TABLE_CONTACTS +"("+Constants.CON_CONTACTS_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
               + Constants.CON_NAME + " TEXT, "+ Constants.CON_EMAIL + " TEXT, " + Constants.CON_CITY+" TEXT, "+ Constants.CON_STREET
               +" TEXT, "+Constants.CON_PHONE+" FLOAT"+");";

        sqLiteDatabase.execSQL(Contacts_table_create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("Drop table if exists "+Constants.TABLE_CONTACTS);
        onCreate(sqLiteDatabase);

    }

    public void InsertPerson(String name,String phone_num, String email,String city, String street ){
        try {
            SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
               contentValues.put(Constants.CON_CONTACTS_ID,11);
            contentValues.put(Constants.CON_NAME, name);
            contentValues.put(Constants.CON_PHONE, 895297978);
            //  contentValues.put("phone_num",8952979627);
            contentValues.put(Constants.CON_EMAIL, email);
            contentValues.put(Constants.CON_CITY, city);
            contentValues.put(Constants.CON_STREET, street);
            sqLiteDatabase.insert(Constants.TABLE_CONTACTS,null,contentValues);
        }
        catch (Exception e){
            Log.d("Error: ",e.getStackTrace().toString());
        }
    }

    public void insertNewContacts(Person person){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Constants.CON_NAME,person.getName());
        values.put(Constants.CON_PHONE,person.getPhone_num());
        values.put(Constants.CON_EMAIL,person.getEmail());
        values.put(Constants.CON_CITY,person.getCity());
        values.put(Constants.CON_STREET,person.getCity());

        sqLiteDatabase.insert(Constants.TABLE_CONTACTS,null,values);
        sqLiteDatabase.close();

    }



    public ArrayList<Person> getAllContacts(){
        ArrayList<Person> arrayList=new ArrayList<Person>();

        Person person=new Person();
        SQLiteDatabase sqLiteDatabase= this.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("Select * from "+Constants.TABLE_CONTACTS+";",null);
        if(cursor.moveToFirst()){
            do{
                person.setName(cursor.getString(cursor.getColumnIndex(Constants.CON_NAME)));
                person.setPhone_num(cursor.getString(cursor.getColumnIndex(Constants.CON_PHONE)));
                person.setEmail(cursor.getString(cursor.getColumnIndex(Constants.CON_EMAIL)));
                person.setCity(cursor.getString(cursor.getColumnIndex(Constants.CON_CITY)));
                person.setStreet(cursor.getString(cursor.getColumnIndex(Constants.CON_STREET)));
                arrayList.add(person);
            }while(cursor.moveToNext());
        }
        sqLiteDatabase.close();
        return arrayList;


    }
}
