package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wolfsoft.R;

public class ChatSelling extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_selling);

        TextView  admin = (TextView)findViewById(R.id.admin);
        TextView  buying = (TextView)findViewById(R.id.buying);

        admin.setOnClickListener(this);
        buying.setOnClickListener(this);
    }
    public void onClickItem(View view){
        Intent intent = new Intent(ChatSelling.this, ChatActivity.class);
        intent.putExtra("role","seller");
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
            case R.id.buying:
                in = new Intent(this, ChatBuyer.class);
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
