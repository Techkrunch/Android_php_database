package com.techkrunch.mysql_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
//        getSupportActionBar().setTitle("DETAILS");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void Logout(View v){
        Intent intent = new Intent(details.this, Mains.class);
    startActivity(intent);
    finish();
}
}
