package com.example.administrator.myapplication.suipian;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.administrator.myapplication.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Button button=findViewById(R.id.button_leftFragment);
        button.setOnClickListener(this);
        replaceFragment(new RightFragment());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_leftFragment:
                replaceFragment(new AnotherRightFragment());
                break;
                default:
        }
    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.replace(R.id.right_fragment,fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
