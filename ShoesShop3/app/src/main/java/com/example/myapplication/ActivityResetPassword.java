package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.wolfsoft.R;

public class ActivityResetPassword extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        Button confirm = (Button) findViewById(R.id.confirm);
        Button cancel = (Button) findViewById(R.id.cancel);
        confirm.setOnClickListener(this);
        cancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.confirm:
                Toast.makeText(getBaseContext(),"Reset complete",Toast.LENGTH_LONG).show();
                finish();
                break;
            case R.id.cancel:
                Toast.makeText(getBaseContext(),"Payment cancel",Toast.LENGTH_LONG).show();
                finish();
                break;
            default:
                break;
        }
    }
}
