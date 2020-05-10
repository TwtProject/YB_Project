package com.example.yb_project;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.yb_project.view.dashboard.DashboardActivity;
import com.goodiebag.pinview.Pinview;

import java.util.Objects;

public class InputPin extends AppCompatActivity {

    String pin;
    Pinview pinview;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_pin);
        Intent intent = getIntent();
        pin = intent.getStringExtra("pin");

        pinview = (Pinview)findViewById(R.id.pinview);

        pinview.setPinViewEventListener(new Pinview.PinViewEventListener() {
            @Override
            public void onDataEntered(Pinview pinview, boolean fromUser) {
                String dataPin = pinview.getValue();

                boolean cek = Objects.equals(pin, dataPin);
                if (cek){
                    Intent intent = new Intent(InputPin.this, DashboardActivity.class);
                    startActivity(intent);
                    Log.d(pin, "Saved Pin: " + pinview.getValue());
                }else{
                   Toast.makeText(getApplicationContext(), "Pin Tidak Sama", Toast.LENGTH_LONG).show();
                   Log.d(pin, "onCreate: " + pin);
               }
            }
        });
    }
}
