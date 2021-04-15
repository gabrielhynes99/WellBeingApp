package com.example.wellbeingproject;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;


/************************************************************************************
* Refrence:                                                                          *
* This code is based on code i found online, the original code can be found at this  *
* site: https://guides.codepath.com/android/Using-an-ArrayAdapter-with-ListView      *
* I modified the code to work for my app                                             *
 ************************************************************************************/

public class CustomAdapter extends CursorAdapter {
    public CustomAdapter(Context context , Cursor cursor) {
        super(context, cursor,0);
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
        ImageView t_image = (ImageView) view.findViewById(R.id.imageView);
        TextView t_activityName = (TextView) view.findViewById(R.id.activityName);
        TextView t_time = (TextView) view.findViewById(R.id.time);

        // Extract properties from cursor
        String activityName = cursor.getString(cursor.getColumnIndexOrThrow("name"));
        String time = cursor.getString(cursor.getColumnIndexOrThrow("time"));

        // Populate fields with extracted properties
        //setting Image view

        //setting the text view
        t_activityName.setText(activityName);
        t_time.setText(time);

        if(activityName.equalsIgnoreCase("Rise and Shine Social")){

            t_image.setImageResource(R.drawable.rands);

        }else if(activityName.equalsIgnoreCase("Drama")){

            t_image.setImageResource(R.drawable.drama);

        }else if(activityName.equalsIgnoreCase("Yoga")){

            t_image.setImageResource(R.drawable.yoga);

        }else if(activityName.equalsIgnoreCase("Cookery with Louise")){

            t_image.setImageResource(R.drawable.cookery);

        }else if(activityName.equalsIgnoreCase("Quiz")){

            t_image.setImageResource(R.drawable.quiz);

        }else if(activityName.equalsIgnoreCase("Dance")){

            t_image.setImageResource(R.drawable.dance12);

        }else if(activityName.equalsIgnoreCase("Zumba")){

            t_image.setImageResource(R.drawable.dance12);

        }else if(activityName.equalsIgnoreCase("Sports")){

            t_image.setImageResource(R.drawable.sportwhite);

        }else if(activityName.equalsIgnoreCase("Story Corner")){

            t_image.setImageResource(R.drawable.story);

        }else if(activityName.equalsIgnoreCase("Sonas")){

            t_image.setImageResource(R.drawable.sonas);

        }else if(activityName.equalsIgnoreCase("Art With Emma")){

            t_image.setImageResource(R.drawable.art);

        }else if(activityName.equalsIgnoreCase("Operation Transformation")){

            t_image.setImageResource(R.drawable.operation);

        }else if(activityName.equalsIgnoreCase("Book Club")){

            t_image.setImageResource(R.drawable.story);

        }else if(activityName.equalsIgnoreCase("Gardening Group")){

            t_image.setImageResource(R.drawable.gardening);

        }else if(activityName.equalsIgnoreCase("Advocacy")){

            t_image.setImageResource(R.drawable.advocacy);

        }else if(activityName.equalsIgnoreCase("Choir")){

            t_image.setImageResource(R.drawable.choir);

        }else if(activityName.equalsIgnoreCase("Relaxation")){

            t_image.setImageResource(R.drawable.relaxation);

        }else if(activityName.equalsIgnoreCase("Jobs Club")){

            t_image.setImageResource(R.drawable.work);

        }else if(activityName.equalsIgnoreCase("Lámh")){

            t_image.setImageResource(R.drawable.lamh);

        }else if(activityName.equalsIgnoreCase("Karate")){

            t_image.setImageResource(R.drawable.karate2);

        }else if(activityName.equalsIgnoreCase("Mini Disco")){

            t_image.setImageResource(R.drawable.dance);

        }else if(activityName.equalsIgnoreCase("Evening Exercise With Paul")){

            t_image.setImageResource(R.drawable.sportwhite);

        }





    }//end of bind view

}//end of CustomAdapter class