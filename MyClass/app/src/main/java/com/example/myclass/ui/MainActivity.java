package com.example.myclass.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myclass.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnlihatData = findViewById(R.id.lihatbtn);
        Button btninputData = findViewById(R.id.inputbtn);
        Button btninformasi = findViewById(R.id.infobtn);

        btnlihatData.setOnClickListener(this);
        btninputData.setOnClickListener(this);
        btninformasi.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.lihatbtn:
                Intent intent = new Intent(this,LihatDataActivity.class);
                startActivity(intent);
                break;

            case R.id.inputbtn:
                Intent intent1 = new Intent(this,InputDataActivity.class);
                startActivity(intent1);
                break;

            case R.id.infobtn:
                Intent intent2 = new Intent(this,InformasiActivity.class);
                startActivity(intent2);
                break;
        }
    }
}
