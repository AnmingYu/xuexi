package com.example.administrator.myapplication;

import android.content.Intent;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.administrator.myapplication.activity.DialogActivity;
import com.example.administrator.myapplication.activity.NormalActivity;
import com.example.administrator.myapplication.guangbo.Main4Activity;
import com.example.administrator.myapplication.recyclerView.Main2Activity;
import com.example.administrator.myapplication.suipian.Main3Activity;
import com.example.administrator.myapplication.uiWidgetTest.CustomViewsActivity;
import com.example.administrator.myapplication.uiWidgetTest.MainActivity;
import com.example.administrator.myapplication.xutilsdemo.Main5Activity;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
@ContentView(R.layout.forst_layout)
public class FirstActivity extends AppCompatActivity implements View.OnClickListener {
@ViewInject(R.id.bt_5)
public Button button5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(FirstActivity.this);
        Button butt= findViewById(R.id.button_1);
        Button butt2=findViewById(R.id.bt_1);
        Button butt3=findViewById(R.id.bt_3);
        butt.setOnClickListener(this);
        butt2.setOnClickListener(this);
        butt3.setOnClickListener(this);
        button5.setOnClickListener(this);
        if (savedInstanceState!=null){
            String tempData=savedInstanceState.getString("data_key");
            Log.e("onCreate ", "onCreate: "+tempData );
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode){
            case 1:
                if (resultCode==RESULT_OK){
                    String returnedData=data.getStringExtra("data_return");
                    Log.e("onActivityResult", "onActivityResult: "+returnedData );
                }
                break;
                default:
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this,"You clicked Add ",Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this,"You clicked Remove ",Toast.LENGTH_SHORT).show();
                break;

                default:
        }
        return true;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String tempData="Hello 病毒君";
        outState.putString("data_key",tempData);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_1:
                startActivity(new Intent(FirstActivity.this,Main4Activity.class));
                break;
            case R.id.bt_1:
                startActivity(new Intent(FirstActivity.this,CustomViewsActivity.class));
                break;
            case R.id.bt_3:
                startActivity(new Intent(FirstActivity.this,Main3Activity.class));
                break;
            case R.id.bt_5:
                startActivity(new Intent(FirstActivity.this,Main5Activity.class));
                break;
                default:
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }
}
