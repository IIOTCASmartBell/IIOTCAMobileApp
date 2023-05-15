package com.example.iiotcamobileapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import java.util.Calendar;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextView greetingTextView = findViewById(R.id.greeting_text);
        greetingTextView.setPadding(170,550,0,10);

        Calendar calendar = Calendar.getInstance();
        int timeOfDay = calendar.get(Calendar.HOUR_OF_DAY);

        if(timeOfDay >= 0 && timeOfDay < 12){
            greetingTextView.setText("Good Morning!");
        }else if(timeOfDay >= 12 && timeOfDay < 18){
            greetingTextView.setText("Good Afternoon!");
        }else if(timeOfDay >= 18 && timeOfDay < 21){
            greetingTextView.setText("Good Evening!");
        }else if(timeOfDay >= 21 && timeOfDay < 24){
            greetingTextView.setText("Good Night!");
        }

        TextView bottomTextView = findViewById(R.id.bottom_text);
        bottomTextView.setPadding(275,800,0,0);

        String hostname = "raspberrypi9";
        subscribeToNotificationTopic(hostname);

    }


    private void subscribeToNotificationTopic(String hostname){
//        FirebaseApp.initializeApp(this);
//        FirebaseMessaging.getInstance().subscribeToTopic(hostname);
    }

}
