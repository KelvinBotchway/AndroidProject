package com.example.userregis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class bookdetails extends AppCompatActivity {

    TextInputEditText textInputEditTextAge, textInputEditTextAddress, textInputEditTextWeight, textInputEditTextBookingDay, textInputEditTextSymptoms;
    Button buttonSubmit;
    TextView textView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookdetails);
        textInputEditTextAge = findViewById(R.id.Age);
        textInputEditTextAddress = findViewById(R.id.Address);
        textInputEditTextWeight = findViewById(R.id.Weight);
        textInputEditTextBookingDay = findViewById(R.id.BookingDay);
        textInputEditTextSymptoms = findViewById(R.id.Symptoms);
        buttonSubmit = findViewById(R.id.buttonSubmit);
        progressBar = findViewById(R.id.progressBar);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Age, Address, Weight, BookingDay, Symptoms;
                Age = String.valueOf(textInputEditTextAge.getText());
                Address = String.valueOf(textInputEditTextAddress.getText());
                Weight = String.valueOf(textInputEditTextWeight.getText());
                BookingDay = String.valueOf(textInputEditTextBookingDay.getText());
                Symptoms = String.valueOf(textInputEditTextSymptoms.getText());

                if (!Age.equals("") && !Address.equals("") && !Weight.equals("") && !BookingDay.equals("") &&!Symptoms.equals(""))

                    progressBar.setVisibility(View.VISIBLE);
                Handler handler = new Handler();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        //Starting Write and Read data with URL
                        //Creating array for parameters
                        String[] field = new String[5];
                        field[0] = "Age";
                        field[1] = "Address";
                        field[2] = "Weight";
                        field[3] = "BookingDay";
                        field[4] = "Symptoms";

                        //Creating array for data
                        String[] data = new String[5];
                        data[0] = Age;
                        data[1] = Address;
                        data[2] = Weight;
                        data[3] = BookingDay;
                        data[4] = Symptoms;
                        PutData putData = new PutData("http://192.168.43.175/UserRegis/BookingDay.php", "POST", field, data);
                        if (putData.startPut()) {

                            if (putData.onComplete()) {
                                progressBar.setVisibility(View.GONE);
                                String result = putData.getResult();
                                if (result.equals("Booking Success")){
                                    Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(), booksuccess.class);
                                    startActivity(intent);
                                    finish();
                                }
                                else{
                                    Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                        //End Write and Read data with URL
                    }
                });
            }

            });
        }
    }
