package com.example.wellbeingproject;

import android.database.Cursor;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
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
import java.util.Locale;

import com.example.wellbeingproject.Database.ProjectDatabaseManager;


public class Calendar extends AppCompatActivity implements CalendarAdapter.OnItemListener {
    private Toolbar toolbar;
    public TextView monthYearText;
    private RecyclerView calendarRecyclerView;
    private LocalDate selectedDate;
    public TextToSpeech t1;

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

        final ImageView tts_icon = findViewById(R.id.tts_icon);


        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.UK);

                    tts_icon.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int i = 0;
                            while(i == 0) {
                                t1.speak("Today is "+dayMonthDateFromDate(selectedDate), TextToSpeech.QUEUE_ADD, null, null);
                                t1.speak("Today's Activities are:",  TextToSpeech.QUEUE_ADD,null, null);

                                switch (dayOfWeek(selectedDate)) {
                                    case "Monday":
                                        t1.speak("Rise and Shine Social at 9:30am", TextToSpeech.QUEUE_ADD, null, null);
                                        t1.speak("Drama at 10:00am", TextToSpeech.QUEUE_ADD, null, null);
                                        t1.speak("Yoga at 12:00pm", TextToSpeech.QUEUE_ADD, null, null);
                                        t1.speak("Cookery with Louise at 1:00pm", TextToSpeech.QUEUE_ADD, null, null);
                                        t1.speak("Quiz at 2:00pm", TextToSpeech.QUEUE_ADD, null, null);
                                        break;
                                    case "Tuesday":
                                        t1.speak("Rise and Shine Social at 9:30am", TextToSpeech.QUEUE_ADD, null, null);
                                        t1.speak("Dance at 10:00am", TextToSpeech.QUEUE_ADD, null, null);
                                        t1.speak("Zumba at 11:00am", TextToSpeech.QUEUE_ADD, null, null);
                                        t1.speak("Sports at 12:00pm", TextToSpeech.QUEUE_ADD, null, null);
                                        t1.speak("Story Corner at 1:00pm", TextToSpeech.QUEUE_ADD, null, null);
                                        t1.speak("Sonas at 2:00pm", TextToSpeech.QUEUE_ADD, null, null);
                                        t1.speak("Evening Exercise With Paul at 6:00pm", TextToSpeech.QUEUE_ADD, null, null);
                                        break;
                                    case "Wednesday":
                                        t1.speak("Rise and Shine Social at 9:30am", TextToSpeech.QUEUE_ADD, null, null);
                                        t1.speak("Art with Emma at 10:00am", TextToSpeech.QUEUE_ADD, null, null);
                                        t1.speak("Operation Transformation at 11:00am", TextToSpeech.QUEUE_ADD, null, null);
                                        t1.speak("Sports at 12:00pm", TextToSpeech.QUEUE_ADD, null, null);
                                        t1.speak("Book Club at 1:00pm", TextToSpeech.QUEUE_ADD, null, null);
                                        t1.speak("Gardening Group at 2:00pm", TextToSpeech.QUEUE_ADD, null, null);
                                        break;
                                    case "Thursday":
                                        t1.speak("Rise and Shine Social at 9:30am", TextToSpeech.QUEUE_ADD, null, null);
                                        t1.speak("Advocacy at 10:00am", TextToSpeech.QUEUE_ADD, null, null);
                                        t1.speak("Choir at 11:00am", TextToSpeech.QUEUE_ADD, null, null);
                                        t1.speak("Sports at 12:00pm", TextToSpeech.QUEUE_ADD, null, null);
                                        t1.speak("Relaxation at 1:30pm", TextToSpeech.QUEUE_ADD, null, null);
                                        t1.speak("Evening Exercise with Paul at 6:00pm", TextToSpeech.QUEUE_ADD, null, null);
                                        break;
                                    case "Friday":
                                        t1.speak("Rise and Shine Social at 9:30am", TextToSpeech.QUEUE_ADD, null, null);
                                        t1.speak("jobs Club at 10:00am", TextToSpeech.QUEUE_ADD, null, null);
                                        t1.speak("Lámh at 11:00am", TextToSpeech.QUEUE_ADD, null, null);
                                        t1.speak("Karate at 12:00pm", TextToSpeech.QUEUE_ADD, null, null);
                                        t1.speak("Mini Disco at 1:00pm", TextToSpeech.QUEUE_ADD, null, null);

                                        break;
                                }//end of switch

                                i++;
                            }
                        }
                    });
                }
            }
        });

        // Initialising mydb
        mydb = new ProjectDatabaseManager(this);
        // opening database
        mydb.open();


        for(int i = 1; i < 29; i++){
            mydb.deleteItems(i);
        }


        //Inserting Mondays Activities
        mydb.insertItems(1,1,"Monday",  "Rise and Shine Social", "9:30am");
        mydb.insertItems(2,1,"Monday",  "Drama", "10:00am");
        mydb.insertItems(3,1,"Monday",  "Yoga", "12:00pm");
        mydb.insertItems(4,1,"Monday",  "Cookery with Louise", "1:00pm");
        mydb.insertItems(5,1,"Monday",  "Quiz", "2:00pm");

        //Inserting Tuesdays Activities
        mydb.insertItems(6,2,"Tuesday",  "Rise and Shine Social", "9:30am");
        mydb.insertItems(7,2,"Tuesday",  "Dance", "10:00am");
        mydb.insertItems(8,2,"Tuesday",  "Zumba", "11:00am");
        mydb.insertItems(9,2,"Tuesday",  "Sports(jersey Day)", "12:00pm");
        mydb.insertItems(10,2,"Tuesday",  "Story Corner", "1:00pm");
        mydb.insertItems(11,2,"Tuesday",  "Sonas", "2:00pm");
        mydb.insertItems(12,2,"Tuesday",  "Evening Exercise With Paul", "6:00pm");

        //Inserting Wednesday Activities
        mydb.insertItems(13,3,"Wednesday","Rise and Shine Social","9:30am");
        mydb.insertItems(14,3,"Wednesday","Art with Emma","10:00am");
        mydb.insertItems(15,3,"Wednesday","Operation Transformation","11:00am");
        mydb.insertItems(16,3,"Wednesday","Sports","12:00am");
        mydb.insertItems(17,3,"Wednesday","Book Club","1.00pm");
        mydb.insertItems(18,3,"Wednesday","Gardening Group","2.00pm");

        //Inserting Thursday Activities
        mydb.insertItems(19,4,"Thursday","Rise and Shine Social","9:30am");
        mydb.insertItems(20,4,"Thursday","Advocacy","10.00am");
        mydb.insertItems(21,4,"Thursday","Choir","11.00am");
        mydb.insertItems(22,4,"Thursday","Sports","12.00pm");
        mydb.insertItems(23,4,"Thursday","Relaxation","1.30pm");
        mydb.insertItems(24,4,"Thursday","Evening Exercise with Paul","6.00pm");


        //Inserting Friday Activities
        mydb.insertItems(25,5,"Friday","Rise and Shine Social","9:30am");
        mydb.insertItems(26,5,"Friday","jobs Club","10:00am");
        mydb.insertItems(27,5,"Friday","Lámh","11.00am");
        mydb.insertItems(28,5,"Friday","Karate","12.00pm");
        mydb.insertItems(29,5,"Friday","Mini Disco","1.00pm");



        // Initialising my cursor with all the items in my database
        //for that day.

        switch (dayOfWeek(selectedDate)) {
            case "Monday":
                myCursor = mydb.getAllItems2(1);
                break;
            case "Tuesday":
                myCursor = mydb.getAllItems2(2);
                break;
            case "Wednesday":
                myCursor = mydb.getAllItems2(3);
                break;
            case "Thursday":
                myCursor = mydb.getAllItems2(4);
                break;
            case "Friday":
                myCursor = mydb.getAllItems2(5);

                break;
        }//end of switch

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

    private String dayOfWeek(LocalDate date){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE");
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

