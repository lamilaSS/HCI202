package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.wolfsoft.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HistorySell extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_sell);
        Intent intent1 = this.getIntent();
        FloatingActionButton fab = findViewById(R.id.fab);
        final boolean login = intent1.getBooleanExtra("login" ,false);
        getSupportActionBar().setTitle("Sell history");
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (login == false){
                    Intent intent = new Intent(HistorySell.this, ChatActivity.class);

                    startActivity(intent);
                }else{
                    Intent intent = new Intent(HistorySell.this, ListProductChat.class);

                    startActivity(intent);
                }

            }
        });
    }
    public void viewBill(View view){
        Intent intent = new Intent(HistorySell.this, ViewBillDetail.class);

        Intent intent1 = this.getIntent();

        final boolean login = intent1.getBooleanExtra("login" ,false);
        intent.putExtra("login",login);
        startActivity(intent);
    }
    public void historyAdmin(View view){
        Intent intent = new Intent(HistorySell.this, ViewSellingItem.class);

        Intent intent1 = this.getIntent();

        final boolean login = intent1.getBooleanExtra("login" ,false);
        intent.putExtra("name","History buy/sell");
        intent.putExtra("login", login);
        intent.putExtra("cart","cart");
        intent.putExtra("showMore", "4");

        startActivity(intent);
        finish();
    }
    public void historyBuy(View view){
        Intent intent = new Intent(HistorySell.this, BuyHistory.class);

        Intent intent1 = this.getIntent();

        final boolean login = intent1.getBooleanExtra("login" ,false);
        intent.putExtra("login",login);
        startActivity(intent);
        finish();
    }

}
