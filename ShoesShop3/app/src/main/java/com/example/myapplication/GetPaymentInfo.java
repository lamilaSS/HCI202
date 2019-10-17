package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wolfsoft.R;

public class GetPaymentInfo extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_payment_info);
        getSupportActionBar().setTitle("Payment information");
        Button continuePayment = (Button) findViewById(R.id.continuepayment);
        Button changePaymentMethod = (Button) findViewById(R.id.changePaymentMethod);

        continuePayment.setOnClickListener(this);
        changePaymentMethod.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent1 = this.getIntent();

        final boolean login = intent1.getBooleanExtra("login" ,false);
        switch (v.getId()){
            case R.id.continuepayment:
                Intent in = new Intent(this, PaymentFinish.class);

                in.putExtra("login",login);
                startActivity(in);
                finish();
                break;
            case R.id.changePaymentMethod:
                in = new Intent(this, GetSavedShippingInfo.class);

                in.putExtra("login",login);
                startActivity(in);
                finish();
                break;
            default:
                break;
        }
    }
}
