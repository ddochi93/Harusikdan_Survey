package com.example.kimdk.harusikdan_survey;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Callback;

public class LoginActivity extends AppCompatActivity {
    private TextView goToApply;
    private EditText editId;
    private EditText editPassword;
    private Button button;

    private static final String TAG = LoginActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();
        setListener();
    }

    private void init() {
        goToApply = findViewById(R.id.goToApply);
        editId = findViewById(R.id.editId);
        editPassword = findViewById(R.id.editPassword);
        button = findViewById(R.id.button);
    }

    private void setListener() {
        goToApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, ApplyActivity.class);
                startActivity(intent);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }

    private void login() {
        String email = editId.getText().toString();
        String password = editPassword.getText().toString();

        startActivity(new Intent(LoginActivity.this, MainActivity.class));


    }
}
