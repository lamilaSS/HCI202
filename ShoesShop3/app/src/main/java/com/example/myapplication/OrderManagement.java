package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.wolfsoft.AddShoesInformation;
import com.example.wolfsoft.MyStore;
import com.example.wolfsoft.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.tooltip.Tooltip;

public class OrderManagement extends AppCompatActivity {
    private int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_management);

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

                                    "2.1 Green V sign means you have paid.\n" +

                                    "3-The truck sign means it is being delivered.")

                            .show();
                    count = 1;
                }else{
                    tooltip[0].dismiss();
                    count = 0;
                }


            }
        });
        Intent intent1 = this.getIntent();
        FloatingActionButton fab = findViewById(R.id.fab);
        final boolean login = intent1.getBooleanExtra("login" ,false);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (login == false){
                    Intent intent = new Intent(OrderManagement.this, ChatActivity.class);

                    startActivity(intent);
                }else{
                    Intent intent = new Intent(OrderManagement.this, ListProductChat.class);

                    startActivity(intent);
                }

            }
        });
    }
    public void onClickView(View view){
        Intent intent = new Intent(OrderManagement.this,ViewSellingItem.class);
        Intent intent1 = this.getIntent();

        final boolean login = intent1.getBooleanExtra("login" ,false);
        intent.putExtra("login",login);
        intent.putExtra("showMore","showMore");
        intent.putExtra("name","List item");
        intent.putExtra("cart","cart");
        startActivity(intent);
    }
    public void onClickView2(View view){
        Intent intent = new Intent(OrderManagement.this,ViewSellingItem.class);
        Intent intent1 = this.getIntent();

        final boolean login = intent1.getBooleanExtra("login" ,false);
        intent.putExtra("login",login);
        intent.putExtra("name","List item");
        intent.putExtra("cart","cart");
        intent.putExtra("showMore","showMore");
        startActivity(intent);
    }
    public void viewBill(View view){
        Intent intent = new Intent(OrderManagement.this, ViewBillDetail.class);

        Intent intent1 = this.getIntent();

        final boolean login = intent1.getBooleanExtra("login" ,false);
        intent.putExtra("login",login);
        intent.putExtra("orders","orders");
        startActivity(intent);
    }
    public void viewBill2(View view){
        Intent intent = new Intent(OrderManagement.this, ViewBillDetailProcessing.class);

        Intent intent1 = this.getIntent();

        final boolean login = intent1.getBooleanExtra("login" ,false);

        intent.putExtra("login",login);
        startActivity(intent);
    }
    public void viewBill3(View view){
        Intent intent = new Intent(OrderManagement.this, ViewBillDetailReject.class);

        Intent intent1 = this.getIntent();

        final boolean login = intent1.getBooleanExtra("login" ,false);
        intent.putExtra("login",login);
        startActivity(intent);
    }
    public void viewBill4(View view){
        Intent intent = new Intent(OrderManagement.this, ViewBillDetailPending.class);

        Intent intent1 = this.getIntent();

        final boolean login = intent1.getBooleanExtra("login" ,false);
        intent.putExtra("login",login);
        startActivity(intent);
    }
}
