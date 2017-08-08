package com.example.segundoauqui.webviewsandsqlline;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.List;

import static android.R.attr.name;

/**
 * Created by segundoauqui on 8/8/17.
 */

public class DataBaseHelper extends SQLiteOpenHelper{


    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "MyDatabase";


    public static final String TABLE_NAME = "Contacts";
    public static final String CONTACT_NAME = "Names";
    public static final String CONTACT_NUMBER = "Number";
    private static final String TAG = "savedata";




    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" +
                CONTACT_NAME + " TEXT, " +
                CONTACT_NUMBER + " TEXT PRIMARY KEY" + ")";



        sqLiteDatabase.execSQL(CREATE_TABLE);




    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {


        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void saveNewContact(MyContac contac){
        SQLiteDatabase database = this.getReadableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put(CONTACT_NAME, name);
        contentvalues.put(CONTACT_NUMBER, number);
        database.insert(TABLE_NAME, null, contentvalues);
        Log.d(TAG, "saveNewContact: ");




    }

    public List<MyContac> List<MyContac> DataBaseHelper(){
        super();
        SQLiteDatabase database = this.getWritableDatabase();
        String query = "SELECT * from "  + TABLE_NAME;
        Cursor cursor = database.rawQuery(query, null);

        if(cursor.moveToFirst()){
            do{
                MyContac contact = new MyContac(cursor.getString(0), cursor.getString(1));


                contacts.add(contact);
                Log.d(TAG, "getContacts: Name: " + cursor.getString(0) + ", Phone: " + cursor.getString(1));
            }while(cursor.moveToNext());
        }

        return contat;

    }
    
}
