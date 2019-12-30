package com.example.kimdk.harusikdan_survey.util;

import com.example.kimdk.harusikdan_survey.model.DiaryList;
import com.example.kimdk.harusikdan_survey.model.Food;
import com.example.kimdk.harusikdan_survey.model.PersonResponse;
import com.google.gson.JsonObject;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface PersonAPI {
    String BASE_URL = "https://05d1635c.ngrok.io";

    @POST("/signUp")
    Call<PersonResponse> postPerson(@Body JsonObject body);

    @POST("/receiveDiary")
    Call<DiaryList> receiveDiary(@Body JsonObject body);

    @Multipart
    @POST("/sendImg")
    Call<Food> uploadPhoto(
            @Part MultipartBody.Part imagefile
    );

}
