package com.lucasbais.tinyandroidapp.dto;

import com.google.gson.annotations.SerializedName;

/**
 * Created by zehemz on 21/01/2017.
 */

public class Tweet {

    @SerializedName("created_at")
    public String dateCreated;

    @SerializedName("id")
    public String id;

    @SerializedName("text")
    public String text;

    @SerializedName("in_reply_to_status_id")
    public String inReplyToStatusId;

    @SerializedName("in_reply_to_user_id")
    public String inReplyToUserId;

    @SerializedName("in_reply_to_screen_name")
    public String inReplyToScreenName;

    @SerializedName("user")
    public TwitterUser user;

    @Override
    public String toString() {
        return text;
    }
}