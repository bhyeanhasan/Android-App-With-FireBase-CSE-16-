package com.example.cse16;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

public class loading extends AppCompatActivity {

    private ProgressBar bar;
    private int ii;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);



        bar = findViewById(R.id.progress);

        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {


                for (ii = 25; ii <= 100; ii += 25) {
                    try
                    {
                        Thread.sleep(500);
                        bar.setProgress(ii);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }

                }

                Intent in = new Intent(loading.this,MainActivity.class);
                startActivity(in);
                finish();

            }
        });

        th.start();


    }
}
