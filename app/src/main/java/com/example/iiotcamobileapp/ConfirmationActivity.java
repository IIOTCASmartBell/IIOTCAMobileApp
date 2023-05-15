package com.example.iiotcamobileapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ConfirmationActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, RequestSentActivity.class);
        startActivity(intent);

//        TextView questionTextView = findViewById(R.id.question_text);
//        questionTextView.setPadding(170,550,0,10);
    }
}
