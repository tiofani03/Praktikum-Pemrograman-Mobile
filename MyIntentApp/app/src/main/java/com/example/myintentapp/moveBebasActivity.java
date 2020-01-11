package com.example.myintentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class moveBebasActivity extends AppCompatActivity {

    public static final String EXTRA_DATAa = "Kosong";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_bebas);

        TextView tvData = findViewById(R.id.tv_KirimData);

        tvData.setText(getIntent().getStringExtra(EXTRA_DATAa));

    }
}
