package com.example.and3hw2.data.network.apiservice;

import com.example.and3hw2.model.Location;
import com.example.and3hw2.model.RickAndMortyResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface LocationApiService {
    @GET("api/location")
    Call<RickAndMortyResponse<Location>> fetchLocations(@Query("page") int page);
}
