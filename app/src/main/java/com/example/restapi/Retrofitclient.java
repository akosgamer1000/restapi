package com.example.restapi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofitclient {
    static final  String BASE_URL="https:/retoolapi.dev/";
    static Retrofit retro;
    static  Retrofit getInstance(){
        if(retro==null){
            retro=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return  retro;
    }
}
