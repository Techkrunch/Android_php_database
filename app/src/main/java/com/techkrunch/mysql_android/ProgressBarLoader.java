package com.techkrunch.mysql_android;

import android.content.Context;
import android.content.Intent;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ProgressBarLoader extends Animation {
private Context ctx;
private ProgressBar pb;
private TextView tv;
private float from;
    private float to;

    public ProgressBarLoader(Context ctx , ProgressBar pb, TextView tv, float from, float to){
        this.ctx=ctx;
        this.pb=pb;
        this.tv=tv;
        this.from=from;
        this.to=to;
    }
    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t ){
        super.applyTransformation(interpolatedTime, t);
        float value = from +(to - from) * interpolatedTime;
        pb.setProgress((int)value);
        tv.setText((int)value +" %");

        if(value == to){
            ctx.startActivity(new Intent(ctx,Mains.class));
//            Intent i=new Intent(getBaseContext(),FirstScreen.class);
//            startActivity(i);
            ((MainActivity) ctx).finish();
            }
    }
}
