package com.example.iiotcamobileapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.messaging.FirebaseMessaging;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "FIREBASE_MESSAGING";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView greetingTextView = findViewById(R.id.greeting_text);
        greetingTextView.setPadding(170,550,0,10);

        Calendar calendar = Calendar.getInstance();
        int timeOfDay = calendar.get(Calendar.HOUR_OF_DAY);

        if(timeOfDay >= 4 && timeOfDay < 12){
            greetingTextView.setText("Good Morning!");
        }else if(timeOfDay >= 12 && timeOfDay < 18){
            greetingTextView.setText("Good Afternoon!");
            greetingTextView.setPadding(130,550,0,10);
        }else if(timeOfDay >= 18 && timeOfDay < 22){
            greetingTextView.setText("Good Evening!");
        }else if(timeOfDay >= 22 || timeOfDay < 3){
            greetingTextView.setText("Good Night!");
            greetingTextView.setPadding(235,550,0,10);
        }

        TextView bottomTextView = findViewById(R.id.bottom_text);
        bottomTextView.setPadding(275,800,0,0);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String body = "";
            for (String key : extras.keySet()) {
                if(key.equals("message")){
                    body = (String) extras.get(key);
                }
            }
            Intent intent = new Intent(MainActivity.this, ConfirmationActivity.class);
            intent.putExtra("msg", body);
            intent.setAction(Long.toString(System.currentTimeMillis())); // extras are not added if there is no action
            startActivity(intent);
        }

        // generate device token
//        FirebaseMessaging.getInstance().getToken()
//                .addOnCompleteListener(task -> {
//                    if (!task.isSuccessful()) {
//                        Log.w(TAG, "Fetching FCM registration token failed", task.getException());
//                        return;
//                    }
//                    Log.d(TAG, "~~~NEW TOKEN:" + task.getResult());
//                });

//        NotificationActivity.createNotificationChannel(this);
//
//        Timer timer = new Timer();
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
////                Intent intent = new Intent(MainActivity.this, NotificationActivity.class);
////                startActivity(intent);
////                finish();
//                NotificationActivity.generateNotifications(MainActivity.this);
//            }
//        }, 3000);

    }

}