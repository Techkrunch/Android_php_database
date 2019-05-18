package com.techkrunch.mysql_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Mains extends AppCompatActivity {
    EditText etname,etpass;
    String loginpass,loginuname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mains);
        etname = (EditText) findViewById(R.id.uname) ;
        etpass = (EditText) findViewById(R.id.pwd);
    }

    public void openRegister(View v)
    {
        Intent i = new Intent(this,reg.class);
        startActivity(i);
        etname.setText("");
        etpass.setText("");
    }

    public void loginActivity(View v){
                loginuname= etname.getText().toString();
        loginpass= etpass.getText().toString();



            if (etname.getText().toString().trim().isEmpty()) {
                Toast.makeText(this, "Username is Required", Toast.LENGTH_SHORT).show();
                etname.requestFocus();
            }else if (etpass.getText().toString().trim().isEmpty()) {
                Toast.makeText(this, "Password is Required", Toast.LENGTH_SHORT).show();
                etpass.requestFocus();
            }else {
                String method ="login";
//        Toast.makeText(MainActivity.this, loginuname.toString(), Toast.LENGTH_LONG).show();
//        Toast.makeText(MainActivity.this, loginpass.toString(), Toast.LENGTH_LONG).show();
                BackgroundTask backgroundTask = new BackgroundTask(this);
                backgroundTask.execute(method,loginuname,loginpass);

            }


        }

}
