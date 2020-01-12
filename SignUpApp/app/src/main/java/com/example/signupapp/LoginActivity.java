package com.example.signupapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnRegister,btnLogin;
    EditText etUser,etPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnRegister = findViewById(R.id.btn_Register);
        btnLogin = findViewById(R.id.btn_Login);
        etUser = findViewById(R.id.et_user);
        etPass = findViewById(R.id.et_pass);

        btnRegister.setOnClickListener(this);
        btnLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_Register:
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                break;

            case R.id.btn_Login:
                String username = etUser.getText().toString();
                String pw = etPass.getText().toString();

                if(username.equals("admin") && pw.equals("12345")){
                    Toast.makeText(this,"Login berhasil",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this,"username atau password salah",Toast.LENGTH_SHORT).show();
                }
        }
    }
}
