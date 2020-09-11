package com.example.myapplication.gadsleaderboard.model;

import com.google.gson.annotations.SerializedName;

public class SkillIQLeaders {

    @SerializedName("name")
    private String skillLeaderName;

    @SerializedName("score")
    private String skillscore;

    @SerializedName("country")
    private String countrySkillName;

    @SerializedName("badgeUrl")
    private String imageUrl;

    public SkillIQLeaders(String skillLeaderName, String skillscore, String countrySkillName, String imageUrl) {
        this.skillLeaderName = skillLeaderName;
        this.skillscore = skillscore;
        this.countrySkillName = countrySkillName;
        this.imageUrl = imageUrl;
    }

    public String getSkillLeaderName() {
        return skillLeaderName;
    }

    public void setSkillLeaderName(String skillLeaderName) {
        this.skillLeaderName = skillLeaderName;
    }

    public String getSkillscore() {
        return skillscore;
    }

    public void setSkillscore(String skillscore) {
        this.skillscore = skillscore;
    }

    public String getCountrySkillName() {
        return countrySkillName;
    }

    public void setCountrySkillName(String countrySkillName) {
        this.countrySkillName = countrySkillName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
