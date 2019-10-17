package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridView;

import com.example.wolfsoft.AddShoesInformation;
import com.example.wolfsoft.MainActivity;
import com.example.wolfsoft.R;
import com.example.wolfsoft.data.ProductBase;
import com.example.wolfsoft.ui.ProductBaseAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class HistoryView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_view);
        GridView gridView = findViewById(R.id.moreProduct);
        Intent intent = this.getIntent();
        getSupportActionBar().setTitle(intent.getStringExtra("name").toString());
        ArrayList<ProductBase> linearLayouts = new ArrayList<>();
        for (int i = 0;i<27;i++){


            ProductBase productBase = new ProductBase("Shoes ABC","3000$","R.drawable.shoe1");
            linearLayouts.add(productBase);


        }
        ProductBaseAdapter productBaseAdapter = new ProductBaseAdapter(linearLayouts, HistoryView.this);
        Log.d("CHECK22", "onCreate: "+linearLayouts.size());
        gridView.setAdapter(productBaseAdapter);
        Intent intent1 = this.getIntent();
        FloatingActionButton fab = findViewById(R.id.fab);
        final boolean login = intent1.getBooleanExtra("login" ,false);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (login == false){
                    Intent intent = new Intent(HistoryView.this, ChatActivity.class);

                    startActivity(intent);
                }else{
                    Intent intent = new Intent(HistoryView.this, ListProductChat.class);

                    startActivity(intent);
                }

            }
        });
    }
}
