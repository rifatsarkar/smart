package com.example.user.to_let;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DataBaseHelper extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "userdetails.db";
    private static final String TABLE_NAME = "user_details";
    private static final String FIRSTNAME= "FirstName";
    private static final String ID = "Id";
    private static final String LASTNAME = "LastName";
    private static final String EMAIL = "Email";
    private static final String PHONENUMBER = "Phonenumber";
    private static final String PASSWORD = "Password";
    private static final String DATE= "Date";
    private static final int VERSION_NUMBER = 10;


    ////////where is ID...??? i think phone number replace by ID cos this is auto increment
    private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+"("+
            ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+FIRSTNAME+" VARCHAR(255) NOT NULL,"+LASTNAME+" VARCHAR(255) NOT NULL,"+
            EMAIL+" TEXT NOT NULL, "+PHONENUMBER+" TEXT NOT NULL,"+PASSWORD+" TEXT NOT NULL,"+DATE+" TEXT NOT NULL )";

    private static final String DROP_TABLE = "DROP TABLE IF EXISTS "+TABLE_NAME;



    private Context context;
    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION_NUMBER);

        this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        try{
            sqLiteDatabase.execSQL(CREATE_TABLE);
            //Toast.makeText(context, "OnCreate Is Called", Toast.LENGTH_SHORT).show();

        }catch (Exception e){
            Toast.makeText(context, "Exception : " + e, Toast.LENGTH_SHORT).show();
        }

    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        try{
            //Toast.makeText(context, "OnUpgrade Is Called", Toast.LENGTH_SHORT).show();
            sqLiteDatabase.execSQL(DROP_TABLE);
            onCreate(sqLiteDatabase);

        }catch (Exception e){

            Toast.makeText(context, "Exception : " + e, Toast.LENGTH_SHORT).show();
        }
    }

    public long insertData(UserDetails userDetails){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();


        contentValues.put(FIRSTNAME,userDetails.getFirstName());
        contentValues.put(LASTNAME,userDetails.getLastName());
        contentValues.put(EMAIL,userDetails.getEmail());
        contentValues.put(PHONENUMBER,userDetails.getPhonenumber());
        contentValues.put(PASSWORD,userDetails.getPassword());
        contentValues.put(DATE,userDetails.getDate());

        long rowId =  sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        return rowId;
    }

    public Boolean findPassword(String uname, String pword){


        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor  = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME,null);
        Boolean result = false;

        if (cursor.getCount()==0){
            Toast.makeText(context, "No Data is found...", Toast.LENGTH_SHORT).show();
        }
        else{
            while (cursor.moveToNext()){
                String PhoneNumber = cursor.getString(4);
                String password = cursor.getString(5);

                if (PhoneNumber.equals(uname) && password.equals(pword)){
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

}