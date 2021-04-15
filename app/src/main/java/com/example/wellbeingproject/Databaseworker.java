package com.example.wellbeingproject;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class Databaseworker extends AsyncTask<String, String, String> {
    Context context;
    AlertDialog alertDialog;
    Databaseworker (Context cntx) {
        context = cntx;
    }

    @Override
    protected String doInBackground(String... params) {
        //checks first string which is passed when accessing database
        String type = params[0];
        String login_url = "https://sjogwellbeingapp.com/login.php";
        String subreport_url = "https://sjogwellbeingapp.com/subreport.php";
        //if the param is equal to login it will proceed with login function
        if(type.equals("login")) {
            //establish connection with database
            try {
                String username = params[1];
                String password = params[2];
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                //output stream to send to database
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("username", "UTF-8") +"="+URLEncoder.encode(username, "UTF-8")+"&"
                        +URLEncoder.encode("password", "UTF-8") +"="+URLEncoder.encode(password, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                //input stream to recieve from database
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result="";
                String line="";
                //reads the response from server
                while((line = bufferedReader.readLine())!= null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(type.equals("subreport")) {
            //establish connection with database
            try {
                String username = params[1];
                String day_report = params[2];
                String feeling_report = params[3];
                String today_report = params[4];
                String aboutday_report = params[5];
                String date = params[6];
                URL url = new URL(subreport_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                //output stream to send to database
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("username", "UTF-8") +"="+URLEncoder.encode(username, "UTF-8")+"&"
                        +URLEncoder.encode("day_report", "UTF-8") +"="+URLEncoder.encode(day_report, "UTF-8")+"&"
                        +URLEncoder.encode("feeling_report", "UTF-8") +"="+URLEncoder.encode(feeling_report, "UTF-8")+"&"
                        +URLEncoder.encode("today_report", "UTF-8") +"="+URLEncoder.encode(today_report, "UTF-8")+"&"
                        +URLEncoder.encode("aboutday_report", "UTF-8") +"="+URLEncoder.encode(aboutday_report, "UTF-8")+"&"
                        +URLEncoder.encode("date", "UTF-8") +"="+URLEncoder.encode(date, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                //input stream to recieve from database
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String reportresult="";
                String line="";
                //reads the response from server
                while((line = bufferedReader.readLine())!= null) {
                    reportresult += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return reportresult;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(type.equals("tracker")) {
            //establish connection with database
            try {
                String username = params[1];
                String sleep_report = params[2];
                String water_report = params[3];
                String steps_report = params[4];
                String report_date = params[5];
                URL url = new URL(subreport_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                //output stream to send to database
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("username", "UTF-8") +"="+URLEncoder.encode(username, "UTF-8")+"&"
                        +URLEncoder.encode("sleep_report", "UTF-8") +"="+URLEncoder.encode(sleep_report, "UTF-8")+"&"
                        +URLEncoder.encode("water_report", "UTF-8") +"="+URLEncoder.encode(water_report, "UTF-8")+"&"
                        +URLEncoder.encode("steps_report", "UTF-8") +"="+URLEncoder.encode(steps_report, "UTF-8")+"&"
                        +URLEncoder.encode("report_date", "UTF-8") +"="+URLEncoder.encode(report_date, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                //input stream to recieve from database
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String trackerresult="";
                String line="";
                //reads the response from server
                while((line = bufferedReader.readLine())!= null) {
                    trackerresult += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return trackerresult;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Login Status");
    }

    @Override
    protected void onPostExecute(String result) {
        if(!result.equals("invalid username / password"))
        {
            Login.logged_in = true;
        }
        alertDialog.setMessage(result);
        alertDialog.show();
        Toast.makeText(context.getApplicationContext(),result, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
    }
}
