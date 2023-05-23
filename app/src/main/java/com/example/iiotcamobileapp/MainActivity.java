package com.example.iiotcamobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView greetingTextView = findViewById(R.id.greeting_text);
        greetingTextView.setPadding(170,550,0,10);

        Calendar calendar = Calendar.getInstance();
        int timeOfDay = calendar.get(Calendar.HOUR_OF_DAY);

        if(timeOfDay >= 0 && timeOfDay < 12){
            greetingTextView.setText("Good Morning!");
        }else if(timeOfDay >= 12 && timeOfDay < 18){
            greetingTextView.setText("Good Afternoon!");
            greetingTextView.setPadding(130,550,0,10);
        }else if(timeOfDay >= 18 && timeOfDay < 21){
            greetingTextView.setText("Good Evening!");
        }else if(timeOfDay >= 21 && timeOfDay < 24){
            greetingTextView.setText("Good Night!");
            greetingTextView.setPadding(235,550,0,10);
        }

        TextView bottomTextView = findViewById(R.id.bottom_text);
        bottomTextView.setPadding(275,800,0,0);


        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, NotificationActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);

    }

}