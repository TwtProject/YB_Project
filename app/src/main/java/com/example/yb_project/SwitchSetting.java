package com.example.yb_project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import com.example.yb_project.view.dashboard.DashboardActivity;

public class SwitchSetting extends AppCompatActivity {

    SwitchCompat switchCompat;
    Button btSimpan, btBatal;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        switchCompat = findViewById(R.id.switch_compat);
        btSimpan = findViewById(R.id.btn_simpan);
        btBatal = findViewById(R.id.btn_batal);

        SharedPreferences sharedPreferences = getSharedPreferences("save"
                ,MODE_PRIVATE);
        switchCompat.setChecked(sharedPreferences.getBoolean("value", true));

        btSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switchCompat.isChecked()){
                    SharedPreferences.Editor editor = getSharedPreferences("save"
                            ,MODE_PRIVATE).edit();
                    editor.putBoolean("value", true);
                    editor.apply();
                    switchCompat.setChecked(true);
                }else{
                    SharedPreferences.Editor editor = getSharedPreferences("save"
                            ,MODE_PRIVATE).edit();
                    editor.putBoolean("value", false);
                    editor.apply();
                    switchCompat.setChecked(false);
                }
                Intent intent = new Intent(SwitchSetting.this, DashboardActivity.class);
                startActivity(intent);
            }
        });

        btBatal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SwitchSetting.this, DashboardActivity.class);
                startActivity(intent);
            }
        });
    }
}
