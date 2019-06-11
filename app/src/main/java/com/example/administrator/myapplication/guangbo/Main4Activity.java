package com.example.administrator.myapplication.guangbo;

import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import com.example.administrator.myapplication.R;
import com.squareup.picasso.Picasso;

import org.xutils.view.annotation.ContentView;
import org.xutils.x;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class Main4Activity extends AppCompatActivity {
    private IntentFilter intentFilter;
    private LocalBroadcastManager localBroadcastManager;
    private LocalReceiver localReceiver;

    private NetworkChangeReceiver networkChangeReceiver;
    private static final String url="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1560163089603&di=ba2699cd13dc473144b2b97e01ff0ea2&imgtype=0&src=http%3A%2F%2Fmmbiz.qpic.cn%2Fmmbiz_png%2FCgCQuzkMKHb53ibibZpjybBCRXo5j2ghnibfyUlTBcJk6GDh3rKTZ1ubABrmeYEkJrd56FXUrFctr8ELJkVrJicqiaw%2F0%3Fwx_fmt%3Dpng";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        init();
     ImageView imageView=(ImageView) findViewById(R.id.iv_main4);
        Picasso.with(Main4Activity.this).load(url).into(imageView);
    }

    public void init(){
        localBroadcastManager =LocalBroadcastManager.getInstance(this);
       Button button=(Button) findViewById(R.id.button_main4);
       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent("com.example.broadcasttest.LOCAL_BROADCAST");
               localBroadcastManager.sendBroadcast(intent);

           }
       });
       intentFilter=new IntentFilter();
       intentFilter.addAction("com.example.broadcasttest.LOCAL_BROADCAST");
       localReceiver=new LocalReceiver();
       localBroadcastManager.registerReceiver(localReceiver,intentFilter);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        localBroadcastManager.unregisterReceiver(localReceiver);
       // unregisterReceiver(networkChangeReceiver);
    }
    class LocalReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context,"received local broadcast",Toast.LENGTH_SHORT).show();
        }
    }

    class NetworkChangeReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager=(ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();
            if (networkInfo!=null&&networkInfo.isAvailable()){
                Toast.makeText(context,"有网",Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(context,"没网",Toast.LENGTH_SHORT).show();
            }

        }
    }
}
