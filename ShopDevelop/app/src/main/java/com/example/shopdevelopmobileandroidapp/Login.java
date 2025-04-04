package com.example.shopdevelopmobileandroidapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    private Button LoginLinkBtn;

    private EditText EmailText;
    private EditText PasswordText;

    private Button SendBtn;
    private Button ForgotPasswordBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        EmailText = findViewById(R.id.login_email_input);
        PasswordText = findViewById(R.id.login_password);
        SendBtn = findViewById(R.id.signInBtn);

        LoginLinkBtn = findViewById(R.id.register_link_btn);

        ForgotPasswordBtn = findViewById(R.id.login_forgot_pass_btn);

        ForgotPasswordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), activity_forgot_password.class));
                overridePendingTransition(0, 0);
                finish();
            }
        });

        LoginLinkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Register.class));
                overridePendingTransition(0, 0);
                finish();
            }
        });

        SendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*if(EmailText.getText().toString().trim().isEmpty()) {
                    Toast.makeText(Login.this, R.string.toast_register_email_empty_error, Toast.LENGTH_SHORT).show();
                    return;
                }*/

                if(EmailText.getText().toString().trim().isEmpty()) {
                    Toast.makeText(Login.this, "Email is empty!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(PasswordText.getText().toString().trim().isEmpty()) {
                    Toast.makeText(Login.this, "Password is empty!", Toast.LENGTH_SHORT).show();
                    return;
                }

                UserInfoMock.UserEmail = EmailText.toString();
                UserInfoMock.UserPassword = PasswordText.toString();

                Toast.makeText(Login.this, "Success logging!", Toast.LENGTH_LONG).show();

                startActivity(new Intent(getApplicationContext(), activity_catalog.class));
                overridePendingTransition(0, 0);
                finish();
            }
        });
    }
}