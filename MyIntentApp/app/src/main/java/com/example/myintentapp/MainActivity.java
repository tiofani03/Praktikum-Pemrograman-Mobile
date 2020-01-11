package com.example.myintentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnMove,btnMoveActivityWithData,btnDial,btnOpenWeb,btnEx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMove = findViewById(R.id.btn_moveActivity);
        btnMoveActivityWithData = findViewById(R.id.btn_moveActivityWithData);
        btnDial = findViewById(R.id.btn_Call);
        btnOpenWeb = findViewById(R.id.btn_OpenWeb);
        btnEx = findViewById(R.id.btn_IntentEx);


        btnMove.setOnClickListener(this);
        btnMoveActivityWithData.setOnClickListener(this);
        btnDial.setOnClickListener(this);
        btnOpenWeb.setOnClickListener(this);
        btnEx.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btn_moveActivity:
                Intent intent = new Intent(this,MoveActivity.class);
                startActivity(intent);
                break;

            case R.id.btn_moveActivityWithData:
                Intent moveWithData = new Intent(this, MoveWithDataActivity.class);
                moveWithData.putExtra(MoveWithDataActivity.EXTRA_NAME,"Tio Fani");
                moveWithData.putExtra(MoveWithDataActivity.EXTRA_AGE,19);
                startActivity(moveWithData);
                break;

            case R.id.btn_Call:
                String nomor = "082137138344";
                Intent call = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+nomor));
                startActivity(call);
                break;

            case R.id.btn_OpenWeb:
                String url = "https://igracias.ittelkom-pwt.ac.id";
                Intent web = new Intent(Intent.ACTION_VIEW,Uri.parse(url));
                //Intent web = new Intent(this,WebViewActivity.class); // Jika membuka web menggunakan webview
                startActivity(web);
                break;

            case R.id.btn_IntentEx:
                Intent eks = new Intent(this, MoveEksplisitActivity.class);
                startActivity(eks);
                break;

        }

    }
}
