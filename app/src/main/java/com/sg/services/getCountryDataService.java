package com.sg.services;

import com.sg.model.Info;

import retrofit2.Call;
import retrofit2.http.GET;

public interface getCountryDataService {

    @GET("/country/get/all")
    Call<Info> getAllCountries();
}
