package com.example.kimdk.harusikdan_survey.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Diary {

    @SerializedName("eat_date")
    @Expose
    private String eatDate;
    @SerializedName("eat_food")
    @Expose
    private String eatFood;
    @SerializedName("eat_time")
    @Expose
    private String eatTime;
    @SerializedName("food_carbo")
    @Expose
    private String foodCarbo;
    @SerializedName("food_cholesterol")
    @Expose
    private String foodCholesterol;
    @SerializedName("food_fat")
    @Expose
    private String foodFat;
    @SerializedName("food_fattyacid")
    @Expose
    private String foodFattyacid;
    @SerializedName("food_kcal")
    @Expose
    private String foodKcal;
    @SerializedName("food_name")
    @Expose
    private String foodName;
    @SerializedName("food_one_time")
    @Expose
    private String foodOneTime;
    @SerializedName("food_protein")
    @Expose
    private String foodProtein;
    @SerializedName("food_salt")
    @Expose
    private String foodSalt;
    @SerializedName("food_sugar")
    @Expose
    private String foodSugar;
    @SerializedName("food_transfattyacid")
    @Expose
    private String foodTransfattyacid;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("user_id")
    @Expose
    private String userId;

    public String getEatDate() {
        return eatDate;
    }

    public void setEatDate(String eatDate) {
        this.eatDate = eatDate;
    }

    public String getEatFood() {
        return eatFood;
    }

    public void setEatFood(String eatFood) {
        this.eatFood = eatFood;
    }

    public String getEatTime() {
        return eatTime;
    }

    public void setEatTime(String eatTime) {
        this.eatTime = eatTime;
    }

    public String getFoodCarbo() {
        return foodCarbo;
    }

    public void setFoodCarbo(String foodCarbo) {
        this.foodCarbo = foodCarbo;
    }

    public String getFoodCholesterol() {
        return foodCholesterol;
    }

    public void setFoodCholesterol(String foodCholesterol) {
        this.foodCholesterol = foodCholesterol;
    }

    public String getFoodFat() {
        return foodFat;
    }

    public void setFoodFat(String foodFat) {
        this.foodFat = foodFat;
    }

    public String getFoodFattyacid() {
        return foodFattyacid;
    }

    public void setFoodFattyacid(String foodFattyacid) {
        this.foodFattyacid = foodFattyacid;
    }

    public String getFoodKcal() {
        return foodKcal;
    }

    public void setFoodKcal(String foodKcal) {
        this.foodKcal = foodKcal;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodOneTime() {
        return foodOneTime;
    }

    public void setFoodOneTime(String foodOneTime) {
        this.foodOneTime = foodOneTime;
    }

    public String getFoodProtein() {
        return foodProtein;
    }

    public void setFoodProtein(String foodProtein) {
        this.foodProtein = foodProtein;
    }

    public String getFoodSalt() {
        return foodSalt;
    }

    public void setFoodSalt(String foodSalt) {
        this.foodSalt = foodSalt;
    }

    public String getFoodSugar() {
        return foodSugar;
    }

    public void setFoodSugar(String foodSugar) {
        this.foodSugar = foodSugar;
    }

    public String getFoodTransfattyacid() {
        return foodTransfattyacid;
    }

    public void setFoodTransfattyacid(String foodTransfattyacid) {
        this.foodTransfattyacid = foodTransfattyacid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}