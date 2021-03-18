package com.example.wellbeingproject;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;


/************************************************************************************
* Refrence:                                                                          *
* This code is based on code i found online, the original code can be found at this  *
* site: https://guides.codepath.com/android/Using-an-ArrayAdapter-with-ListView      *
* I modified the code to work for my app                                             *
 ************************************************************************************/

public class CustomAdapter extends CursorAdapter {
    public CustomAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    // The newView method is where i inflate a new view and return said view.
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.row, parent, false);
    }

    // The bindView method is where I join my textViews from the
    // row.xml to textViews i make in this class
    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        // Find fields to populate in inflated template
        TextView t_activityImage = (TextView) view.findViewById(R.id.activityImage);
        TextView t_activityName = (TextView) view.findViewById(R.id.activityName);
        TextView t_time = (TextView) view.findViewById(R.id.time);

        // Extract properties from cursor
        String time = cursor.getString(cursor.getColumnIndexOrThrow(""));
        String activityName = cursor.getString(cursor.getColumnIndexOrThrow(""));
        String activityImage = cursor.getString(cursor.getColumnIndexOrThrow(""));
        // Populate fields with extracted properties


        //setting the text view
        t_activityName.setText(activityName);
        t_time.setText(time);

        //setting Image view
        t_activityImage.setText(activityImage);



    }//end of bind view

}//end of CustomAdapter class