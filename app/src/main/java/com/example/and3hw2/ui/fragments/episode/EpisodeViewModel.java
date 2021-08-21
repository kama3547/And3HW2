package com.example.and3hw2.ui.fragments.episode;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.and3hw2.app.App;
import com.example.and3hw2.model.Episode;
import com.example.and3hw2.model.RickAndMortyResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EpisodeViewModel extends ViewModel {

    MutableLiveData<RickAndMortyResponse<Episode>> fetchEpisodes(){
        MutableLiveData<RickAndMortyResponse<Episode>> data = new MutableLiveData<>();
        App.episodeApiService.fetchEpisodes().enqueue(new Callback<RickAndMortyResponse<Episode>>() {
            @Override
            public void onResponse(Call<RickAndMortyResponse<Episode>> call, Response<RickAndMortyResponse<Episode>> response) {
                data.postValue(response.body());
            }

            @Override
            public void onFailure(Call<RickAndMortyResponse<Episode>> call, Throwable t) {
                data.postValue(null);
            }
        });
        return data;
    }
}
