package com.example.myapplication.gadsleaderboard;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Splash  extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread t=new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    sleep(800);
                    Intent intent = new Intent(getBaseContext(),MainActivity.class);
                    startActivity(intent);

                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
    }
}