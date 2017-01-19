package com.lucasbais.tinyandroidapp.dto;


/**
 * Created by zehemz on 18/01/2017.
 */

public class AuthUser {

    public String token_type;
    public String access_token;

    public AuthUser(String token_type, String access_token) {
        this.token_type = token_type;
        this.access_token = access_token;
    }

    public boolean isValidUser(){
        return !token_type.equals("") && !access_token.equals("");
    }
}
