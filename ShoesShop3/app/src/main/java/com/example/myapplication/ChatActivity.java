package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.wolfsoft.R;

import java.util.Random;

public class ChatActivity extends AppCompatActivity {
    private String[] role = {"admin","buyer","seller"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = this.getIntent();
        if(intent.getStringExtra("check") != null){
            setContentView(R.layout.activity_chat2);
            getSupportActionBar().setTitle("Check message");
        }else{
            setContentView(R.layout.activity_chat);
            if(intent.getStringExtra("role") != null){
                getSupportActionBar().setTitle(intent.getStringExtra("role"));
            }else{
                getSupportActionBar().setTitle(role[autoGenerate(0,role.length-1)]);
            }
        }




    }
    private int autoGenerate(int min, int max){
        Random r = new Random();
        return r.nextInt((max -min) + 1) + min;
    }
}
