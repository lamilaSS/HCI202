package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.wolfsoft.R;

public class SetItemStatus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_item_status);
        getSupportActionBar().setTitle("Item");
    }
    public void onClick(View view){
        Toast.makeText(getBaseContext(),"Set status finish",Toast.LENGTH_LONG).show();
        finish();
    }
}
