package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wolfsoft.AddShoesInformation;
import com.example.wolfsoft.MainActivity;
import com.example.wolfsoft.R;
import com.example.wolfsoft.ViewProductActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class SearchResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        Intent intent = this.getIntent();
        getSupportActionBar().setTitle(intent.getStringExtra("name").toString());
        Intent intent1 = this.getIntent();
        FloatingActionButton fab = findViewById(R.id.fab);
        final boolean login = intent1.getBooleanExtra("login" ,false);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (login == false){
                    Intent intent = new Intent(SearchResult.this, ChatActivity.class);

                    startActivity(intent);
                }else{
                    Intent intent = new Intent(SearchResult.this, ListProductChat.class);

                    startActivity(intent);
                }

            }
        });
    }
    public void onClick(View view){
        Intent intent1 = this.getIntent();
        final boolean login = intent1.getBooleanExtra("login" ,false);

        Intent intent = new Intent(SearchResult.this, ViewProductActivity.class);
        intent.putExtra("cart","cart");
        intent.putExtra("login",login);
        startActivity(intent);
    }
}
