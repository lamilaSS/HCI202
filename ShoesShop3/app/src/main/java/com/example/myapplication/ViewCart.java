package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wolfsoft.AddShoesInformation;
import com.example.wolfsoft.MainActivity;
import com.example.wolfsoft.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ViewCart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_cart);
        getSupportActionBar().setTitle("My cart");
        Button continueShopping = findViewById(R.id.continueShopping);
        continueShopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Intent intent1 = this.getIntent();
        FloatingActionButton fab = findViewById(R.id.fab);
        final boolean login = intent1.getBooleanExtra("login" ,false);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (login == false){
                    Intent intent = new Intent(ViewCart.this, ChatActivity.class);

                    startActivity(intent);
                }else{
                    Intent intent = new Intent(ViewCart.this, ListProductChat.class);

                    startActivity(intent);
                }

            }
        });
    }
    public void finishShopping(View view){
        LinearLayout linearLayout1 = findViewById(R.id.product1);
        LinearLayout linearLayout2 = findViewById(R.id.product2);
        Intent intent1 = this.getIntent();

        final boolean login = intent1.getBooleanExtra("login" ,false);
        if(linearLayout1.getVisibility() == View.GONE && linearLayout2.getVisibility() == View.GONE){
            Toast.makeText(getBaseContext(),"Sorry your cart is empty!",Toast.LENGTH_LONG).show();
        }else{
            if(login == false){
                Intent intent = new Intent(this,getShippingInfo.class);


                intent.putExtra("login",login);
                startActivity(intent);

                finish();
            }else{
                Intent intent = new Intent(this,GetSavedShippingInfo.class);


                intent.putExtra("login",login);
                startActivity(intent);

                finish();
            }

        }

    }
    public void continueShopping(View view){
        Intent intent = new Intent(this, MainActivity.class);
        Intent intent1 = this.getIntent();

        final boolean login = intent1.getBooleanExtra("login" ,false);
        intent.putExtra("login",login);
        startActivity(intent);
        Toast.makeText(getBaseContext(),"Returning to shop",Toast.LENGTH_LONG).show();
        finish();
    }
    public void remove1(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(ViewCart.this);

        builder.setCancelable(true);
        builder.setTitle("Withdraw");
        builder.setMessage("Do you want to remove?");

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();

            }
        });

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //change back to home
                LinearLayout linearLayout1 = findViewById(R.id.product1);
                LinearLayout linearLayout2 = findViewById(R.id.product2);
                linearLayout1.setVisibility(View.GONE);
                Toast.makeText(getBaseContext(),"Remove complete",Toast.LENGTH_LONG).show();
                if(linearLayout2.getVisibility() != View.GONE){
                    TextView totalPrice = findViewById(R.id.totalPrice);
                    totalPrice.setText("Total: 165$");
                }else{
                    TextView totalPrice = findViewById(R.id.totalPrice);
                    totalPrice.setVisibility(View.GONE);
                }

            }
        });
        builder.show();

    }
    public void remove2(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(ViewCart.this);

        builder.setCancelable(true);
        builder.setTitle("Withdraw");
        builder.setMessage("Do you want to remove?");

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                Toast.makeText(getBaseContext(),"Withdraw cancel.",Toast.LENGTH_LONG).show();
            }
        });

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //change back to home
                LinearLayout linearLayout1 = findViewById(R.id.product1);
                LinearLayout linearLayout2 = findViewById(R.id.product2);
                linearLayout2.setVisibility(View.GONE);
                Toast.makeText(getBaseContext(),"Remove complete",Toast.LENGTH_LONG).show();
                if(linearLayout1.getVisibility() != View.GONE){
                    TextView totalPrice = findViewById(R.id.totalPrice);
                    totalPrice.setText("Total: 165$");
                }else{
                    TextView totalPrice = findViewById(R.id.totalPrice);
                    totalPrice.setVisibility(View.GONE);
                }

            }
        });
        builder.show();
    }

}
