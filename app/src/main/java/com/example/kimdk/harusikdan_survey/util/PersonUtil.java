package com.example.kimdk.harusikdan_survey.util;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PersonUtil {
    private PersonAPI mGetApi;

    public PersonUtil() {
        Retrofit mRetrofit = new Retrofit.Builder()
                .baseUrl(PersonAPI.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mGetApi = mRetrofit.create(PersonAPI.class);
    }

    public PersonAPI getApi() {
        return this.mGetApi; //외부에서 retrofit객체 갖다 쓸 수 있도록함.
    }
}
