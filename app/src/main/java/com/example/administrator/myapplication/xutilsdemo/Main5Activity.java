package com.example.administrator.myapplication.xutilsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.administrator.myapplication.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.activity_main5)
public class Main5Activity extends AppCompatActivity {
    @ViewInject(R.id.bt_main5)
    public Button btMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(Main5Activity.this);

    }
    @Event(R.id.bt_main5)
    private void onClick(View view){
        switch (view.getId()){
            case R.id.bt_main5:
                Toast.makeText(Main5Activity.this,"dianijia",Toast.LENGTH_SHORT).show();
                break;
                default:
        }

    }
}
