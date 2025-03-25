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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        LoginLinkBtn = findViewById(R.id.login_link_btn);

        EmailText = findViewById(R.id.reg_email_input);
        PasswordText = findViewById(R.id.log_password_input);
        SendBtn = findViewById(R.id.login_submit_btn);

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

                if(EmailText.getText().toString().trim().isEmpty()) {
                    Toast.makeText(Login.this, R.string.toast_register_email_empty_error, Toast.LENGTH_SHORT).show();
                    return;
                }

                if(PasswordText.getText().toString().trim().isEmpty()) {
                    Toast.makeText(Login.this, R.string.toast_register_pass_empty_error, Toast.LENGTH_SHORT).show();
                    return;
                }

                UserInfoMock.UserEmail = EmailText.toString();
                UserInfoMock.UserPassword = PasswordText.toString();
                Toast.makeText(Login.this, R.string.toast_login_success_message, Toast.LENGTH_LONG).show();

                startActivity(new Intent(getApplicationContext(), Catalog.class));
                overridePendingTransition(0, 0);
                finish();
            }
        });
    }
}