package com.example.kimdk.harusikdan_survey.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Food {

    @SerializedName("foodinfo")
    @Expose
    private Foodinfo foodinfo;
    @SerializedName("list")
    @Expose
    private List<String> list = null;

    public Foodinfo getFoodinfo() {
        return foodinfo;
    }

    public void setFoodinfo(Foodinfo foodinfo) {
        this.foodinfo = foodinfo;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

}
