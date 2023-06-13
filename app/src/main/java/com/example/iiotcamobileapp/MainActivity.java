package com.example.iiotcamobileapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
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
            String label = "";

            DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
            DatabaseReference actionsRef = rootRef.child("actions");

            for (String key : extras.keySet()) {
                body = (String) extras.get("message");
                label = (String) extras.get("label");

                switch(label){
                    case "default":   Intent intent = new Intent(MainActivity.this, ConfirmationActivity.class);
                                      intent.putExtra("msg", body);
                                      intent.setAction(Long.toString(System.currentTimeMillis())); // extras are not added if there is no action
                                      startActivity(intent);
                                      break;
                    case "greenlist": actionsRef.child("access").setValue(Boolean.valueOf("true"));
                                      actionsRef.child("print").setValue(Boolean.valueOf("true"));
                                      break;
                    case "blacklist": actionsRef.child("access").setValue(Boolean.valueOf("false"));
                                      actionsRef.child("print").setValue(Boolean.valueOf("true"));
                                      break;
                    default: System.out.println("what");
                }
            }
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


    }

}