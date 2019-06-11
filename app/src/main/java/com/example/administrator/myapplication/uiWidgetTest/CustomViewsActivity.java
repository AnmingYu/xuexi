package com.example.administrator.myapplication.uiWidgetTest;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.administrator.myapplication.R;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class CustomViewsActivity extends AppCompatActivity {
  //  private String [] data={"1","2","3","4","5","6","7","8","9","0","1","2","3","4","5","6","7","8","9","0","1","2","4","3","5","6","7","8","9","0"};
   private List<Fruit> fruits=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_views);
       /* ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null){actionBar.hide();}
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(CustomViewsActivity.this,R.layout.support_simple_spinner_dropdown_item,data);
        ListView listView=(ListView) findViewById(R.id.list_view);
        listView.setAdapter(arrayAdapter);*/
       initFruits();
       FruitAdapter adapter=new FruitAdapter(CustomViewsActivity.this,R.layout.fruit_item,fruits);
       ListView listView=(ListView) findViewById(R.id.list_view);
       listView.setAdapter(adapter);
       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Fruit fruit=fruits.get(position);
               Toast.makeText(CustomViewsActivity.this,fruit.getName(),Toast.LENGTH_SHORT).show();
           }
       });
    }
    public void initFruits(){
        for (int i=0;i<20;i++){
            Fruit app=new Fruit("第"+i+"位",R.drawable.ic_launcher_background);
            fruits.add(app);
        }
    }
}
