package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wolfsoft.MainActivity;
import com.example.wolfsoft.R;

public class GetSavedShippingInfo extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_saved_shipping_info);
        getSupportActionBar().setTitle("Payment information");
        Button continuePayment = (Button) findViewById(R.id.continuepayment);
        continuePayment.setOnClickListener(this);

        TextView addNewAddress = (TextView) findViewById(R.id.addNewAddress);
        addNewAddress.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent1 = this.getIntent();

        final boolean login = intent1.getBooleanExtra("login" ,false);
        switch (v.getId()){
            case R.id.continuepayment:
                RadioGroup radioGroup = (RadioGroup)findViewById(R.id.paymentGroup);

                int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
                //navigate by user choice
                switch (checkedRadioButtonId){
                    case R.id.domestic:
                        //domestic card payment

                        Intent in = new Intent(this, GetSavedPaymentInfoByDomCard.class);
                        in.putExtra("login",login);
                        startActivity(in);
                        finish();
                        break;
                    case R.id.international:
                        //international card payment

                        in = new Intent(this, GetSavedPaymentInfo.class);
                        in.putExtra("login",login);
                        startActivity(in);
                        finish();
                        break;
                    case R.id.delivery:

                        in = new Intent(this, PaymentFinish.class);
                        in.putExtra("login",login);
                        startActivity(in);
                        finish();
                        break;
                }
                break;
            case R.id.addNewAddress:

                Intent in = new Intent(this,getShippingInfo.class);
                in.putExtra("login",login);
                startActivity(in);
                finish();
                break;
            default:

                finish();
                break;
        }
    }
    public void clickToShop2(View view){
        Intent intent = new Intent(GetSavedShippingInfo.this, MainActivity.class);
        Intent intent1 = this.getIntent();
        Toast.makeText(getBaseContext(),"Returning to shop",Toast.LENGTH_LONG).show();
        final boolean login = intent1.getBooleanExtra("login" ,false);
        intent.putExtra("login",login);
        startActivity(intent);

        finish();
    }
}
