package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.wolfsoft.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ViewBillDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Intent intent1 = this.getIntent();
        if(intent1.getStringExtra("orders")!=null){
            setContentView(R.layout.activity_view_bill_detail_delivering);
        }else{
            setContentView(R.layout.activity_view_bill_detail_finish);
        }

        getSupportActionBar().setTitle("Bill detail");

        FloatingActionButton fab = findViewById(R.id.fab);
        final boolean login = intent1.getBooleanExtra("login" ,false);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(intent1.getStringExtra("admin")!=null && intent1.getStringExtra("admin").equals("admin")){
                    Intent intent = new Intent(ViewBillDetail.this, ChatWithUser.class);

                    startActivity(intent);
                }else{
                    if (login == false){
                        Intent intent = new Intent(ViewBillDetail.this, ChatActivity.class);

                        startActivity(intent);
                    }else{
                        Intent intent = new Intent(ViewBillDetail.this, ListProductChat.class);

                        startActivity(intent);
                    }
                }


            }
        });
    }
    public void finishSee(View view){
        finish();
    }
}
