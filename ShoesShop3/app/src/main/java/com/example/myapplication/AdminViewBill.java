package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.wolfsoft.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AdminViewBill extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_view_bill);
        getSupportActionBar().setTitle("Bill for admin");
        final Intent intent1 = this.getIntent();
        FloatingActionButton fab = findViewById(R.id.fab);
        final boolean login = intent1.getBooleanExtra("login" ,false);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(AdminViewBill.this, ChatWithUser.class);

                startActivity(intent);


            }


        });
    }
    public void viewBill(View view){
        Intent intent = new Intent(AdminViewBill.this, ViewBillDetailProcessing.class);

        intent.putExtra("orders","orders");
        intent.putExtra("admin","admin");
        startActivity(intent);
    }
}
