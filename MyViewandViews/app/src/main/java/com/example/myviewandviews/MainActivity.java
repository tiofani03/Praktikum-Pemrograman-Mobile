package com.example.myviewandviews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btn_Donasi);
        btn.setOnClickListener(this);

        if(getSupportActionBar()!=null){
            getSupportActionBar().setTitle("BJ Habibie");
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_Donasi:
                Intent intent = new Intent(this,FormDonasiActivity.class);
                startActivity(intent);
                break;
        }
    }
}
