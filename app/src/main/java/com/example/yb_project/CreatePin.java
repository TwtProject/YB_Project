package com.example.yb_project;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.goodiebag.pinview.Pinview;


public class CreatePin  extends AppCompatActivity {

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    String pin;
    Pinview pinview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_pin);

        pref =getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        editor = pref.edit();
        pinview = (Pinview)findViewById(R.id.pinview);
        pin = pref.getString("pin", null);

        if (pin!=null){
            Intent intent = new Intent(CreatePin.this, InputPin.class);
            intent.putExtra("pin", pin);
            startActivity(intent);
        }

        pinview.setPinViewEventListener(new Pinview.PinViewEventListener() {
            @Override
            public void onDataEntered(Pinview pinview, boolean fromUser) {
                pinview.setInputType(Pinview.InputType.NUMBER);
                pin = pinview.getValue();
                editor.putString("pin", pinview.getValue());
                editor.apply();
                Intent intent = new Intent(CreatePin.this, InputPin.class);
                intent.putExtra("pin", pin);
                startActivity(intent);
            }
        });

    }
}
