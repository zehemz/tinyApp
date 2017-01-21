package com.lucasbais.tinyandroidapp.dto;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by zehemz on 21/01/2017.
 */

public class TweetList {

    @SerializedName("statuses")
    public List<Tweet> tweets;


}
