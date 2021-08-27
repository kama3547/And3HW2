package com.example.and3hw2.data.repositories;

import androidx.lifecycle.MutableLiveData;

import com.example.and3hw2.app.App;
import com.example.and3hw2.model.Character;
import com.example.and3hw2.model.Episode;
import com.example.and3hw2.model.RickAndMortyResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EpisodeRepository {

    int page;
   public MutableLiveData<RickAndMortyResponse<Episode>> fetchEpisodes(int page){
        MutableLiveData<RickAndMortyResponse<Episode>> data = new MutableLiveData<>();
        App.episodeApiService.fetchEpisodes(page).enqueue(new Callback<RickAndMortyResponse<Episode>>() {
            @Override
            public void onResponse(Call<RickAndMortyResponse<Episode>> call, Response<RickAndMortyResponse<Episode>> response) {
                if (response.body() !=null){
                    App.episodeDao.insertAll(response.body().getResults());
                    data.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<RickAndMortyResponse<Episode>> call, Throwable t) {
                data.postValue(null);
            }
        });
        return data;
    }
    public List<Episode> getEpisode() {
        return App.episodeDao.getAll();
    }
}
