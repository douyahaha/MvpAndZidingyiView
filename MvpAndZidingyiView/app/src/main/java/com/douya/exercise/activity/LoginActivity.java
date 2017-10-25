package com.douya.exercise.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.douya.exercise.R;
import com.douya.exercise.myView.CircleView;

public class LoginActivity extends AppCompatActivity {

    private CircleView mCircle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    sleep(5000);
                    startActivity(new Intent(LoginActivity.this,MainActivity.class));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    private void initView() {
        mCircle = (CircleView) findViewById(R.id.mCircle);
    }
}
