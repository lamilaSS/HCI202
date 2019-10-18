package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.wolfsoft.AddShoesInformation;
import com.example.wolfsoft.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class TopUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_up);
        getSupportActionBar().setTitle("Top up");

        Spinner bankSpinner = (Spinner) findViewById(R.id.bankList);
        ArrayAdapter<String> bankAdapter = new ArrayAdapter<String>(
                TopUp.this,android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.bankSpinnerItem));

        bankAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bankSpinner.setAdapter(bankAdapter);
        final RadioGroup radioGroup = findViewById(R.id.radioButtons);
        final LinearLayout masterVisa = findViewById(R.id.masterVisa);
        final LinearLayout creditDebit = findViewById(R.id.creditDebit);
        final    LinearLayout phoneCard = findViewById(R.id.phoneCard);
        final   LinearLayout sms = findViewById(R.id.SMS);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (radioGroup.getCheckedRadioButtonId()){
                    case R.id.radioButtonMasterVisa:
                        masterVisa.setVisibility(View.VISIBLE);
                        creditDebit.setVisibility(View.GONE);
                        phoneCard.setVisibility(View.GONE);
                        sms.setVisibility(View.GONE);
                        break;
                    case R.id.radioButtonCreditDebit:
                        masterVisa.setVisibility(View.GONE);
                        creditDebit.setVisibility(View.VISIBLE);
                        phoneCard.setVisibility(View.GONE);
                        sms.setVisibility(View.GONE);
                        break;
                    case R.id.radioButtonPhoneCard:
                        masterVisa.setVisibility(View.GONE);
                        creditDebit.setVisibility(View.GONE);
                        phoneCard.setVisibility(View.VISIBLE);
                        sms.setVisibility(View.GONE);
                        break;
                    case R.id.radioButtonSMS:
                        masterVisa.setVisibility(View.GONE);
                        creditDebit.setVisibility(View.GONE);
                        phoneCard.setVisibility(View.GONE);
                        sms.setVisibility(View.VISIBLE);
                        break;
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
                    Intent intent = new Intent(TopUp.this, ChatActivity.class);

                    startActivity(intent);
                }else{
                    Intent intent = new Intent(TopUp.this, ListProductChat.class);

                    startActivity(intent);
                }

            }
        });
    }
    public void topUp(View view){
        Toast.makeText(getBaseContext(),"Top up complete",Toast.LENGTH_LONG).show();
    }
    public void cancel(View view){
        Toast.makeText(getBaseContext(),"Top up cancel",Toast.LENGTH_LONG).show();
        finish();
    }
}
