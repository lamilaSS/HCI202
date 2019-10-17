package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wolfsoft.AddShoesInformation;
import com.example.wolfsoft.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Detail extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);
        getSupportActionBar().setTitle("Product detail");
        Intent intent1 = this.getIntent();
        FloatingActionButton fab = findViewById(R.id.fab);
        final boolean login = intent1.getBooleanExtra("login" ,false);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (login == false){
                    Intent intent = new Intent(Detail.this, ChatActivity.class);

                    startActivity(intent);
                }else{
                    Intent intent = new Intent(Detail.this, ListProductChat.class);

                    startActivity(intent);
                }

            }
        });
    }
    public void buyNow(View view){
        Intent intent = new Intent(Detail.this, ViewCart.class);

        Intent intent1 = this.getIntent();

        final boolean login = intent1.getBooleanExtra("login" ,false);
        intent.putExtra("login",login);
        startActivity(intent);

        finish();
    }
    public void addCart(View view){
        Toast.makeText(this,"Add to cart succesfully", Toast.LENGTH_LONG).show();
    }
}
