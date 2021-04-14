package com.example.wellbeingproject;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.example.wellbeingproject.Database.ProjectDatabaseManager;


public class Calendar extends AppCompatActivity implements CalendarAdapter.OnItemListener {
    private Toolbar toolbar;
    public TextView monthYearText;
    private RecyclerView calendarRecyclerView;
    private LocalDate selectedDate;

    //Creating an Instance of the ProjectDatabaseManager mydb and a Cursor
    ProjectDatabaseManager mydb;
    Cursor myCursor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar);
        initWidgets();
        selectedDate = LocalDate.now();
        setMonthView();
        setCurDate();

        ImageView backbutton = findViewById(R.id.back_button);

        //to access the back button
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        // Initialising mydb
        mydb = new ProjectDatabaseManager(this);
        // opening database
        mydb.open();

        //mydb.insertItems("Monday","0", "Lamh","10:00a,");

        // Initialising my cursor with all the items in my database
        myCursor = mydb.getAllItems();

        // Creating and Initialising my list view with the
        // List view i want to populate in my xml file
        ListView list = findViewById(R.id.list);

        //Making an instance of my custom adapter
        //this is where the list view gets populated
        CustomAdapter customAdapter = new CustomAdapter(this, myCursor);
        list.setAdapter(customAdapter);
        customAdapter.changeCursor(myCursor);

        //database is closed
        mydb.close();


    }//EndOfOnCreate


    private void initWidgets() {

        calendarRecyclerView = findViewById(R.id.calendarRecyclerView);
        monthYearText = findViewById(R.id.monthYearTV);
    }

    private void setCurDate() {

        TextView current_date = findViewById(R.id.current_day);
        String date = "Today "+dayMonthDateFromDate(selectedDate);
        current_date.setText(date);
    }

    private void setMonthView() {

        monthYearText.setText(monthYearFromDate(selectedDate));
        ArrayList<String> daysInMonth = daysInMonthArray(selectedDate);

        CalendarAdapter calendarAdapter = new CalendarAdapter(daysInMonth, this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 7);
        calendarRecyclerView.setLayoutManager(layoutManager);
        calendarRecyclerView.setAdapter(calendarAdapter);
    }

    private ArrayList<String> daysInMonthArray(LocalDate date) {

        ArrayList<String> daysInMonthArray = new ArrayList<>();
        YearMonth yearMonth = YearMonth.from(date);

        int daysInMonth = yearMonth.lengthOfMonth();

        LocalDate firstOfMonth = selectedDate.withDayOfMonth(1);
        int dayOfWeek = firstOfMonth.getDayOfWeek().getValue();


        //This for loop fills the days in the month array
        //i = 2 starts the week on a monday instead of a sunday
        for(int i = 2; i<=42; i++){

            if(i <= dayOfWeek || i > daysInMonth + dayOfWeek)
            {
                daysInMonthArray.add("");
            }
            else
            {
                daysInMonthArray.add(String.valueOf((i - dayOfWeek)));
            }
        }
        return daysInMonthArray;

    }

    private String monthYearFromDate(LocalDate date){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy");
        return date.format(formatter);
    }

    private String dayMonthDateFromDate(LocalDate date){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE MMMM d");
        return date.format(formatter);
    }

    private String day(LocalDate date){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d");
        return date.format(formatter);
    }

    public void previousMonthAction(View view){

        selectedDate = selectedDate.minusMonths(1);
        setMonthView();

    }

    public void nextMonthAction(View view){

        selectedDate = selectedDate.plusMonths(1);
        setMonthView();

    }

    @Override
    public void onItemClick(int position, String dayText) {

        if(dayText.equals(""))
        {
            //Nothing
        }
        else
        {
            String message = "Selected Date " + dayText + " " + monthYearFromDate(selectedDate);
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        }



    }
}

