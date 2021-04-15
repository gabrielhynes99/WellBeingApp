package com.example.wellbeingproject.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.sql.Blob;

import static com.example.wellbeingproject.Database.ProjectDatabaseHelper.DATABASE_TABLE1;
import static com.example.wellbeingproject.Database.ProjectDatabaseHelper.KEY_DAY;
import static com.example.wellbeingproject.Database.ProjectDatabaseHelper.KEY_DAYID;
import static com.example.wellbeingproject.Database.ProjectDatabaseHelper.KEY_DAYID;
import static com.example.wellbeingproject.Database.ProjectDatabaseHelper.KEY_NAME;
import static com.example.wellbeingproject.Database.ProjectDatabaseHelper.KEY_ROWID;
import static com.example.wellbeingproject.Database.ProjectDatabaseHelper.KEY_TIME;


// package/ various impoorts etc.. including
/// import of static variables from the helper class attributes you will need.. or could use getters

public class ProjectDatabaseManager
{

    Context context;
    private ProjectDatabaseHelper myProjectDatabaseHelper;
    private SQLiteDatabase myDatabase;


    public ProjectDatabaseManager(Context context)
    {
        this.context = context;

    }

    public ProjectDatabaseManager open() throws SQLException {
        myProjectDatabaseHelper = new ProjectDatabaseHelper(context);
        myDatabase = myProjectDatabaseHelper.getWritableDatabase();
        return this;
    }

    //---closes the database--- any activity that uses the dB will need to do this
    public void close()
    {
        myProjectDatabaseHelper.close();
    }

    //---insert a activity into the database---
    public long insertItems(long rowId, long dayId, String day, String name, String time)
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_ROWID, rowId);
        initialValues.put(KEY_DAYID, dayId);
        initialValues.put(KEY_DAY, day);
        initialValues.put(KEY_NAME, name);
        initialValues.put(KEY_TIME, time);
        return myDatabase.insert(DATABASE_TABLE1, null, initialValues);
    }


    //---deletes a particular activity---
    public boolean deleteItems(long rowId)
    {
        // delete statement.  If any rows deleted (i.e. >0), returns true
        return myDatabase.delete(DATABASE_TABLE1, KEY_ROWID +
                "=" + rowId, null) > 0;
    }

    //---retrieves all the rows ---
    public Cursor getAllItems()
    {
        return myDatabase.query(DATABASE_TABLE1, new String[] {
                        KEY_ROWID,
                        KEY_DAYID,
                        KEY_DAY,
                        KEY_NAME,
                        KEY_TIME},
                null,
                null,
                null,
                null,
                null);
    }

    //---retrieves all the rows ---
    public Cursor getAllItems2(long dayId)
    {
        return myDatabase.query(DATABASE_TABLE1, new String[] {
                        KEY_ROWID,
                        KEY_DAYID,
                        KEY_DAY,
                        KEY_NAME,
                        KEY_TIME},
                KEY_DAYID + "=" + dayId,
                null,
                null,
                null,
                null);
    }

    //---retrieves a particular activity---
    public Cursor getDayItems(long rowId) throws SQLException
    {
        Cursor mCursor =
                myDatabase.query(true, DATABASE_TABLE1, new String[] {
                                KEY_ROWID,
                                KEY_DAYID,
                                KEY_DAY,
                                KEY_NAME,
                                KEY_TIME
                        },
                        KEY_ROWID + "=" + rowId,
                        null,
                        null,
                        null,
                        null,
                        null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }


}

