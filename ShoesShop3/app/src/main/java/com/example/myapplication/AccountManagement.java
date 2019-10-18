package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.wolfsoft.AddShoesInformation;
import com.example.wolfsoft.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AccountManagement extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_management);
        getSupportActionBar().setTitle("Account management");
        Intent intent1 = this.getIntent();
        FloatingActionButton fab = findViewById(R.id.fab);
        final boolean login = intent1.getBooleanExtra("login" ,false);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (login == false){
                    Intent intent = new Intent(AccountManagement.this, ChatActivity.class);

                    startActivity(intent);
                }else{
                    Intent intent = new Intent(AccountManagement.this, ListProductChat.class);

                    startActivity(intent);
                }

            }
        });
    }
    public void edit(View view){
        Intent intent = new Intent(AccountManagement.this,EditAccount.class);
        Intent intent1 = this.getIntent();

        final boolean login = intent1.getBooleanExtra("login" ,false);
        intent.putExtra("login",login);
        startActivity(intent);
    }
    public void onFinish(View view){

            Toast.makeText(getBaseContext(),"Finish manage account.",Toast.LENGTH_LONG).show();
        finish();
    }
    public void topUp(View view){
        Intent intent = new Intent(AccountManagement.this,TopUp.class);
        startActivity(intent);
    }
    public void moneyWithdraw(View view){
        Intent intent = new Intent(AccountManagement.this,Withdraw.class);
        startActivity(intent);
    }
}
