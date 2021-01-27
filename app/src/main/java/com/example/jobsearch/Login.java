package com.example.jobsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.net.HttpURLConnection;
import java.net.URL;

public class Login extends AppCompatActivity implements View.OnClickListener {

    EditText email, password;
    Button login, signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.et_login_email);
        password = findViewById(R.id.et_login_password);
        login = findViewById(R.id.btn_login_login);
        signin = findViewById(R.id.btn_login_signin);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login_login:
                login(email.getText().toString(), password.getText().toString());
                break;
            case R.id.btn_login_signin:
                signin();
                break;
            default:
                throw new RuntimeException("Not define");
        }
    }

    private void login(String email, String password) {
        try {
            URL url = new URL("localhost:8081/login");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.connect();

        } catch (Exception e) {
            e.getMessage();
        }


    }

    private void signin() {
    }
}