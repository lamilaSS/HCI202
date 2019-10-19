package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;

import com.example.wolfsoft.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AdminAddBrandAndShoesName extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_brand_and_shoes_name);
        final Intent intent1 = this.getIntent();
        FloatingActionButton fab = findViewById(R.id.fab);
        final boolean login = intent1.getBooleanExtra("login" ,false);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(AdminAddBrandAndShoesName.this, ChatWithUser.class);

                startActivity(intent);


            }


        });
    }
    public void onClickItem (View view){
        Intent intent = new Intent(AdminAddBrandAndShoesName.this,AddShoesName.class);
        intent.putExtra("update","update");
        startActivity(intent);
    }
    public void onClickItem2 (View view){
        Intent intent = new Intent(AdminAddBrandAndShoesName.this,AddShoesName.class);

        startActivity(intent);
    }
    public void shoesClick (View view){
        ImageView shoesNamedown = findViewById(R.id.shoesNamedown);
        shoesNamedown.setVisibility(View.VISIBLE);
        ImageView brandNamedown = findViewById(R.id.brandNamedown);
        brandNamedown.setVisibility(View.GONE);
        ScrollView brand = findViewById(R.id.brand);
        brand.setVisibility(View.GONE);
        ScrollView shoes = findViewById(R.id.shoes);
        shoes.setVisibility(View.VISIBLE);
    }
    public void brandClick (View view){
        ImageView shoesNamedown = findViewById(R.id.shoesNamedown);
        shoesNamedown.setVisibility(View.GONE);
        ImageView brandNamedown = findViewById(R.id.brandNamedown);
        brandNamedown.setVisibility(View.VISIBLE);
        ScrollView brand = findViewById(R.id.brand);
        brand.setVisibility(View.VISIBLE);
        ScrollView shoes = findViewById(R.id.shoes);
        shoes.setVisibility(View.GONE);
    }
    public void onClickItem3 (View view){
        Intent intent = new Intent(AdminAddBrandAndShoesName.this,AddBrand.class);
        intent.putExtra("update","update");
        startActivity(intent);
    }
    public void onClickItem4 (View view){
        Intent intent = new Intent(AdminAddBrandAndShoesName.this,AddBrand.class);

        startActivity(intent);
    }
}
