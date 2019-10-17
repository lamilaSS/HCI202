package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wolfsoft.R;

public class ChatBuyer extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_buying);

        TextView admin = (TextView)findViewById(R.id.admin);
        TextView  selling = (TextView)findViewById(R.id.selling);

        admin.setOnClickListener(this);
        selling.setOnClickListener(this);
    }
    public void onClickItem(View view){
        Intent intent = new Intent(ChatBuyer.this, ChatActivity.class);
        intent.putExtra("role","buyer");
        startActivity(intent);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.admin:
                Intent in = new Intent(this, ChatAdmin.class);
                startActivity(in);
                finish();
                break;
            case R.id.selling:
                in = new Intent(this, ChatSelling.class);
                startActivity(in);
                finish();
                break;
            case R.id.all:
                in = new Intent(this, ListProductChat.class);
                startActivity(in);
                finish();
                break;
            default:
                break;
        }
    }
}
