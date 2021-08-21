package com.example.and3hw2.data.network;

import com.example.and3hw2.model.Episode;
import com.example.and3hw2.model.RickAndMortyResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EpisodeApiService {
    @GET("api/episode")
    Call<RickAndMortyResponse<Episode>> fetchEpisodes();
}
