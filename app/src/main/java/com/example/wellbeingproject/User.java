package com.example.wellbeingproject;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import android.widget.Toolbar;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import static com.example.wellbeingproject.Mentor.MESSAGE;

public class User extends AppCompatActivity {
    private Toolbar toolbar;
    ListView listview;
    ListView listview2;
    Button report;
    Button wellbeing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userdetails);

        listview = (ListView)findViewById(R.id.list);
        report = (Button) findViewById(R.id.reportbtn);
        wellbeing = (Button) findViewById(R.id.wellbeingbtn);

        getData();

        report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setContentView(R.layout.reportdetails);
                listview2= (ListView)findViewById(R.id.list2);
                getReportData();

                wellbeing = (Button) findViewById(R.id.wellbeingbtn);

                wellbeing.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        setContentView(R.layout.userdetails);
                        listview= (ListView)findViewById(R.id.list);
                        getData();

                        ImageView backbutton = findViewById(R.id.back_button);

                        //to access the back button
                        backbutton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                finish();
                            }
                        });

                    }
                });

            }
        });


        ImageView backbutton = findViewById(R.id.back_button);

        //to access the back button
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void getData() {

        //int number = Integer.parseInt(MESSAGE.getString(0));
        int number = MESSAGE+4;

        String url = Config6.DATA_URL + number;


        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                showJSON(response);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(User.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

    private void showJSON(String response) {
        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray result = jsonObject.getJSONArray(Config6.JSON_ARRAY);

            for (int i = 0; i < result.length(); i++) {
                JSONObject jo = result.getJSONObject(i);
                String rid = jo.getString(Config6.REPORT_ID);
                String dayr = jo.getString(Config6.DAY_REPORT);
                String feelingr = jo.getString(Config6.FEELING_REPORT);
                String today = jo.getString(Config6.TODAY_REPORT);
                String aboutday = jo.getString(Config6.ABOUTDAY_REPORT);
                String reportdate = jo.getString(Config6.REPORT_DATE);


                final HashMap<String, String> details = new HashMap<>();
                details.put(Config6.REPORT_ID,  rid);
                details.put(Config6.DAY_REPORT,  dayr);
                details.put(Config6.FEELING_REPORT, feelingr);
                details.put(Config6.TODAY_REPORT, today);
                details.put(Config6.ABOUTDAY_REPORT, aboutday);
                details.put(Config6.REPORT_DATE, reportdate);

                list.add(details);

            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
        ListAdapter adapter = new SimpleAdapter(
                User.this, list, R.layout.user_cell,
                new String[]{Config6.REPORT_ID, Config6.DAY_REPORT, Config6.FEELING_REPORT, Config6.TODAY_REPORT, Config6.ABOUTDAY_REPORT, Config6.REPORT_DATE},
                new int[]{R.id.reportid, R.id.dayreport, R.id.feeling_report, R.id.today_report, R.id.aboutday_report, R.id.report_date});

        listview.setAdapter(adapter);


    }

    private void getReportData() {


        int number = MESSAGE+4;

        String url = Config7.DATA_URL + number;


        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                showJSON2(response);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(User.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

    private void showJSON2(String response) {
        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray result = jsonObject.getJSONArray(Config7.JSON_ARRAY);

            for (int i = 0; i < result.length(); i++) {
                JSONObject jo = result.getJSONObject(i);
                String rid = jo.getString(Config7.R_ID);
                String sleep = jo.getString(Config7.SLEEP_REPORT);
                String water = jo.getString(Config7.WATER_REPORT);
                String steps = jo.getString(Config7.STEPS_REPORT);
                String rdate = jo.getString(Config7.R_DATE);


                final HashMap<String, String> report = new HashMap<>();
                report.put(Config7.R_ID, rid);
                report.put(Config7.SLEEP_REPORT, sleep);
                report.put(Config7.WATER_REPORT, water);
                report.put(Config7.STEPS_REPORT, steps);
                report.put(Config7.R_DATE, rdate);

                list.add(report);

            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
        ListAdapter adapter = new SimpleAdapter(
                User.this, list, R.layout.report_cell,
                new String[]{Config7.R_ID, Config7.SLEEP_REPORT, Config7.WATER_REPORT, Config7.STEPS_REPORT, Config7.R_DATE},
                new int[]{R.id.rid, R.id.sleepreport, R.id.water_report, R.id.steps_report, R.id.r_date});

        listview2.setAdapter(adapter);
    }

}
