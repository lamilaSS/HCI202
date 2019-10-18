package com.example.wolfsoft;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.example.myapplication.ChatActivity;
import com.example.myapplication.CheckUploadedItem;
import com.example.myapplication.Detail;
import com.example.myapplication.ListProductChat;
import com.example.myapplication.ViewSellingItem;
import com.example.wolfsoft.get_detail.Bean;
import com.example.wolfsoft.get_detail.Beanclass;
import com.example.wolfsoft.get_detail.ChildAnimationExample;
import com.example.wolfsoft.get_detail.ExpandableHeightGridView;
import com.example.wolfsoft.get_detail.ExpandableHeightListView;
import com.example.wolfsoft.get_detail.GridviewAdapter;
import com.example.wolfsoft.get_detail.JayBaseAdapter;
import com.example.wolfsoft.get_detail.SliderLayout;
import com.example.wolfsoft.ui.login.LoginActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.HashMap;

public class ViewProductActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener {
    SliderLayout mDemoSlider;
    private static  final int size_id = 1;
    LinearLayout linear1,showless,review;
    LinearLayout linear2;

    Typeface fonts1,fonts2;
    private GridView gridview;
    private ListView listview;
    private ArrayList<com.example.wolfsoft.get_detail.Bean>Bean;
    private JayBaseAdapter baseAdapter;
    private ArrayList<Beanclass> beanclassArrayList;
    private GridviewAdapter gridviewAdapter;


    private int[] IMAGE = {R.drawable.shoe1, R.drawable.shoe2, R.drawable.p3};
    private String[] TITLE = {"Condition: New", "Condition: 9.5", "Condition: 8.5"};
    private String[] RATING = {"Size : 39.5  - by Emma", "Size : 39.5 - by Kelly", "Size : 39.5 - by Zywoo"};
    private String[] BY = {"1115$","120$","220$"};

    private ImageView like ;
    private int[] IMAGEgrid = {R.drawable.shoes1, R.drawable.shoes2, R.drawable.shoes1, R.drawable.shoes1};
    private String[] TITLeGgrid = {"ABC shoes-Start with 150$", "ABC shoes-Start with 150$", "ABC shoes-Start with 150$",  "ABC shoes-Start with 150$"};
    private String[] DIscriptiongrid = {"Wrist Watches", "Belts", "Sunglasses","Perfumes"};
    private String[] Dategrid = {"Explore Now!","Grab Now!","Discover now!", "Great Savings!"};
    boolean login = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_product);
        Intent intent = this.getIntent();
        final RatingBar mRatingBar = findViewById(R.id.rating1);
        mRatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                mRatingBar.setRating(rating);
            }
        });
        mRatingBar.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP){

                }
                return mRatingBar.onTouchEvent(event);
            }
        });

        login = intent.getBooleanExtra("login" ,false);
        getSupportActionBar().setTitle("Product");
        like = findViewById(R.id.like);
        like.setTag(R.drawable.ic_thumb_up_black_24dp);
//        ********LISTVIEW***********


        listview = findViewById(R.id.listview);

        Bean = new ArrayList<Bean>();

        for (int i= 0; i< TITLE.length; i++){

            Bean bean = new Bean(IMAGE[i], TITLE[i], RATING[i], BY[i]);
            Bean.add(bean);

        }

        baseAdapter = new JayBaseAdapter(ViewProductActivity.this, Bean) {
        };

        listview.setAdapter(baseAdapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ViewProductActivity.this,Detail.class);
                intent.putExtra("showMore","showMore");
                intent.putExtra("cart","cart");
                intent.putExtra("login", login);
                startActivity(intent);
            }
        });


//        ********GRIDVIEW***********


        gridview = findViewById(R.id.gridview);
        beanclassArrayList= new ArrayList<Beanclass>();

        for (int i= 0; i< IMAGEgrid.length; i++) {

            Beanclass beanclass = new Beanclass(IMAGEgrid[i], TITLeGgrid[i], DIscriptiongrid[i], Dategrid[i]);
            beanclassArrayList.add(beanclass);

        }
        gridviewAdapter = new GridviewAdapter(ViewProductActivity.this, beanclassArrayList);


        gridview.setAdapter(gridviewAdapter);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ViewProductActivity.this,ViewProductActivity.class);
                intent.putExtra("login", login);
                intent.putExtra("cart","cart");
                startActivity(intent);
            }
        });




//                ***********viewmore**********

        linear1 = (LinearLayout)findViewById(R.id.linear1);
        showless = (LinearLayout)findViewById(R.id.showless);

        linear2 = (LinearLayout)findViewById(R.id.linear2);

        linear1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                linear2.setVisibility(View.VISIBLE);
                linear1.setVisibility(View.GONE);

            }
        });

        showless.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                linear2.setVisibility(View.GONE);
                linear1.setVisibility(View.VISIBLE);


            }
        });

//         ********Slider*********

        mDemoSlider = (SliderLayout)findViewById(R.id.slider);

        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("1", R.drawable.shoe1);
        file_maps.put("2",R.drawable.shoe1);
        file_maps.put("3",R.drawable.shoe1);


        for(String name : file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    //  .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.CenterInside)
                    .setOnSliderClickListener(this);


            textSliderView.bundle(new Bundle());
            textSliderView.getBundle().putString("extra", name);

            mDemoSlider.addSlider(textSliderView);
        }
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Default);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new ChildAnimationExample());
        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(this);

        FloatingActionButton fab = findViewById(R.id.fab);
        TextView buynow = findViewById(R.id.buy);
        buynow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewProductActivity.this,ViewSellingItem.class);
                intent.putExtra("showMore","showMore");
                intent.putExtra("cart","cart");
                intent.putExtra("name","List sellers");
                intent.putExtra("login", login);
                startActivity(intent);

            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (login == false){
                    Intent intent = new Intent(ViewProductActivity.this, ChatActivity.class);

                    startActivity(intent);
                }else{
                    Intent intent = new Intent(ViewProductActivity.this, ListProductChat.class);

                    startActivity(intent);
                }

            }
        });
        final Button size = findViewById(R.id.sizeChoose);
        size.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewProductActivity.this,SizeChoosingActivity.class);
                Intent intent1 =ViewProductActivity.this.getIntent();

                final boolean login = intent1.getBooleanExtra("login" ,false);
                intent.putExtra("login",login);
                startActivityForResult(intent,size_id);
            }
        });
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }

    public void EditActivity(View view) {
        Intent intent1 = this.getIntent();


        final boolean login = intent1.getBooleanExtra("login" ,false);
        Intent intent = new Intent(ViewProductActivity.this,ViewSellingItem.class);
        intent.putExtra("showMore","showMore");
        intent.putExtra("cart","cart");
        intent.putExtra("login", login);
        intent.putExtra("name","List item");
        startActivityForResult(intent,6);
    }
    public void SellLikeThis(View view) {
        if(login == false){
            Intent intent = new Intent(ViewProductActivity.this, LoginActivity.class);
            intent.putExtra("showMore","showMore");
            intent.putExtra("cart","cart");
            intent.putExtra("login", login);
            startActivityForResult(intent,2);
        }else{
            Intent intent = new Intent(ViewProductActivity.this,AddShoesInformation.class);
            intent.putExtra("showMore","showMore");
            intent.putExtra("cart","cart");
            intent.putExtra("login", login);
            startActivity(intent);
        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        Log.d("CHECK41", "onActivityResult: "+resultCode);
        if (requestCode == size_id){
            Button button = findViewById(R.id.sizeChoose);
            button.setText(data.getStringExtra("size"));
            Toast.makeText(getBaseContext(),"You choose "+data.getStringExtra("size"),Toast.LENGTH_LONG).show();


        }
        if (requestCode == 2){
            if (resultCode == 1){

                login = true;
            }

        }else if(requestCode == 6){

        }
    }
    public void onClickLike(View view){

        if (((Integer) like.getTag()) == R.drawable.ic_thumb_up_black_24dp){
            like.setImageResource(R.drawable.ic_thumb_up_black_24dp2);
            like.setTag(R.drawable.ic_thumb_up_black_24dp2);
        }else{
            like.setImageResource(R.drawable.ic_thumb_up_black_24dp);
            like.setTag(R.drawable.ic_thumb_up_black_24dp);
        }
    }
}
