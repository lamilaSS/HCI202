package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.wolfsoft.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CheckUploadedItem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_uploaded_item);
        getSupportActionBar().setTitle("Uploaded items");

        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                        Intent intent = new Intent(CheckUploadedItem.this, ChatWithUser.class);

                        startActivity(intent);


                }


        });
    }
    public void onClickView(View view){
        Intent intent = new Intent(CheckUploadedItem.this,SetItemStatus.class);
        startActivity(intent);
    }
    public void chatWithUser(View view){
        Intent intent = new Intent(CheckUploadedItem.this,ChatWithUser.class);
        startActivity(intent);
    }
    public void addShoesName(View view){
        Intent intent = new Intent(CheckUploadedItem.this,AddShoesName.class);
        startActivity(intent);
    }
}
