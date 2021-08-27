package com.example.and3hw2.data.network.apiservice;

import com.example.and3hw2.model.Episode;
import com.example.and3hw2.model.RickAndMortyResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface EpisodeApiService {
    @GET("api/episode")
    Call<RickAndMortyResponse<Episode>> fetchEpisodes(@Query("page") int page);
}
