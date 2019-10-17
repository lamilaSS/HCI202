package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.wolfsoft.AddShoesInformation;
import com.example.wolfsoft.R;
import com.example.wolfsoft.ViewProductActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ViewSellingItem extends AppCompatActivity {
    Intent intent = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        intent = this.getIntent();
        String showMore = intent.getStringExtra("showMore");
        getSupportActionBar().setTitle("List item");
        if (showMore != null){
            if(intent.getStringExtra("showMore").equals("showMore")){
                setContentView(R.layout.activity_view_selling_item2);
            }else if(intent.getStringExtra("showMore").equals("4")){
                setContentView(R.layout.activity_view_selling_item4);
            }else{
                setContentView(R.layout.activity_view_selling_item3);
            }

        }else if(showMore == null){

            setContentView(R.layout.activity_view_selling_item);
        }

        if (intent.getStringExtra("cart").equals("cart")){
            getSupportActionBar().setTitle(intent.getStringExtra("name"));
        }else{
            getSupportActionBar().setTitle("My store");
        }
        Intent intent1 = this.getIntent();
        FloatingActionButton fab = findViewById(R.id.fab);
        final boolean login = intent1.getBooleanExtra("login" ,false);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (login == false){
                    Intent intent = new Intent(ViewSellingItem.this, ChatActivity.class);

                    startActivity(intent);
                }else{
                    Intent intent = new Intent(ViewSellingItem.this, ListProductChat.class);

                    startActivity(intent);
                }

            }
        });
    }
    public void onClickItem(View view){
        if (intent.getStringExtra("cart").equals("cart")){
            Intent intent = new Intent(ViewSellingItem.this, Detail.class);
            Intent intent1 = this.getIntent();

            final boolean login = intent1.getBooleanExtra("login" ,false);
            intent.putExtra("login",login);
            startActivity(intent);

        }else{

        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (intent.getStringExtra("cart").equals("cart")){
            finish();
        }else{
            if(requestCode == 5){

            }
        }
    }
    public void viewBill(View view){
        Intent intent = new Intent(ViewSellingItem.this, ViewBillDetail.class);

        Intent intent1 = this.getIntent();

        final boolean login = intent1.getBooleanExtra("login" ,false);
        intent.putExtra("login",login);
        startActivity(intent);
    }
}
