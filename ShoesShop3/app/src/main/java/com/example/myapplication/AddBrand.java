package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wolfsoft.AddShoesInformation;
import com.example.wolfsoft.R;
import com.example.wolfsoft.SizeChoosingActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.tooltip.Tooltip;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class AddBrand extends AppCompatActivity {
    private static final int pic_id = 123;
    private static  final int size_id = 1;
    private int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = this.getIntent();
        if(intent.getStringExtra("update") != null){
            setContentView(R.layout.activity_update_brand);
            getSupportActionBar().setTitle("Update brand");
        }else{
            setContentView(R.layout.activity_add_brand);
            getSupportActionBar().setTitle("Add brand");
        }
        camera_open_id = (ImageView)findViewById(R.id.camera_button);
        camera_open_id2 = (ImageView)findViewById(R.id.camera_button2);




        camera_open_id2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(camera_intent, pic_id);
            }
        });
        camera_open_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, 10);
            }
        });
        final ImageView help = findViewById(R.id.help);
        final Tooltip[] tooltip = {null};
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (count == 0) {

                    tooltip[0] = new Tooltip.Builder(help)
                            .setText("Take your shoes pictures\n" +
                                    "You can add pictures from category with Button with IMAGE ICON\n" +
                                    "You can take pictures from camera with Button with CAMERA ICON\n"+
                                    "You can take as many as you want \n" +
                                    "but we recomand you to take from 2 to 5 pictures")

                            .show();
                    count = 1;
                } else {
                    tooltip[0].dismiss();
                    count = 0;
                }
            }
        });




    }
    public void click(View view){

        if(view.getId() == R.id.confirm){
            Toast.makeText(getBaseContext(),"Add successfully.",Toast.LENGTH_LONG).show();
        }else if(view.getId() == R.id.cancel){
            Toast.makeText(getBaseContext(),"Add brand cancel.",Toast.LENGTH_LONG).show();
        }

        finish();
    }
    ImageView camera_open_id;
    ImageView camera_open_id2;
    ImageView click_image_id ;
    public void openCamera(View view){

        camera_open_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent,10);
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode == size_id){
            Button button = findViewById(R.id.sizeChoose);
            button.setText(data.getStringExtra("size"));
            Toast.makeText(getBaseContext(),"You choose" + data.getStringExtra("size"),Toast.LENGTH_LONG).show();


        }
        if (requestCode == pic_id) {

            // BitMap is data structure of image file
            // which stor the image in memory
            Bitmap photo = (Bitmap)data.getExtras()
                    .get("data");
            final LinearLayout imageViewer = findViewById(R.id.imageViewer);
            click_image_id = new ImageView(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(150,150);
            layoutParams.setMargins(0,0,0,0);
            click_image_id.setLayoutParams(layoutParams);
            // Set the image in imageview for display
            click_image_id.setImageBitmap(photo);
            ImageView imageView = findViewById(R.id.click_image);
            imageView.setVisibility(View.GONE);
            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            linearLayout.addView(click_image_id);
            linearLayout.setOrientation(LinearLayout.VERTICAL);
            TextView remove = new TextView(this);
            remove.setText("Remove");
            remove.setTextColor(getResources().getColor(R.color.textred));
            linearLayout.addView(remove);
            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    imageViewer.removeView((View) v.getParent());
                }
            });
            imageViewer.addView(linearLayout);
            Toast.makeText(getBaseContext(),"Take picture successfully",Toast.LENGTH_LONG).show();
        }else if(requestCode == 10 && resultCode == RESULT_OK && null != data){
            try {
                click_image_id = new ImageView(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(150,150);
                layoutParams.setMargins(0,0,0,0);
                click_image_id.setLayoutParams(layoutParams);
                final LinearLayout imageViewer = findViewById(R.id.imageViewer);
                final Uri imageUri = data.getData();
                final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                click_image_id.setImageBitmap(selectedImage);
                ImageView imageView = findViewById(R.id.click_image);
                imageView.setVisibility(View.GONE);
                LinearLayout linearLayout = new LinearLayout(this);
                linearLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                linearLayout.addView(click_image_id);
                linearLayout.setOrientation(LinearLayout.VERTICAL);
                TextView remove = new TextView(this);
                remove.setText("Remove");
                remove.setTextColor(getResources().getColor(R.color.textred));
                linearLayout.addView(remove);
                linearLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        imageViewer.removeView((View) v.getParent());
                    }
                });
                imageViewer.addView(linearLayout);
                Toast.makeText(getBaseContext(),"Add picture successfully",Toast.LENGTH_LONG).show();
            } catch (FileNotFoundException e) {
                e.printStackTrace();

            }
        }
    }
}
