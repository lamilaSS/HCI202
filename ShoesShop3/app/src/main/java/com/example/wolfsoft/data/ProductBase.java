package com.example.wolfsoft.data;



import com.example.wolfsoft.R;

import java.io.Serializable;
import java.util.Random;

public class ProductBase implements Serializable {
    private String name;
    private String price;
    private String imageView;

    public ProductBase() {
    }

    public ProductBase(String name, String price, String imageView) {
        this.name = name;
        this.price = price;
        this.imageView = imageView;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImageView() {
        return imageView;
    }

    public void setImageView(String imageView) {
        this.imageView = imageView;
    }
}
