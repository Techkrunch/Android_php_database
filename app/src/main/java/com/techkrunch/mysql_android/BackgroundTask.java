package com.techkrunch.mysql_android;

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

public class BackgroundTask extends AsyncTask<String, Void, String> {

    AlertDialog alertDialog;
    Context ctx;

    BackgroundTask(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    protected void onPreExecute() {
//      super.onPreExecute();
        alertDialog = new AlertDialog.Builder(ctx).create();
        alertDialog.setTitle("Login Information...");
    }

    @Override
    protected String doInBackground(String... params) {
        String reg_url = "http://techkrunch.000webhostapp.com/signup.php";
        String login_url = "http://techkrunch.000webhostapp.com/login.php";
        String method = params[0];
        if (method.equals("register")) {
            String Names = params[1];
            String uname = params[2];
            String pwd = params[3];
            String email = params[4];
             try {
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
                String data = URLEncoder.encode("db_Names", "UTF-8") + "=" + URLEncoder.encode(Names, "UTF-8")
                        + "&" + URLEncoder.encode("db_uname", "UTF-8") + "=" + URLEncoder.encode(uname, "UTF-8")
                        + "&" + URLEncoder.encode("db_pwd", "UTF-8") + "=" + URLEncoder.encode(pwd, "UTF-8")
                        + "&" + URLEncoder.encode("db_email", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8") ;
                 bufferedWriter.write(data);
                 bufferedWriter.flush();
                 bufferedWriter.close();
                 OS.close();
//                    InputStream IS = httpURLConnection.getInputStream();
//                    IS.close();
                 InputStream inputStream = httpURLConnection.getInputStream();
                 BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                 String response = "";
                 String line = "";
                 while ((line = bufferedReader.readLine()) != null) {
                     response = line;
                 }
                 bufferedReader.close();
                 inputStream.close();
                 httpURLConnection.disconnect();
                 return response;
//                    return "Successful";

             } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            if (method.equals("login")) {
                String login_address = params[1];
                String login_id = params[2];
                try {
                    URL url = new URL(login_url);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                    String data = URLEncoder.encode("log_email", "UTF-8") + "=" + URLEncoder.encode(login_address, "UTF-8")
                            + "&" + URLEncoder.encode("log_id", "UTF-8") + "=" + URLEncoder.encode(login_id, "UTF-8");
                    bufferedWriter.write(data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();
//                    InputStream IS = httpURLConnection.getInputStream();
//                    IS.close();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                    String response = "";
                    String line = "";
                    while ((line = bufferedReader.readLine()) != null) {
                        response = line;
                    }
                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    return response;
//                    return "Successful";

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {
         if (result.startsWith("Login Success...Welcome")) {
            Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
            Intent intent = new Intent(ctx, details.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            ctx.startActivity(intent);
             ((Mains) ctx).finish();
        } else {
            alertDialog.setMessage(result);
            alertDialog.show();
        }
    }

}
