package com.example.wellbeingproject.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.Blob;

// various imports needed

public class ProjectDatabaseHelper extends SQLiteOpenHelper
{

    //names of the column headings in the project database
    public static final String KEY_ROWID = "_id";
    public static final String KEY_DAY = "day";
    public static final String KEY_IMAGE = "image";
    public static final String KEY_NAME = "name";
    public static final String KEY_TIME = "time";

    //Name of project database and table names
    public static final String DATABASE_NAME = "SJOGWellbeing";
    public static final String DATABASE_TABLE1 = "Calendar_Details";
    public static final int DATABASE_VERSION = 1;

    // This is the string containing the SQL database create statement
    private static final String DATABASE_CREATE =
            "create table " + DATABASE_TABLE1  +
                    " (_id integer primary key autoincrement, " +
                    "day text not null, " +
                    "image blob not null, "  +
                    "name text not null, "  +
                    "time text not null);";

    // constructor for your dB helper class. This code is standard. You’ve set up the parameter values for the constructor already…database name,etc

    public ProjectDatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db)
    {

        // The “Database_create” string below needs to contain the SQL statement needed to create the dB
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,
                          int newVersion)
    {
        // If you want to change the structure of your database, e.g.

    }


}
