package com.example.kimdk.harusikdan_survey.util;

import com.example.kimdk.harusikdan_survey.model.DiaryList;
import com.example.kimdk.harusikdan_survey.model.PersonResponse;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface PersonAPI {
    String BASE_URL = "https://0b1300be.ngrok.io/";

    @POST("/signUp")
    Call<PersonResponse> postPerson(@Body JsonObject body);

    @POST("/receiveDiary")
    Call<DiaryList> receiveDiary(@Body JsonObject body);


}
