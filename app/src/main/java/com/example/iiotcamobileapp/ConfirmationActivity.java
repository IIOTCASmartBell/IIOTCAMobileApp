package com.example.iiotcamobileapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ConfirmationActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        TextView questionTextView = findViewById(R.id.question_text);
        questionTextView.setPadding(170,350,0,10);

        Button accBtn = (Button)findViewById(R.id.button_acc);
        Button denyBtn = (Button)findViewById(R.id.button_deny);
        accBtn.setOnClickListener(view -> {
            Intent intent = new Intent(ConfirmationActivity.this, MainActivity.class);
            startActivity(intent);
        });

        denyBtn.setOnClickListener(view -> {
            Intent intent = new Intent(ConfirmationActivity.this, MainActivity.class);
            startActivity(intent);
        });

    }

}
