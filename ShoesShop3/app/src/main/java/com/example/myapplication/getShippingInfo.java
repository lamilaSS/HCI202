package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wolfsoft.MainActivity;
import com.example.wolfsoft.R;

public class getShippingInfo extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_shipping_info);
        getSupportActionBar().setTitle("Payment information");
        Button continuePayment = (Button) findViewById(R.id.continuepayment);
        continuePayment.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.continuepayment:

                RadioGroup radioGroup = (RadioGroup)findViewById(R.id.paymentGroup);

                int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
                Intent intent1 = this.getIntent();

                final boolean login = intent1.getBooleanExtra("login" ,false);
                //navigate by user choice
                switch (checkedRadioButtonId){
                    case R.id.domestic:
                        //domestic card payment
                        Intent in = new Intent(this, GetPaymentInforByDomCard.class);

                        in.putExtra("login",login);

                        startActivity(in);
                        finish();
                        break;
                    case R.id.international:
                        //international card payment
                        in = new Intent(this, GetPaymentInfo.class);

                        in.putExtra("login",login);
                        startActivity(in);
                        finish();
                        break;
                    case R.id.delivery:
                        //pay on delivery
                        in = new Intent(this, PaymentFinish.class);

                        in.putExtra("login",login);
                        startActivity(in);
                        finish();
                        break;
                }


                break;
            default:
                finish();
                break;
        }
    }
    public void clickToShop(View view){
        Intent intent = new Intent(getShippingInfo.this, MainActivity.class);
        Intent intent1 = this.getIntent();
        Toast.makeText(getBaseContext(),"Returning to shop",Toast.LENGTH_LONG).show();
        final boolean login = intent1.getBooleanExtra("login" ,false);
        intent.putExtra("login",login);
        startActivity(intent);

        finish();
    }
    public void clickToShop2(View view){
        Intent intent = new Intent(getShippingInfo.this, MainActivity.class);
        Intent intent1 = this.getIntent();
        Toast.makeText(getBaseContext(),"Returning to shop",Toast.LENGTH_LONG).show();
        final boolean login = intent1.getBooleanExtra("login" ,false);
        intent.putExtra("login",login);
        startActivity(intent);

        finish();
    }
}
