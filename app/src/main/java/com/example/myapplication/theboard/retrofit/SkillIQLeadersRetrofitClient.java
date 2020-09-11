package com.example.myapplication.gadsleaderboard.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SkillIQLeadersRetrofitClient {

    private static Retrofit retrofit;
    private static final String BASE_URL = "https://gadsapi.herokuapp.com/";

    public static Retrofit getRetrofitClient() {

        if (retrofit == null) {

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
