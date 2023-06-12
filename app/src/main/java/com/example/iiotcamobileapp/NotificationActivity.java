package com.example.iiotcamobileapp;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

import java.util.Timer;
import java.util.TimerTask;


public class NotificationActivity extends AppCompatActivity {

    static public boolean uiInForeground = true;
    private static final String TAG = "DEBUG_CONFIRMATION";
    private static final int DELAY_TIME = 30; // Delay time in milliseconds
    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
//        if (NotificationActivity.uiInForeground) {
//            Intent intent = new Intent(NotificationActivity.this, ConfirmationActivity.class);
//            startActivity(intent);
//            finish();
//        }
        Log.d(TAG, "It gets here!");

        handler = new Handler();
        if (NotificationActivity.uiInForeground) {
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    startConfirmationActivity();
                }
            }, DELAY_TIME);
        }
    }

    private void startConfirmationActivity() {
        Intent intent = new Intent(NotificationActivity.this, ConfirmationActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
    }

//    protected static void createNotificationChannel(Context context) {
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            NotificationChannel channel = new NotificationChannel("1234", "My notif simulation", NotificationManager.IMPORTANCE_HIGH);
//            channel.setVibrationPattern(new long[]{0, 500});
//            NotificationManager manager = context.getSystemService(NotificationManager.class);
//            manager.createNotificationChannel(channel);
//        }
//
//    }
//
//    protected static void generateNotifications(Context context) {
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            Intent intent = new Intent(context, ConfirmationActivity.class);
////            intent.setAction(Long.toString(System.currentTimeMillis()));
////            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//
//            @SuppressLint("UnspecifiedImmutableFlag") PendingIntent pendingIntent = PendingIntent.getActivity(
//                    context,
//                    1,
//                    intent,
//                    PendingIntent.FLAG_IMMUTABLE
//            );

//            NotificationChannel channel = new NotificationChannel("1234", "My notif simulation", NotificationManager.IMPORTANCE_HIGH);
//            channel.setVibrationPattern(new long[]{0,500});
//            NotificationManager manager = getSystemService(NotificationManager.class);
//            manager.createNotificationChannel(channel);

//            NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "1234")
//                    .setContentIntent(pendingIntent)
//                    .setContentTitle("Look at me!")
//                    .setContentText("This is just a test")
//                    .setAutoCancel(true)
//                    .setSmallIcon(R.drawable.ic_launcher_background);
//
//            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
//            if (ActivityCompat.checkSelfPermission(context, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
//                // TODO: Consider calling
//                //    ActivityCompat#requestPermissions
//                // here to request the missing permissions, and then overriding
//                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//                //                                          int[] grantResults)
//                // to handle the case where the user grants the permission. See the documentation
//                // for ActivityCompat#requestPermissions for more details.
//                return;
//            }
//            notificationManager.notify(1234, builder.build());
//        }
//
//    }

}
