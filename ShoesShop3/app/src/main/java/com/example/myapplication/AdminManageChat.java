package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.wolfsoft.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AdminManageChat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_manage_chat);
        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(AdminManageChat.this, ChatWithUser.class);

                startActivity(intent);


            }


        });
    }
    public void onClickCheck(View view){
        Intent intent = new Intent(AdminManageChat.this, ChatActivity.class);
        intent.putExtra("check","check");
        startActivity(intent);
    }
}
