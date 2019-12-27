package com.example.kimdk.harusikdan_survey.model;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private static Person single_instance = null;
    private double weight;
    private double height;
    private boolean gender;   //4th fragment
    private int age;
    private int activity;  //5th fragment
    private int targetCalorie;  //이건 서버에서 자동 설정
    private List<Integer> diseaseList;
    private List<String> preferredList;
    private List<String> hateList;

    public List<Integer> getDiseaseList() {
        return diseaseList;
    }

    public void setDiseaseList(List<Integer> diseaseList) {
        this.diseaseList = diseaseList;
    }

    public int getActivity() {
        return activity;
    }

    public void setActivity(int activity) {
        this.activity = activity;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
//List<String> hatelist;

    private Person() {
        diseaseList = new ArrayList<>();
        preferredList = new ArrayList<>();
        hateList = new ArrayList<>();
    }

    public static Person getInstance() {
        if (single_instance == null) {
            single_instance = new Person();
        }

        return single_instance;
    }


    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public void addDisease(Integer num) {
        //리스트에 중복을 피하기 위함.
        if(diseaseList.contains(num) == false)
            diseaseList.add(num);
    }

    public void removeDisease(Integer num) {
        for (int i = 0; i < diseaseList.size(); i++) {
            if (diseaseList.get(i).equals(num)) {
                diseaseList.remove(i);
            }
        }
    }

    public void addPreferred(String foodName) {
        if(preferredList.contains(foodName) == false)
            preferredList.add(foodName);
    }

    public void removePreferred(String foodName) {
        for (int i = 0; i < preferredList.size(); i++) {
            if (preferredList.get(i).equals(foodName.trim())) {
                preferredList.remove(i);
            }
        }
    }

    public void addHate(String foodName) {
        if(hateList.contains(foodName) == false)
                hateList.add(foodName);
    }

    public void removeHate(String foodName) {
        for (int i = 0; i < hateList.size(); i++) {
            if (hateList.get(i).equals(foodName.trim())) {
                hateList.remove(i);
            }
        }
    }

    public List<String> getPreferredList() {
        return preferredList;
    }

    public void setPreferredList(List<String> preferredList) {
        this.preferredList = preferredList;
    }

    public List<String> getHateList() {
        return hateList;
    }

    public void setHateList(List<String> hateList) {
        this.hateList = hateList;
    }
}
