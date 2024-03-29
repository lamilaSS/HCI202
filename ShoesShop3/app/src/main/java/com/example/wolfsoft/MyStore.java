package com.example.wolfsoft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.myapplication.ChatActivity;
import com.example.myapplication.ListProductChat;
import com.example.myapplication.ShoesOnStock;
import com.example.myapplication.ViewBillDetailPending2;
import com.example.myapplication.ViewBillDetailProcessing2;
import com.example.myapplication.ViewDetailReject2;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.tooltip.Tooltip;

public class MyStore extends AppCompatActivity {
    private int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_store);

        final ImageView help = findViewById(R.id.help);
        final Tooltip[] tooltip = {null};
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (count == 0){

                    tooltip[0] = new Tooltip.Builder(help)

                            .setText("Tips:\n" +
                                    "1-This is where you see your orders.\n" +

                                    "2-You will see sign tell you that if your products are on the way or not:\n" +

                                    "2.1 Green V sign means your shoes is qualified.\n" +

                                    "2.2 Red X sign means your shoes not meet the requirements.\n" +

                                    "2.3 Three dot sign means not checked yet.\n"

                                    )

                            .show();
                    count = 1;
                }else{
                    tooltip[0].dismiss();
                    count = 0;
                }


            }
        });
        Intent intent = this.getIntent();
        FloatingActionButton fab = findViewById(R.id.fab);
        final boolean login = intent.getBooleanExtra("login" ,false);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (login == false){
                    Intent intent = new Intent(MyStore.this, ChatActivity.class);

                    startActivity(intent);
                }else{
                    Intent intent = new Intent(MyStore.this, ListProductChat.class);

                    startActivity(intent);
                }

            }
        });
    }
    public void addShoesToSell(View view){
        Intent intent = new Intent(this,AddShoesInformation.class);
        Intent intent1 = this.getIntent();

        final boolean login = intent1.getBooleanExtra("login" ,false);
        intent.putExtra("login",login);
        startActivity(intent);
    }
    public void onClickView(View view){
        if(view.getId() == R.id.waitingForUpdate){
            Intent intent = new Intent(MyStore.this, ShoesOnStock.class);
            Intent intent1 = this.getIntent();

            final boolean login = intent1.getBooleanExtra("login" ,false);
            intent.putExtra("login",login);
            intent.putExtra("cart","cart");
            intent.putExtra("update","update");
            startActivity(intent);
        }else {
            Intent intent = new Intent(MyStore.this, ShoesOnStock.class);
            Intent intent1 = this.getIntent();

            final boolean login = intent1.getBooleanExtra("login" ,false);
            intent.putExtra("login",login);
            intent.putExtra("cart","cart");
            startActivity(intent);
        }

    }

    public void showFailBill(View view) {
        Intent intent = new Intent(MyStore.this, ViewDetailReject2.class);
        Intent intent1 = this.getIntent();

        final boolean login = intent1.getBooleanExtra("login" ,false);
        intent.putExtra("login",login);
        intent.putExtra("cart","cart");
        startActivity(intent);
    }
    public void showProcessingBill(View view) {
        Intent intent = new Intent(MyStore.this, ViewBillDetailProcessing2.class);
        Intent intent1 = this.getIntent();

        final boolean login = intent1.getBooleanExtra("login" ,false);
        intent.putExtra("login",login);
        intent.putExtra("cart","cart");
        startActivity(intent);
    }

    public void showPendingBill(View view) {
        Intent intent = new Intent(MyStore.this, ViewBillDetailPending2.class);
        Intent intent1 = this.getIntent();

        final boolean login = intent1.getBooleanExtra("login" ,false);
        intent.putExtra("login",login);
        intent.putExtra("cart","cart");
        intent.putExtra("seller","seller");
        startActivity(intent);
    }
}
