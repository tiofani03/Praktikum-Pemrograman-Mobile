package com.example.myintentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MoveEksplisitActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnEks;
    EditText etTeks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_eksplisit);

        etTeks = findViewById(R.id.et_Teks);

        btnEks = findViewById(R.id.btn_moveEksplist);
        btnEks.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_moveEksplist:
                Intent intent = new Intent(this,moveBebasActivity.class);
                intent.putExtra(moveBebasActivity.EXTRA_DATAa,etTeks.getText().toString());
                startActivity(intent);
                finish();
                break;

        }

    }
}
