package com.example.administrator.myapplication;

import android.content.Intent;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        final Intent intent=getIntent();
      /*  String data=intent.getStringExtra("extra_data");
        Log.e("onCreate", "onCreate: "+data );*/
        findViewById(R.id.button_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             /*  Intent intent1=new Intent();
                intent.putExtra("data_return","HelloFirstActivity");
                setResult(RESULT_OK,intent1);*/
                finish();
            }
        });
    }

   @Override
    public void onBackPressed() {
        Intent intent=new Intent();
        intent.putExtra("data_return","Hello FirstActivity");
        setResult(RESULT_OK,intent);
        finish();
    }
}
