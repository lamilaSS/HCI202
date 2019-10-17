package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.wolfsoft.R;

public class ChatWithUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_with_user);
        getSupportActionBar().setTitle("User");
    }
    public void onClickItem(View view){
        Intent intent = new Intent(ChatWithUser.this, ChatActivity.class);
        intent.putExtra("role","user");
        startActivity(intent);
    }
}
