package com.example.wellbeingproject;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
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

public class Mentor extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private Toolbar toolbar;
    public static int MESSAGE;
    EditText txtvalue;
    Button btnfetch;
    ListView listview;
    int count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mentor);
        txtvalue = (EditText)findViewById(R.id.editText);
        btnfetch = (Button)findViewById(R.id.buttonfetch);
        listview = (ListView)findViewById(R.id.list);

        getData();

        btnfetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getData();
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

        listview.setOnItemClickListener(Mentor.this);



    }//end of onCreate method

    private void getData() {

        String value = txtvalue.getText().toString().trim();


        String url = Config5.DATA_URL + value;



        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                showJSON(response);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Mentor.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

    private void showJSON(String response) {
        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray result = jsonObject.getJSONArray(Config5.JSON_ARRAY);

            for (int i = 0; i < result.length(); i++) {
                JSONObject jo = result.getJSONObject(i);
                String id = jo.getString(Config5.ID);
                String fname = jo.getString(Config5.FIRST_NAME);
                String sname = jo.getString(Config5.SECOND_NAME);
                String uname = jo.getString(Config5.SECOND_NAME);


                final HashMap<String, String> users = new HashMap<>();
                users.put(Config5.ID,  id);
                users.put(Config5.FIRST_NAME,  fname);
                users.put(Config5.SECOND_NAME, sname);

                list.add(users);

            }


        } catch (JSONException e) {
            e.printStackTrace();
        }

        ListAdapter adapter = new SimpleAdapter(
                Mentor.this, list, R.layout.mylist,
                new String[]{Config5.ID, Config5.FIRST_NAME, Config5.SECOND_NAME},
                new int[]{R.id.id, R.id.firstName, R.id.secondName});

        listview.setAdapter(adapter);

    }

    @Override
    public void onItemClick(AdapterView<?> adapter,View arg1, int position, long arg3) {
        //TODO Auto-generated method stub
        Intent i = new Intent(Mentor.this, User.class);

        MESSAGE = position;

        startActivity(i);
        finish();

    }//end of onItemClick


}


