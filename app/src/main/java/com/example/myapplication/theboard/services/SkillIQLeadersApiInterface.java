package com.example.myapplication.gadsleaderboard.services;

import com.example.anew.model.SkillIQLeaders;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SkillIQLeadersApiInterface {

    @GET("api/skilliq")
    Call<List<SkillIQLeaders>> getAllSkillIQLeaders();
}
