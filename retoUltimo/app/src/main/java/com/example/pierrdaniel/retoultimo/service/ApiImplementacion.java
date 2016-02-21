package com.example.pierrdaniel.retoultimo.service;

import retrofit.RestAdapter;

/**
 * Created by PIERR DANIEL on 20/02/2016.
 */
public class ApiImplementacion {
    private static RestAdapter restAdapter = new RestAdapter.Builder()
    .setEndpoint("http://victorcasass.com/api/")
    .build();

    public static ApiService getService(){
        return restAdapter.create(ApiService.class);
    }
}
