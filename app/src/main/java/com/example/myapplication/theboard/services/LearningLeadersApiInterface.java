package com.example.myapplication.gadsleaderboard.services;

import com.example.anew.model.LearningLeaders;
import com.example.myapplication.gadsleaderboard.model.LearningLeaders;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LearningLeadersApiInterface {

    @GET("api/hours")
    Call<List<LearningLeaders>> getAllLearningLeaders();
}
