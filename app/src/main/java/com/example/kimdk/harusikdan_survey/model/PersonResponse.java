package com.example.kimdk.harusikdan_survey.model;

import com.google.gson.annotations.SerializedName;

public class PersonResponse {
    @SerializedName("hello")
    private String hello;

    PersonResponse() {
    }

    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }
}
