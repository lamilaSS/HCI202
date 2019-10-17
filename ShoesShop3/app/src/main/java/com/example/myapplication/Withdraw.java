package com.example.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wolfsoft.R;

public class Withdraw extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withdraw);

        Button withdraw = (Button) findViewById(R.id.withdraw);
        getSupportActionBar().setTitle("Money withdraw");

        withdraw.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.withdraw:
                //get withdraw money
                EditText withdrawNum = (EditText) findViewById(R.id.withdrawNum);
                String withdrawNumber = withdrawNum.getText().toString();

                //alert user
                AlertDialog.Builder builder = new AlertDialog.Builder(Withdraw.this);

                builder.setCancelable(true);
                builder.setTitle("Withdraw");
                builder.setMessage("Do you want to withdraw " + withdrawNumber + "to your account?");

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
                        Toast.makeText(getBaseContext(),"Withdraw complete.Please check your bank account",Toast.LENGTH_LONG).show();

                    }
                });
                builder.show();

                break;
            case R.id.cancel:
                Toast.makeText(getBaseContext(),"Cancel withdraw",Toast.LENGTH_LONG).show();
                finish();
                break;
            default:
                finish();
                break;
        }


    }
    public void onClickFinish(View view){
        finish();
    }
}
