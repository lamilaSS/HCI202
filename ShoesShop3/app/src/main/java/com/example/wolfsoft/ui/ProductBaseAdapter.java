package com.example.wolfsoft.ui;

import android.content.Context;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;


import android.widget.LinearLayout;
import android.widget.TextView;



import com.example.wolfsoft.R;
import com.example.wolfsoft.data.ProductBase;

import java.util.ArrayList;
import java.util.Random;


public class ProductBaseAdapter extends BaseAdapter {
    private ArrayList<ProductBase> productBaseArrayList;
    private Context context;
    private  int[] items  = new int[]{R.drawable.item1,R.drawable.item2,R.drawable.item3,R.drawable.item4,R.drawable.item5,
            R.drawable.item6,R.drawable.item7
            ,R.drawable.item8,R.drawable.item9,R.drawable.item10};
    private int autoGenerate(int min, int max){
        Random r = new Random();
        return r.nextInt((max -min) + 1) + min;
    }
    public ProductBaseAdapter(ArrayList<ProductBase> productBaseArrayList, Context context) {
        this.productBaseArrayList = productBaseArrayList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return productBaseArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return productBaseArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;

        if (convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            convertView = layoutInflater.inflate(R.layout.product,null);

            viewHolder = new ViewHolder();

            viewHolder.image = (ImageView)convertView.findViewById(R.id.productImage);
            viewHolder.name = (TextView)convertView.findViewById(R.id.productName);
            viewHolder.price = (TextView)convertView.findViewById(R.id.productPrice);







            convertView.setTag(viewHolder);


        }else {

            viewHolder = (ViewHolder) convertView.getTag();
        }


        Log.d("CHECK21", "getView: " +getCount());
        viewHolder.image.setImageResource(items[autoGenerate(0,items.length-1)]);
        viewHolder.image.setScaleType(ImageView.ScaleType.FIT_XY);
        viewHolder.name.setText("Shoes ABC");
        viewHolder.price.setText("Start with: 3000$");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                200, 50);
        layoutParams.setMargins(50,0,0,0);
        LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(150,150);
        layoutParams1.setMargins(50,10,0,0);
        viewHolder.image.setLayoutParams(layoutParams1);
        viewHolder.name.setTextSize(12);
        viewHolder.price.setTextSize(10);

        viewHolder.name.setLayoutParams(layoutParams);
        viewHolder.price.setLayoutParams(layoutParams);







        return convertView;
    }
    private class ViewHolder{
        ImageView image;
        TextView name;
        TextView price;






    }
}
