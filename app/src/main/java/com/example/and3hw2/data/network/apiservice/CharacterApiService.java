package com.example.and3hw2.data.network.apiservice;

import com.example.and3hw2.model.Character;
import com.example.and3hw2.model.RickAndMortyResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CharacterApiService extends EpisodeApiService {
    @GET("api/character")
    Call<RickAndMortyResponse<Character>> fetchCharacters(
            @Query("page") int page);
    @GET("api/character/{id}")
    Call<Character> fetCharactersId(@Path("id") int id);
}
