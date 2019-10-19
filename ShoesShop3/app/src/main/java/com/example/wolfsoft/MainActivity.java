package com.example.wolfsoft;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;


import android.os.Bundle;


import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.example.myapplication.AccountManagement;
import com.example.myapplication.AdminAddBrandAndShoesName;
import com.example.myapplication.AdminManageChat;
import com.example.myapplication.AdminViewBill;
import com.example.myapplication.BuyHistory;
import com.example.myapplication.ChatActivity;

import com.example.myapplication.CheckUploadedItem;
import com.example.myapplication.ListProductChat;
import com.example.myapplication.OrderManagement;
import com.example.myapplication.SearchResult;
import com.example.myapplication.SupportActivity;
import com.example.myapplication.TermAndPolicies;
import com.example.myapplication.ViewBillDetailPending;
import com.example.myapplication.ViewCart;

import com.example.myapplication.ViewSellingItem;
import com.example.myapplication.Withdraw;
import com.example.wolfsoft.data.ProductBase;


import com.example.wolfsoft.get_detail.BrandNames;
import com.example.wolfsoft.get_detail.BrandsAdapter;
import com.example.wolfsoft.ui.ProductBaseAdapter;
import com.example.wolfsoft.ui.login.LoginActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.ActionBar;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.view.ViewGroup;
import android.widget.AdapterView;


import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import static android.app.PendingIntent.getActivity;

public class MainActivity extends AppCompatActivity implements  BaseSliderView.OnSliderClickListener ,SearchView.OnQueryTextListener {

    private AppBarConfiguration mAppBarConfiguration;
    ViewPager viewPager;
    ImageAdapter imageAdapter;
    int currentPage = 0;
    Timer timer;
    private boolean login = false;
    BrandsAdapter brandsAdapter;
    String cartShoes = "cart";
    final long DELAY_MS=500;
    final long PERIOD_MS = 3000;
    private int[] brands = new int[]{R.drawable.addidas,R.drawable.nike,R.drawable.converse,R.drawable.vanz,R.drawable.skechers,
    R.drawable.puma_b};
    private  int[] ints= new int[]{R.drawable.comercial1,R.drawable.comercial2,R.drawable.comercial3};
    private  int[] items  = new int[]{R.drawable.item1,R.drawable.item2,R.drawable.item3,R.drawable.item4,R.drawable.item5,
            R.drawable.item6,R.drawable.item7
    ,R.drawable.item8,R.drawable.item9,R.drawable.item10,R.drawable.item11,R.drawable.item12,R.drawable.item13,R.drawable.item14,R.drawable.item15,
            R.drawable.item16,R.drawable.item17,R.drawable.item18,R.drawable.item19,R.drawable.item20,R.drawable.item21,R.drawable.item22
            ,R.drawable.item23,R.drawable.item24,R.drawable.item25,R.drawable.item26,R.drawable.item27,R.drawable.item28};
    private String[] brandList = new String[]{"Addidas","Nike","Supreme","Polo","Puma"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},1);
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.RECEIVE_SMS},1);
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CAMERA},1);
        viewPager =(ViewPager) findViewById(R.id.viewPager);
        imageAdapter = new ImageAdapter(this,ints);

        viewPager.setAdapter(imageAdapter);
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == 4-1) {
                    currentPage = 0;
                }
                viewPager.setCurrentItem(currentPage++, true);
            }
        };

        timer = new Timer(); // This will create a new Thread
        timer.schedule(new TimerTask() { // task to be scheduled
            @Override
            public void run() {
                handler.post(Update);
            }
        }, DELAY_MS, PERIOD_MS);
        Toolbar toolbar = findViewById(R.id.toolbar);
        SearchView search = new SearchView(this);
        search.setId(R.id.search);
        ListView listView = findViewById(R.id.listViewSearch);
        ArrayList<BrandNames> brandNames = new ArrayList<>();
        for (int i = 0;i<brandList.length;i++){
            BrandNames brandName = new BrandNames(brandList[i]);
            brandNames.add(brandName);
        }
         brandsAdapter = new BrandsAdapter(MainActivity.this,brandNames);
        listView.setAdapter(brandsAdapter);
        search.setOnQueryTextListener( MainActivity.this);

        ActionBar.LayoutParams layoutParamSearch = new ActionBar.LayoutParams(
                Gravity.RIGHT);

        layoutParamSearch.gravity = Gravity.RIGHT;
        layoutParamSearch.setMargins(0, 0, 0, 0);
        search.setGravity(Gravity.RIGHT);
        search.setLayoutParams(layoutParamSearch);
        Button cart = new Button(this);
        ActionBar.LayoutParams LayoutButton = new ActionBar.LayoutParams(
                50, 50);
        cart.setBackgroundResource(R.drawable.ic_shopping_cart_black_24dp);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViewCart.class);
                intent.putExtra("login",login);
                startActivity(intent);
            }
        });
        LayoutButton.gravity = Gravity.RIGHT;
        layoutParamSearch.setMargins(50, 0, 0, 0);
        cart.setLayoutParams(layoutParamSearch);

        cart.setLayoutParams(LayoutButton);
        search.setQueryHint("Shoes names, brands");

        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.d("SEARCHyyy", "onQueryTextSubmit: " + query);
                if(query.equals("dd")){
                    if(login == true){
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                        builder.setCancelable(false);
                        builder.setTitle("Sale succeed");
                        builder.setMessage("A user had order your shoes!");



                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //change back to home
                                Intent intent = new Intent(MainActivity.this, ViewBillDetailPending.class);
                                intent.putExtra("seller","seller");
                                intent.putExtra("name","Search");
                                intent.putExtra("login",login);
                                startActivity(intent);


                            }
                        });
                        builder.show();

                    }else{

                    }
                }else{
                    Intent intent = new Intent(MainActivity.this,SearchResult.class);
                    intent.putExtra("name","Search");
                    intent.putExtra("login",login);
                    startActivity(intent);
                }

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        ImageView searchIcon = (ImageView) search.findViewById(search.getContext().getResources().getIdentifier("android:id/search_button",null,null));
        searchIcon.setImageResource(R.drawable.ic_search_black_24dp);

        toolbar.addView(cart);
        toolbar.addView(search);
        TextView textView = new TextView(this);
        textView.setText("Shoes market");
        float alpha = (float) 0.9;
        textView.setAlpha(alpha);
        toolbar.addView(textView);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        Intent loginIntent = this.getIntent();
        login = loginIntent.getBooleanExtra("login",false);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (login == false){
                    Intent intent = new Intent(MainActivity.this, ChatActivity.class);

                    startActivity(intent);
                }else{
                    Intent intent = new Intent(MainActivity.this, ListProductChat.class);

                    startActivity(intent);
                }

            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        final NavigationView navigationView = findViewById(R.id.nav_view);

        LinearLayout youMayLikeLayout = findViewById(R.id.youMayLikeLayout);
        LinearLayout topSell = findViewById(R.id.topSell);
        LinearLayout topLuxury = findViewById(R.id.topLuxury);
        LinearLayout newRelease = findViewById(R.id.newRelease);

        for (int i = 0;i<9;i++){
            LinearLayout product = new LinearLayout(this);
            ImageView imageView = new ImageView(this);
            TextView name = new TextView(this);
            TextView price = new TextView(this);
            imageView.setImageResource(items[autoGenerate(0,items.length-1)]);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            String alphabet = "qwertyuiopasdfghjklzxcvbnm";
            String alphabet1 = "QWERTYUIOPASDFGHJKLZXCVBNM";
            name.setText( "Shoes " + ++i);
            i--;

            price.setText("Start with " + new Random().nextInt(8 + 1) + 10 + "$");
            imageView.setLayoutParams(new LinearLayout.LayoutParams(
                    200,
                    150));
            name.setLayoutParams(new LinearLayout.LayoutParams(
                    200,
                    50));

            price.setLayoutParams(new LinearLayout.LayoutParams(
                    200,
                    70));
            product.setOrientation(LinearLayout.VERTICAL);
            product.addView(imageView);
            product.addView(name);
            product.addView(price);
            name.setTextSize(14);
            price.setTextSize(12);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(50,10,0,0);
            product.setLayoutParams(layoutParams);

            youMayLikeLayout.addView(product);
            product.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this,ViewProductActivity.class);
                    intent.putExtra("cart",cartShoes);
                    intent.putExtra("login",login);
                    startActivity(intent);

                }
            });
        }
        for (int i = 0;i<9;i++){
            LinearLayout product3 = new LinearLayout(this);
            ImageView imageView3 = new ImageView(this);
            TextView name3 = new TextView(this);
            TextView price3 = new TextView(this);
            imageView3.setImageResource(items[autoGenerate(0,items.length-1)]);
            String alphabet = "qwertyuiopasdfghjklzxcvbnm";
            String alphabet1 = "QWERTYUIOPASDFGHJKLZXCVBNM";
            name3.setText( "Shoes " + ++i);
            i--;

            price3.setText("Start with " + new Random().nextInt(8 + 1) + 10 + "$");
            imageView3.setLayoutParams(new LinearLayout.LayoutParams(
                    200,
                    150));
            name3.setLayoutParams(new LinearLayout.LayoutParams(
                    200,
                    50));
            price3.setLayoutParams(new LinearLayout.LayoutParams(
                    200,
                    70));
            imageView3.setScaleType(ImageView.ScaleType.FIT_XY);
            product3.setOrientation(LinearLayout.VERTICAL);
            product3.addView(imageView3);
            product3.addView(name3);
            product3.addView(price3);

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(50,10,0,0);
            product3.setLayoutParams(layoutParams);
            name3.setTextSize(14);
            price3.setTextSize(12);

            topSell.addView(product3);
            product3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this,ViewProductActivity.class);
                    intent.putExtra("cart",cartShoes);
                    intent.putExtra("login",login);
                    startActivity(intent);

                }
            });
        }
        for (int i = 0;i<9;i++){
            LinearLayout product2 = new LinearLayout(this);
            ImageView imageView2 = new ImageView(this);
            TextView name2 = new TextView(this);
            TextView price2 = new TextView(this);
            imageView2.setImageResource(items[autoGenerate(0,items.length-1)]);
            String alphabet = "qwertyuiopasdfghjklzxcvbnm";
            String alphabet1 = "QWERTYUIOPASDFGHJKLZXCVBNM";
            name2.setText( "Shoes " + ++i);
            i--;

            price2.setText("Start with " + new Random().nextInt(8 + 1) + 10 + "$");
            imageView2.setLayoutParams(new LinearLayout.LayoutParams(
                    200,
                    150));
            name2.setLayoutParams(new LinearLayout.LayoutParams(
                    200,
                    50));
            price2.setLayoutParams(new LinearLayout.LayoutParams(
                    200,
                    70));
            product2.setOrientation(LinearLayout.VERTICAL);
            product2.addView(imageView2);
            product2.addView(name2);
            product2.addView(price2);
            imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(50,10,0,0);
            product2.setLayoutParams(layoutParams);
            name2.setTextSize(14);
            price2.setTextSize(12);

            topLuxury.addView(product2);
            product2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this,ViewProductActivity.class);
                    intent.putExtra("cart",cartShoes);
                    intent.putExtra("login",login);
                    startActivity(intent);

                }
            });
        }
        LinearLayout historyView = findViewById(R.id.historyViewt);
        for (int i = 0;i<9;i++){
            LinearLayout product4 = new LinearLayout(this);
            ImageView imageView4 = new ImageView(this);
            TextView name4 = new TextView(this);
            TextView price4 = new TextView(this);
            imageView4.setImageResource(items[autoGenerate(0,items.length-1)]);
            String alphabet = "qwertyuiopasdfghjklzxcvbnm";
            String alphabet1 = "QWERTYUIOPASDFGHJKLZXCVBNM";
            name4.setText( "Shoes " + ++i);
            i--;

            price4.setText("Start with " + new Random().nextInt(8 + 1) + 10 + "$");
            imageView4.setLayoutParams(new LinearLayout.LayoutParams(
                    200,
                    150));
            name4.setLayoutParams(new LinearLayout.LayoutParams(
                    200,
                    50));
            price4.setLayoutParams(new LinearLayout.LayoutParams(
                    200,
                    70));
            product4.setOrientation(LinearLayout.VERTICAL);
            product4.addView(imageView4);
            product4.addView(name4);
            product4.addView(price4);
            imageView4.setScaleType(ImageView.ScaleType.FIT_XY);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(50,10,0,0);
            product4.setLayoutParams(layoutParams);
            name4.setTextSize(14);
            price4.setTextSize(12);

            historyView.addView(product4);
            product4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this,ViewProductActivity.class);
                    intent.putExtra("cart",cartShoes);
                    intent.putExtra("login",login);
                    startActivity(intent);

                }
            });
        }
        GridView gridView = findViewById(R.id.moreProduct);
        ArrayList<ProductBase> linearLayouts = new ArrayList<>();
        for (int i = 0;i<12;i++){


            ProductBase productBase = new ProductBase("Shoes ABC","Start with: 3000$","R.drawable.shoe1");
            linearLayouts.add(productBase);


        }
        ProductBaseAdapter productBaseAdapter = new ProductBaseAdapter(linearLayouts,MainActivity.this);
        Log.d("CHECK22", "onCreate: "+linearLayouts.size());
        gridView.setAdapter(productBaseAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,ViewProductActivity.class);
                intent.putExtra("cart",cartShoes);
                intent.putExtra("login",login);
                startActivity(intent);
            }
        });
        for (int i = 0;i<9;i++){
            LinearLayout product1 = new LinearLayout(this);
            ImageView imageView1 = new ImageView(this);
            TextView name1 = new TextView(this);
            TextView price1 = new TextView(this);
            imageView1.setImageResource(items[autoGenerate(0,items.length-1)]);
            String alphabet = "qwertyuiopasdfghjklzxcvbnm";
            String alphabet1 = "QWERTYUIOPASDFGHJKLZXCVBNM";
            name1.setText( "Shoes " + ++i);
            i--;

            price1.setText("Start with " + new Random().nextInt(8 + 1) + 10 + "$");
            imageView1.setLayoutParams(new LinearLayout.LayoutParams(
                    200,
                    150));
            name1.setLayoutParams(new LinearLayout.LayoutParams(
                    200,
                    50));
            price1.setLayoutParams(new LinearLayout.LayoutParams(
                    200,
                    70));
            product1.setOrientation(LinearLayout.VERTICAL);
            product1.addView(imageView1);
            product1.addView(name1);
            product1.addView(price1);
            name1.setTextSize(14);
            price1.setTextSize(12);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(50,10,0,0);
            product1.setLayoutParams(layoutParams);
            imageView1.setScaleType(ImageView.ScaleType.FIT_XY);

            newRelease.addView(product1);
            product1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, ViewProductActivity.class);
                    intent.putExtra("cart",cartShoes);
                    intent.putExtra("login",login);
                    startActivity(intent);

                }
            });
        }
        final Intent image = new Intent(MainActivity.this, SearchResult.class);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                100, 100);
        layoutParams.setMargins(0,50,0,0);
        ImageView imageView = new ImageView(this);
        imageView.setLayoutParams(layoutParams);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        imageView.setBackgroundResource(R.drawable.ic_more_horiz_black_24dp);
        ImageView imageView1 = new ImageView(this);
        imageView1.setLayoutParams(layoutParams);
        imageView1.setScaleType(ImageView.ScaleType.CENTER);
        imageView1.setBackgroundResource(R.drawable.ic_more_horiz_black_24dp);
        ImageView imageView2 = new ImageView(this);
        imageView2.setLayoutParams(layoutParams);
        imageView2.setScaleType(ImageView.ScaleType.CENTER);
        imageView2.setBackgroundResource(R.drawable.ic_more_horiz_black_24dp);
        ImageView imageView3 = new ImageView(this);
        imageView3.setLayoutParams(layoutParams);
        imageView3.setScaleType(ImageView.ScaleType.CENTER);
        imageView3.setBackgroundResource(R.drawable.ic_more_horiz_black_24dp);
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image.putExtra("name","Top luxury");
                image.putExtra("login",login);
                startActivity(image);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image.putExtra("name","Top sell");
                image.putExtra("login",login);
                startActivity(image);
            }
        });
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image.putExtra("name","You may like");
                image.putExtra("login",login);
                startActivity(image);
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image.putExtra("name","New release");
                image.putExtra("login",login);
                startActivity(image);
            }
        });
        ImageView history = new ImageView(this);
        history.setLayoutParams(layoutParams);
        history.setScaleType(ImageView.ScaleType.CENTER);
        history.setBackgroundResource(R.drawable.ic_more_horiz_black_24dp);
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image.putExtra("name","History view");
                image.putExtra("login",login);
                startActivity(image);
            }
        });
        historyView.addView(history);
        newRelease.addView(imageView);
        youMayLikeLayout.addView(imageView1);
        topSell.addView(imageView2);
        topLuxury.addView(imageView3);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_login,R.id.nav_manage_account,R.id.nav_order_management,
                R.id.nav_setting, R.id.nav_history_payment, R.id.nav_liked,R.id.nav_support)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
        LinearLayout linearLayout = findViewById(R.id.brandList);
        LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(100,100);
        layoutParams1.setMargins(40,0,0,0);

        for (int i = 0; i< brands.length;i++){
            ImageView imageView4 = new ImageView(this);
            imageView4.setLayoutParams(layoutParams1);
            imageView4.setImageResource(brands[i]);
            linearLayout.addView(imageView4);
            imageView4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    image.putExtra("name","Products");
                    image.putExtra("login",login);
                    startActivity(image);
                }
            });
        }

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                int id = menuItem.getItemId();
                Intent intent3 = new Intent(MainActivity.this, ViewSellingItem.class);
                switch (id) {
                    case R.id.nav_login:
                        Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                        intent.putExtra("login",login);
                        startActivityForResult(intent,2);



                        break;
                    case R.id.nav_my_store:
                        Intent intent1 = new Intent(MainActivity.this,MyStore.class);
                        intent1.putExtra("login",login);
                        startActivity(intent1);
                        break;
                    case R.id.nav_logout:
                        NavigationView navigationView = findViewById(R.id.nav_view);
                        Log.d("CHECK10", "onChanged: " + navigationView);
                        navigationView.getMenu().findItem(R.id.nav_login).setVisible(true);
                        navigationView.getMenu().findItem(R.id.nav_logout).setVisible(false);
                        navigationView.getMenu().findItem(R.id.nav_my_store).setVisible(false);
                        TextView username = findViewById(R.id.usernameLoged);
                        TextView money = findViewById(R.id.money);
                        username.setVisibility(View.INVISIBLE);
                        money.setVisibility(View.INVISIBLE);

                        navigationView.getMenu().findItem(R.id.nav_manage_account).setVisible(false);
                        login =false;

                        break;
                    case R.id.nav_setting:
                        Intent intent2 = new Intent(MainActivity.this,SettingsActivity.class);
                        intent2.putExtra("login", login);
                        startActivity(intent2);
                        break;
                    case R.id.nav_history_payment:
                        if(login == false){
                            Intent intent10 = new Intent(MainActivity.this, BuyHistory.class);
                            intent10.putExtra("name","History buy/sell");
                            intent10.putExtra("login", login);
                            intent10.putExtra("cart","cart");
                            intent10.putExtra("showMore", "4");
                            startActivity(intent10);
                        }else {
                            intent3.putExtra("name","History buy/sell");
                            intent3.putExtra("login", login);
                            intent3.putExtra("cart","cart");
                            intent3.putExtra("showMore", "4");
                            startActivity(intent3);
                        }

                        break;
                    case R.id.nav_liked:
                        Intent intent4 = new Intent(MainActivity.this,SearchResult.class);
                        intent4.putExtra("name","Liked shoes");
                        intent4.putExtra("login", login);
                        intent4.putExtra("cart","cart");
                        intent4.putExtra("showMore", "3");
                        startActivity(intent4);
                        break;

                    case R.id.nav_manage_account:
                        Intent intent6 = new Intent(MainActivity.this, AccountManagement.class);
                        intent6.putExtra("login", login);
                        startActivity(intent6);
                        //Do some thing here
                        break;
                        // add navigation drawer item onclick method here
                    case R.id.nav_order_management:
                        Intent intent5 = new Intent(MainActivity.this, OrderManagement.class);
                        intent5.putExtra("login", login);
                        startActivity(intent5);
                        break;
                    case R.id.nav_support:
                        Intent intent7 = new Intent(MainActivity.this, SupportActivity.class);
                        intent7.putExtra("login", login);
                        startActivity(intent7);
                        break;
                    case R.id.nav_term_policy:
                        Intent intent8 = new Intent(MainActivity.this, TermAndPolicies.class);
                        intent8.putExtra("login", login);
                        startActivity(intent8);
                        break;
                }
                return false;
            }
        });
        if (login == true){

            navigationView.getMenu().findItem(R.id.nav_login).setVisible(false);
            navigationView.getMenu().findItem(R.id.nav_logout).setVisible(true);
            navigationView.getMenu().findItem(R.id.nav_my_store).setVisible(true);
            navigationView.getMenu().findItem(R.id.nav_manage_account).setVisible(true);
            View header = navigationView.getHeaderView(0);
            LinearLayout constraintLayout = header.findViewById(R.id.logedView);

            TextView username = header.findViewById(R.id.usernameLoged);
            TextView money = header.findViewById(R.id.money);
            username.setVisibility(View.VISIBLE);
            money.setVisibility(View.VISIBLE);
            constraintLayout.setVisibility(View.VISIBLE);
            login = true;
        }
    }
    @SuppressLint("SetTextI18n")
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        Log.d("CHECK41", "onActivityResult: "+resultCode);
        if (requestCode == 2){
            if (resultCode == 1){
                NavigationView navigationView = findViewById(R.id.nav_view);
                Log.d("CHECK10", "onChanged: " + navigationView);
                navigationView.getMenu().findItem(R.id.nav_login).setVisible(false);
                navigationView.getMenu().findItem(R.id.nav_logout).setVisible(true);
                navigationView.getMenu().findItem(R.id.nav_my_store).setVisible(true);
                LinearLayout constraintLayout = findViewById(R.id.logedView);
                constraintLayout.setVisibility(View.VISIBLE);

                TextView usernameLoged = findViewById(R.id.usernameLoged);
                TextView money = findViewById(R.id.money);
                usernameLoged.setVisibility(View.VISIBLE);
                money.setVisibility(View.VISIBLE);
                navigationView.getMenu().findItem(R.id.nav_manage_account).setVisible(true);
                login = true;
            }else if(resultCode == 2){
                Intent intent = new Intent(MainActivity.this, CheckUploadedItem.class);
                intent.putExtra("login","admin");
                startActivity(intent);
            }else if(resultCode == 3){
                Intent intent = new Intent(MainActivity.this, AdminViewBill.class);
                intent.putExtra("login","admin");
                startActivity(intent);
            }else if(resultCode == 4){
                Intent intent = new Intent(MainActivity.this, AdminManageChat.class);
                intent.putExtra("login","admin");
                startActivity(intent);
            }else if(resultCode == 6){
                Intent intent = new Intent(MainActivity.this, AdminAddBrandAndShoesName.class);
                intent.putExtra("login","admin");
                startActivity(intent);
            }


        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.text_home:
                Intent intent = new Intent(this,LoginActivity.class);
                startActivity(intent);
                return true;

            case R.id.text_send:
                // Some other methods
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
    public void login(View view){
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);

    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
    private int autoGenerate(int min, int max){
        Random r = new Random();
        return r.nextInt((max -min) + 1) + min;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText){
        String text = newText;
        brandsAdapter.filter(text);
        return false;
    }
}
