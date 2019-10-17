package com.example.wolfsoft;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import com.example.myapplication.ChatActivity;
import com.example.myapplication.ListProductChat;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class SizeChoosingActivity extends AppCompatActivity {
    ArrayList<Float> sizeList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_size_choosing);
        GridView gridLayout = findViewById(R.id.sizeView);
        getSupportActionBar().setTitle("Choose size");
        for (float i = 35; i<46;i+=0.5){
            Button button = new Button(this);
            button.setText(""+i);


            sizeList.add(i);
        }
        ArrayAdapter<Float> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,sizeList);
        gridLayout.setAdapter(arrayAdapter);
        gridLayout.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.putExtra("size",((TextView)view).getText().toString());
                setResult(Activity.RESULT_OK,intent);
                finish();
            }
        });
        Intent intent = this.getIntent();
        FloatingActionButton fab = findViewById(R.id.fab);
        final boolean login = intent.getBooleanExtra("login" ,false);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (login == false){
                    Intent intent = new Intent(SizeChoosingActivity.this, ChatActivity.class);

                    startActivity(intent);
                }else{
                    Intent intent = new Intent(SizeChoosingActivity.this, ListProductChat.class);

                    startActivity(intent);
                }

            }
        });
    }
}
