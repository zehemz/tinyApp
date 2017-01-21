package com.lucasbais.tinyandroidapp.dto;

import com.google.gson.annotations.SerializedName;

/**
 * Created by zehemz on 21/01/2017.
 */

public class TwitterUser {

    @SerializedName("screen_name")
    public String screenName;

    @SerializedName("name")
    public String name;

    @SerializedName("profile_image_url")
    public String profileImageUrl;
}
