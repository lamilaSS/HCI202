package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.wolfsoft.AddShoesInformation;
import com.example.wolfsoft.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class EditAccount extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.wolfsoft.R.layout.activity_edit_account);
        getSupportActionBar().setTitle("Edit management");
        Intent intent1 = this.getIntent();
        FloatingActionButton fab = findViewById(R.id.fab);
        final boolean login = intent1.getBooleanExtra("login" ,false);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (login == false){
                    Intent intent = new Intent(EditAccount.this, ChatActivity.class);

                    startActivity(intent);
                }else{
                    Intent intent = new Intent(EditAccount.this, ListProductChat.class);

                    startActivity(intent);
                }

            }
        });
    }
    public void onClick(View view){
        Toast.makeText(getBaseContext(),"Finish edit account.",Toast.LENGTH_LONG).show();
        finish();
    }

}
