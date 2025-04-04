package com.example.shopdevelopmobileandroidapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class activity_forgot_password extends AppCompatActivity {

    private Button LoginLinkBtn;
    private Button SendCodeBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_forgot_password);

        LoginLinkBtn = findViewById(R.id.toLoginBtn);
        SendCodeBtn = findViewById(R.id.forgotPassSendCodeBtn);

        LoginLinkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Login.class));
                overridePendingTransition(0, 0);
                finish();
            }
        });

        SendCodeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), activity_forgot_pass_enter_code.class));
                overridePendingTransition(0, 0);
                finish();
            }
        });

    }
}