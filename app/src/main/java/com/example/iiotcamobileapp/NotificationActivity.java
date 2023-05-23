package com.example.iiotcamobileapp;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class NotificationActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        generateNotifications();
    }

    protected void generateNotifications() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            Intent intent = new Intent(this, ConfirmationActivity.class);
            intent.setAction(Long.toString(System.currentTimeMillis()));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

            @SuppressLint("UnspecifiedImmutableFlag") PendingIntent pendingIntent = PendingIntent.getActivity(
                    getApplicationContext(),
                    1,
                    intent,
                    PendingIntent.FLAG_IMMUTABLE
            );

            NotificationChannel channel = new NotificationChannel("1234", "My notif simulation", NotificationManager.IMPORTANCE_HIGH);
            channel.setVibrationPattern(new long[]{0,500});
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);

            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "1234")
                    .setContentIntent(pendingIntent)
                    .setContentTitle("Look at me!")
                    .setContentText("This is just a test")
                    .setAutoCancel(true)
                    .setSmallIcon(R.drawable.ic_launcher_background);

            manager.notify(1234, builder.build());
            startActivity(intent);
        }

    }

}
