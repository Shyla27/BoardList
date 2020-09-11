package com.example.myapplication.gadsleaderboard.model;

import com.google.gson.annotations.SerializedName;

public class LearningLeaders {

    @SerializedName("name")
    private String leaderName;

    @SerializedName("hours")
    private String learninghours;

    @SerializedName("country")
    private String countryName;

    @SerializedName("badgeUrl")
    private String imageUrl;

    public LearningLeaders(String leaderName, String learninghours, String countryName, String imageUrl) {
        this.leaderName = leaderName;
        this.learninghours = learninghours;
        this.countryName = countryName;
        this.imageUrl = imageUrl;
    }

    public String getleaderName() {
        return leaderName;
    }

    public void setleaderName(String skillLeaderName) {
        this.leaderName = skillLeaderName;
    }

    public String getLearninghours() {
        return learninghours;
    }

    public void setLearninghours(String learninghours) {
        this.learninghours = learninghours;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
