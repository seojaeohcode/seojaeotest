package com.cookandroid.seojaeohtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class startActivity extends AppCompatActivity {
private ConstraintLayout startbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        startbtn = findViewById(R.id.startbtn);
        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(startActivity.this, MainActivity.class));
                //메인으로의 화면전환
            }
        });
    }
}