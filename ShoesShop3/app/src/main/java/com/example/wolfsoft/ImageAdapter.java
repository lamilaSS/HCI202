package com.example.wolfsoft;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class ImageAdapter extends PagerAdapter {
    Context context;
    private  int[] ints;

     ImageAdapter(Context context,int[] ints) {
        this.context = context;
        this.ints = ints;
    }
    @Override
    public Object instantiateItem(ViewGroup viewGroup,int position){
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageResource(ints[position]);
        ((ViewPager)viewGroup).addView(imageView,0);

        Log.d("CHECK1", ""+imageView);
        return imageView;
    }



    @Override
    public boolean isViewFromObject(View view,  Object object) {
        Log.d("CHECK2", ""+view);
        Log.d("CHECK3", ""+object);
        return view == object;
    }

    @Override
    public void destroyItem( ViewGroup container, int position,  Object object) {
        container.removeView((ImageView)object);

    }
    @Override
    public int getCount() {

        Log.d("CHECK4", ""+ints.length);
        return ints.length;
    }
}
