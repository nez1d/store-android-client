package com.example.shopdevelopmobileandroidapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity
{
    private EditText EmailText;
    private EditText PasswordText;
    private EditText ConfirmPasswordText;

    private Button LoginLinkBtn;
    private Button SendBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        EmailText = findViewById(R.id.reg_email_input);
        PasswordText = findViewById(R.id.reg_password_input);
        ConfirmPasswordText = findViewById(R.id.reg_repeat_password_input);

        LoginLinkBtn = findViewById(R.id.login_link_btn);
        SendBtn = findViewById(R.id.register_submit_btn);

        SendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(EmailText.getText().toString().trim().isEmpty()) {
                    Toast.makeText(MainActivity.this, R.string.toast_register_email_empty_error, Toast.LENGTH_SHORT).show();
                    return;
                }

                if(PasswordText.getText().toString().trim().isEmpty()) {
                    Toast.makeText(MainActivity.this, R.string.toast_register_pass_empty_error, Toast.LENGTH_SHORT).show();
                    return;
                }

                if(!PasswordText.getText().toString().equals(ConfirmPasswordText.getText().toString())) {
                    Toast.makeText(MainActivity.this, R.string.toast_register_pass_equal_error, Toast.LENGTH_SHORT).show();
                    return;
                }

                UserInfoMock.UserEmail = EmailText.toString();
                UserInfoMock.UserPassword = PasswordText.toString();
                Toast.makeText(MainActivity.this, R.string.toast_register_success_message, Toast.LENGTH_LONG).show();
            }
        });
    }
}