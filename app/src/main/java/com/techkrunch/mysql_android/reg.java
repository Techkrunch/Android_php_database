package com.techkrunch.mysql_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class reg extends AppCompatActivity {
    EditText ET_NAMES, ET_UNAME, ET_EMAIL, ET_PWD;
    String nameS, Uname, Email, Pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        ET_NAMES = (EditText) findViewById(R.id.et_names);
        ET_UNAME = (EditText) findViewById(R.id.et_uname);
        ET_EMAIL = (EditText) findViewById(R.id.et_email);
        ET_PWD = (EditText) findViewById(R.id.et_pwd);
//        getSupportActionBar().setTitle("Account Creation");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void userReg(View v) {
        nameS = ET_NAMES.getText().toString();
        Uname = ET_UNAME.getText().toString();
        Pwd = ET_PWD.getText().toString();
        Email = ET_EMAIL.getText().toString();
        EditText[] txs = {ET_NAMES, ET_UNAME, ET_PWD, ET_EMAIL};


            if (ET_NAMES.getText().toString().trim().isEmpty()) {
                Toast.makeText(this, "Names Are Required!", Toast.LENGTH_SHORT).show();
                ET_NAMES.requestFocus();
                 }
                 else if (ET_UNAME.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Username is Required!", Toast.LENGTH_SHORT).show();
                ET_NAMES.requestFocus();
                 }else if (ET_PWD.getText().toString().trim().isEmpty()) {
                Toast.makeText(this, "Password is Required!", Toast.LENGTH_SHORT).show();
                ET_PWD.requestFocus();
                 }else if (ET_EMAIL.getText().toString().trim().isEmpty()) {
                Toast.makeText(this, "A Valid Email is Required!", Toast.LENGTH_SHORT).show();
                ET_EMAIL.requestFocus();
                 }else {
String method = "register";
                BackgroundTask backgroundTask = new BackgroundTask(this);
                backgroundTask.execute(method, nameS, Uname, Pwd, Email);
                //  finish();
            }
        }
    }

