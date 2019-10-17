package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.wolfsoft.R;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getSupportActionBar().setTitle("Sign up");
        Button button =(Button) findViewById(R.id.registration);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"Sign up complete",Toast.LENGTH_LONG).show();
                finish();
            }
        });

    }
    public void backToLogin(View view){
        Toast.makeText(getBaseContext(),"Returning to login page.",Toast.LENGTH_LONG).show();
        finish();
    }
}
