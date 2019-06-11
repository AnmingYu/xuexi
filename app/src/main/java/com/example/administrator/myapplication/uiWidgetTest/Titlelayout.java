package com.example.administrator.myapplication.uiWidgetTest;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.administrator.myapplication.R;

public class Titlelayout extends LinearLayout {
    public Titlelayout(Context context) {
        super(context);
    }

    public Titlelayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title,this);
        ceshi();
    }
    public void ceshi(){
        Button title1=(Button) findViewById(R.id.title_back);
        Button title2=(Button) findViewById(R.id.title_edit);
        title1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity) getContext()).finish();
            }
        });
        title2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"You clicked Edit button",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
