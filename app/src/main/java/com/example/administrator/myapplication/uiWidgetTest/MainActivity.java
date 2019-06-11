package com.example.administrator.myapplication.uiWidgetTest;

import android.content.DialogInterface;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.administrator.myapplication.R;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editText;
    private ImageView imageView;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        opendUrl();
    }
    public void init(){
        Button button=(Button) findViewById(R.id.bt_ceshi);
        editText=(EditText) findViewById(R.id.et_content);
        imageView=(ImageView) findViewById(R.id.iv_ceshi);
        progressBar=(ProgressBar) findViewById(R.id.pb_1);
        button.setOnClickListener(this);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_ceshi:
               /* String inputText =editText.getText().toString();
                Toast.makeText(MainActivity.this,inputText,Toast.LENGTH_SHORT).show();
                imageView.setImageResource(R.color.colorAccent);*/
                if (progressBar.getVisibility()==View.GONE){
                    progressBar.setVisibility(View.VISIBLE);
                }else {
                    progressBar.setVisibility(View.GONE);
                }
                int progress=progressBar.getProgress();
                progress=progress+10;
                progressBar.setProgress(progress);
                alertDialogName();
                break;
                default:
        }
    }
    //AlertDialog 弹出框
    public void alertDialogName(){

        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("测试学习Android");
        builder.setMessage("Something important");
        builder.setCancelable(false);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();
    }
    public void opendUrl(){
        try {
            URL url=new URL("http://www.baidu.com ");
            HttpURLConnection connection=(HttpURLConnection) url.openConnection();
            int nRC=connection.getResponseCode();
            if (nRC==HttpURLConnection.HTTP_OK){
                Log.e("opendUrl", "opendUrl: ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
