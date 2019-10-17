package com.example.wolfsoft.get_detail;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.wolfsoft.R;

import java.util.ArrayList;
import java.util.Locale;

public class BrandsAdapter extends BaseAdapter {
    Context context;
    LayoutInflater inflater;
    private ArrayList<BrandNames> brandNamesArrayList;
    private ArrayList<BrandNames> arrayList;

    public BrandsAdapter(Context context, ArrayList<BrandNames> brandNamesArrayList) {
        this.context = context;
        this.brandNamesArrayList = brandNamesArrayList;
        inflater = LayoutInflater.from(context);
        arrayList = new ArrayList<>();
        arrayList.addAll(brandNamesArrayList);
    }

    @Override
    public int getCount() {
        return brandNamesArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return brandNamesArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.search,null);
            Log.d("CHECK30", "getView: Here ");
            viewHolder.name = (TextView) convertView.findViewById(R.id.brandName);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.name.setText(brandNamesArrayList.get(position).getName());
        return convertView;
    }
    public void filter(String text){
        text = text.toLowerCase(Locale.getDefault());
        brandNamesArrayList.clear();
        if (text.length() == 0){
            brandNamesArrayList.addAll(arrayList);
        }else{
            for (BrandNames brandName : arrayList){
                if (brandName.getName().toLowerCase(Locale.getDefault()).contains(text)){
                    brandNamesArrayList.add(brandName);
                }
            }
        }
        notifyDataSetChanged();
    }
    private class ViewHolder{
        TextView name;
    }

}
