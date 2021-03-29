package com.example.myapplication10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    private Chronometer chronometer;
    private ImageButton start, setBase;
    long stoptime;
    int times;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        times=0;
        stoptime=0;
        chronometer = (Chronometer) findViewById(R.id.chronometer);
        chronometer.setFormat("%s");
        chronometer.setBase(SystemClock.elapsedRealtime());
        start = (ImageButton) findViewById(R.id.start);
        setBase = (ImageButton) findViewById(R.id.setBase);
        start.setOnClickListener(this::onClick);
        setBase.setOnClickListener(this::onClick);
    }

    public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.start:
                        if (times==0){
                            chronometer.setBase(SystemClock.elapsedRealtime());
                            chronometer.start();
                            times=1;
                        }else if(times==1){
                            stoptime=SystemClock.elapsedRealtime()-chronometer.getBase();
                            chronometer.stop();
                            times=2;
                        }else {
                            chronometer.setBase(SystemClock.elapsedRealtime()-stoptime);
                            chronometer.start();
                            times=1;
                        }

                        break;


                    case R.id.setBase:
                        chronometer.stop();
                        chronometer.setBase(SystemClock.elapsedRealtime());
                        times=0;
                        break;
                }

            }

        }