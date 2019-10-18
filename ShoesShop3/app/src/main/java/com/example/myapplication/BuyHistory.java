package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.wolfsoft.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class BuyHistory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent1 = this.getIntent();

        final boolean login = intent1.getBooleanExtra("login" ,false);
        if(login == false){
            setContentView(R.layout.activity_buy_history2);
        }else{
            setContentView(R.layout.activity_buy_history);
        }
        getSupportActionBar().setTitle("Buy history");
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (login == false){
                    Intent intent = new Intent(BuyHistory.this, ChatActivity.class);

                    startActivity(intent);
                }else{
                    Intent intent = new Intent(BuyHistory.this, ListProductChat.class);

                    startActivity(intent);
                }

            }
        });
    }
    public void viewBill(View view){
        Intent intent = new Intent(BuyHistory.this, ViewBillDetail.class);

        Intent intent1 = this.getIntent();

        final boolean login = intent1.getBooleanExtra("login" ,false);
        intent.putExtra("login",login);
        startActivity(intent);
    }
    public void historyAdmin(View view){
        Intent intent = new Intent(BuyHistory.this, ViewSellingItem.class);

        Intent intent1 = this.getIntent();

        final boolean login = intent1.getBooleanExtra("login" ,false);
        intent.putExtra("name","History buy/sell");
        intent.putExtra("login", login);
        intent.putExtra("cart","cart");
        intent.putExtra("showMore", "4");

        startActivity(intent);
        finish();
    }
    public void historySell(View view){
        Intent intent = new Intent(BuyHistory.this, HistorySell.class);

        Intent intent1 = this.getIntent();

        final boolean login = intent1.getBooleanExtra("login" ,false);
        intent.putExtra("login",login);
        startActivity(intent);
        finish();
    }
}
