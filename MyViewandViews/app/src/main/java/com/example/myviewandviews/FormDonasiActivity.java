package com.example.myviewandviews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

public class FormDonasiActivity extends AppCompatActivity {

    EditText etCatatan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_donasi);

        if(getSupportActionBar()!=null){
            getSupportActionBar().setTitle("Form Donasi");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        etCatatan = findViewById(R.id.et_catatan);


        etCatatan.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(v.getId() == R.id.et_catatan){
                    v.getParent().requestDisallowInterceptTouchEvent(true);
                    switch (event.getAction() & MotionEvent.ACTION_MASK){
                        case MotionEvent.ACTION_UP:
                            v.getParent().requestDisallowInterceptTouchEvent(false);
                            break;
                    }
                }
                return false;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();

//        if(item.getItemId() == android.R.id.home){
//            finish();
//        }
        return super.onOptionsItemSelected(item);
    }
}
