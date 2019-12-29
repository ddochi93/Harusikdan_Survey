package com.example.kimdk.harusikdan_survey.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Value {

    @SerializedName("food_carbo")
    @Expose
    private Double foodCarbo;
    @SerializedName("food_cholesterol")
    @Expose
    private Double foodCholesterol;
    @SerializedName("food_fat")
    @Expose
    private Double foodFat;
    @SerializedName("food_fattyacid")
    @Expose
    private Double foodFattyacid;
    @SerializedName("food_kcal")
    @Expose
    private Double foodKcal;
    @SerializedName("food_one_time")
    @Expose
    private Double foodOneTime;
    @SerializedName("food_protein")
    @Expose
    private Double foodProtein;
    @SerializedName("food_salt")
    @Expose
    private Double foodSalt;
    @SerializedName("food_sugar")
    @Expose
    private Double foodSugar;
    @SerializedName("food_transfattyacid")
    @Expose
    private Double foodTransfattyacid;

    public Double getFoodCarbo() {
        return foodCarbo;
    }

    public void setFoodCarbo(Double foodCarbo) {
        this.foodCarbo = foodCarbo;
    }

    public Double getFoodCholesterol() {
        return foodCholesterol;
    }

    public void setFoodCholesterol(Double foodCholesterol) {
        this.foodCholesterol = foodCholesterol;
    }

    public Double getFoodFat() {
        return foodFat;
    }

    public void setFoodFat(Double foodFat) {
        this.foodFat = foodFat;
    }

    public Double getFoodFattyacid() {
        return foodFattyacid;
    }

    public void setFoodFattyacid(Double foodFattyacid) {
        this.foodFattyacid = foodFattyacid;
    }

    public Double getFoodKcal() {
        return foodKcal;
    }

    public void setFoodKcal(Double foodKcal) {
        this.foodKcal = foodKcal;
    }

    public Double getFoodOneTime() {
        return foodOneTime;
    }

    public void setFoodOneTime(Double foodOneTime) {
        this.foodOneTime = foodOneTime;
    }

    public Double getFoodProtein() {
        return foodProtein;
    }

    public void setFoodProtein(Double foodProtein) {
        this.foodProtein = foodProtein;
    }

    public Double getFoodSalt() {
        return foodSalt;
    }

    public void setFoodSalt(Double foodSalt) {
        this.foodSalt = foodSalt;
    }

    public Double getFoodSugar() {
        return foodSugar;
    }

    public void setFoodSugar(Double foodSugar) {
        this.foodSugar = foodSugar;
    }

    public Double getFoodTransfattyacid() {
        return foodTransfattyacid;
    }

    public void setFoodTransfattyacid(Double foodTransfattyacid) {
        this.foodTransfattyacid = foodTransfattyacid;
    }

}