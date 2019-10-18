package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.wolfsoft.R;

public class ViewBillDetailPending extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_bill_detail_pending);
    }
    public void finishSee(View view){
        finish();
    }
    public  void cancelOrder(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(ViewBillDetailPending.this);

        builder.setCancelable(true);
        builder.setTitle("Cancelation");
        builder.setMessage("Do you want to cancel this?");

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
                Toast.makeText(getBaseContext(),"Canceled",Toast.LENGTH_SHORT).show();
                finish();

            }
        });
        builder.show();

    }
}
