package com.example.myintentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class WebViewActivity extends AppCompatActivity {

    WebView wvIgracias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        wvIgracias = findViewById(R.id.wv_BukaWeb);
        WebSettings webSettings = wvIgracias.getSettings();
        webSettings.setJavaScriptEnabled(true);
        wvIgracias.loadUrl("https://igracias.ittelkom-pwt.ac.id/");
    }
}
