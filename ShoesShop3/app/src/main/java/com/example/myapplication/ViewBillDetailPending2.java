package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.wolfsoft.R;

public class ViewBillDetailPending2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_bill_detail_pending2);
        getSupportActionBar().setTitle("Order detail");
    }

    public void finishSee(View view){
        finish();
    }
}
