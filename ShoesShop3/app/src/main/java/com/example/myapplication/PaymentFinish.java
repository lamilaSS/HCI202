package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wolfsoft.MainActivity;
import com.example.wolfsoft.R;

public class PaymentFinish extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_finish);
        getSupportActionBar().setTitle("Finish");
        final Button button = findViewById(R.id.returnToShop);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PaymentFinish.this, MainActivity.class);
                Intent intent1 = PaymentFinish.this.getIntent();

                final boolean login = intent1.getBooleanExtra("login" ,false);
                intent.putExtra("login",login);
                Toast.makeText(getBaseContext(),"Thanks for shopping. Returning to shop",Toast.LENGTH_LONG).show();
                startActivity(intent);

                String messageToSend = "Your bill code is 527725.";
                String number = "2121234567";

                SmsManager.getDefault().sendTextMessage(number, null, messageToSend, null,null);
                finish();
            }
        });
    }
}
