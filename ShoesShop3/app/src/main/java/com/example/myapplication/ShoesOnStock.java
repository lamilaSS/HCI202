package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.wolfsoft.MyStore;
import com.example.wolfsoft.R;

public class ShoesOnStock extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoes_on_stock);
        Intent intent = this.getIntent();
        if(intent.getStringExtra("update")!=null){
            TextView notification = findViewById(R.id.notification);
            notification.setText("Waiting for admin");
        }
        getSupportActionBar().setTitle("Shoes detail");
    }
    public void onClickView(View view){
        Intent intent = new Intent(ShoesOnStock.this, MyShoesEdit.class);
        Intent intent1 = this.getIntent();

        final boolean login = intent1.getBooleanExtra("login" ,false);
        intent.putExtra("login",login);
        intent.putExtra("cart","cart");
        startActivityForResult(intent,20);

    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(resultCode == 20){
            finish();
        }
    }
}
