package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.wolfsoft.MainActivity;
import com.example.wolfsoft.R;

public class ListProductChat extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_product_chat);
        getSupportActionBar().setTitle("Messengers");
    }
    public void onClickItem(View view){
        Intent intent = new Intent(ListProductChat.this, ChatActivity.class);

        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.admin:
                Intent in = new Intent(this, ChatAdmin.class);
                startActivity(in);
                finish();
                break;
            case R.id.selling:
                in = new Intent(this, ChatSelling.class);
                startActivity(in);
                finish();
                break;
            case R.id.buying:
                in = new Intent(this, ChatBuyer.class);
                startActivity(in);
                finish();
                break;

            default:
                break;
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
