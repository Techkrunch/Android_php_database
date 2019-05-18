package com.techkrunch.mysql_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
ProgressBar pb;
TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        pb=findViewById(R.id.progress_bar);
        tv=findViewById(R.id.text_view);
    pb.setMax(100);
    pb.setScaleY(3f);
    progressLoader();
    }

public  void progressLoader(){
        ProgressBarLoader pbl = new ProgressBarLoader( this, pb,tv, 0f,100f);
        pbl.setDuration(8000);
        pb.setAnimation(pbl);

}
}
