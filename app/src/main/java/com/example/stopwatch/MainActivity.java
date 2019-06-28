package com.example.stopwatch;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {
    Button start;
    Button pause;
    Button reset;
    Chronometer stopwatch;
    Boolean running = false;
    long pauseoffset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = findViewById(R.id.Button1);
        pause = findViewById(R.id.Button2);
        reset = findViewById(R.id.Button3);
        stopwatch = findViewById(R.id.chronometer);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!running){
                    stopwatch.setBase(SystemClock.elapsedRealtime() - pauseoffset);
                    stopwatch.start();
                    running = true;
                }
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (running){
                    pauseoffset = SystemClock.elapsedRealtime()-stopwatch.getBase();
                    stopwatch.stop();
                    running = false;
                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopwatch.stop();
                running = false;
                stopwatch.setBase(SystemClock.elapsedRealtime());
                pauseoffset = 0;
            }
        });
    }

}
