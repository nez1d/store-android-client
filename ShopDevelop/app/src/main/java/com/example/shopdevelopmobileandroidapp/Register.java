package com.example.shopdevelopmobileandroidapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {

    private EditText EmailText;
    private EditText PasswordText;
    private EditText ConfirmPasswordText;

    private Button LoginLinkBtn;
    private Button SendBtn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        EmailText = findViewById(R.id.reg_email_input);
        PasswordText = findViewById(R.id.reg_password_input);
        ConfirmPasswordText = findViewById(R.id.reg_repeat_password_input);

        LoginLinkBtn = findViewById(R.id.login_link_btn);
        SendBtn = findViewById(R.id.registerBtn);

        SendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(EmailText.getText().toString().trim().isEmpty()) {
                    Toast.makeText(Register.this, "Email is empty", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(PasswordText.getText().toString().trim().isEmpty()) {
                    Toast.makeText(Register.this, "Password is empty", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(!PasswordText.getText().toString().equals(ConfirmPasswordText.getText().toString())) {
                    Toast.makeText(Register.this, "Password Error", Toast.LENGTH_SHORT).show();
                    return;
                }

                UserInfoMock.UserEmail = EmailText.toString();
                UserInfoMock.UserPassword = PasswordText.toString();
                Toast.makeText(Register.this, "Success", Toast.LENGTH_LONG).show();

                startActivity(new Intent(getApplicationContext(), activity_enter_code_to_register.class));
                overridePendingTransition(0, 0);
                finish();
            }
        });

        LoginLinkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Login.class));
                overridePendingTransition(0, 0);
                finish();
            }
        });
    }
}