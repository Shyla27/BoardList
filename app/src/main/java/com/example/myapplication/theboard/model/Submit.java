package com.example.myapplication.gadsleaderboard.model;

import com.google.gson.annotations.SerializedName;

public class Submit {

    @SerializedName("firstName")
    private String  firstName;

    @SerializedName("lastName")
    private String  lastName;

    @SerializedName("email")
    private String  email;

    @SerializedName("linkToGithub")
    private String  linkToGithub;


}
