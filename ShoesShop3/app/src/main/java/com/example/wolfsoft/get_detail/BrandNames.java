package com.example.wolfsoft.get_detail;

import java.io.Serializable;

public class BrandNames implements Serializable {
    private String name;

    public BrandNames() {
    }

    public BrandNames(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
