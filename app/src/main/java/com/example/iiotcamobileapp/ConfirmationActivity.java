package com.example.iiotcamobileapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ConfirmationActivity extends AppCompatActivity {

    private static final String TAG = "FIREBASE_MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        String message = getIntent().getStringExtra("msg");

        TextView questionTextView = findViewById(R.id.question_text);
        questionTextView.setPadding(130,350,0,10);
        questionTextView.setText(message);

        Button accBtn = (Button)findViewById(R.id.button_acc);
        Button denyBtn = (Button)findViewById(R.id.button_deny);
        accBtn.setOnClickListener(view -> {
            DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
            DatabaseReference actionsRef = rootRef.child("actions");
            actionsRef.child("access").setValue("true");
            Intent intent = new Intent(ConfirmationActivity.this, MainActivity.class);
            startActivity(intent);
        });

        denyBtn.setOnClickListener(view -> {
            DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
            DatabaseReference actionsRef = rootRef.child("actions");
            actionsRef.child("access").setValue("false");
            Intent intent = new Intent(ConfirmationActivity.this, MainActivity.class);
            startActivity(intent);
        });

    }

}
