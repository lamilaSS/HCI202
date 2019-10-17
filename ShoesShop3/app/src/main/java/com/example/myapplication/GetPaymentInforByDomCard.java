package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wolfsoft.R;

public class GetPaymentInforByDomCard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_payment_infor_by_dom_card);
        getSupportActionBar().setTitle("Payment information");
        Spinner bankSpinner = (Spinner) findViewById(R.id.bankSpinner);
        ArrayAdapter<String> bankAdapter = new ArrayAdapter<String>(
                GetPaymentInforByDomCard.this,android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.bankSpinnerItem));

        bankAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bankSpinner.setAdapter(bankAdapter);
    }
    public void continuePaymnet(View view){
        Intent intent = new Intent(GetPaymentInforByDomCard.this,PaymentFinish.class);

        startActivity(intent);
        finish();
    }
    public void changePaymentMethod(View view){
        Intent intent = new Intent(GetPaymentInforByDomCard.this,GetSavedShippingInfo.class);

        startActivity(intent);

    }
}
