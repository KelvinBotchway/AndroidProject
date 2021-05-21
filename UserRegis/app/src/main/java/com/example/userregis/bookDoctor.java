package com.example.userregis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class bookDoctor extends AppCompatActivity {

    Button Monbtn;
    Button Tuebtn;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_doctor);

        Button Monbtn = findViewById(R.id.Monbtn);

        Monbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Monbtn;
            }
        });

    }
}