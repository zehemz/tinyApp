package com.lucasbais.tinyandroidapp.dto;

import com.google.gson.annotations.SerializedName;

/**
 * Created by zehemz on 18/01/2017.
 */

public class AuthUser {

    @SerializedName("token_type") public String token_type;
    @SerializedName("access_token") public String access_token;

    public AuthUser(String token_type, String access_token) {
        this.token_type = token_type;
        this.access_token = access_token;
    }

    public String getAuthUserSignature() {
        return "Bearer " + access_token;
    }
}
