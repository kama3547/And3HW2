package com.example.and3hw2.app;

import android.app.Application;

import com.example.and3hw2.data.network.CharacterApiService;
import com.example.and3hw2.data.network.EpisodeApiService;
import com.example.and3hw2.data.network.LocationApiService;
import com.example.and3hw2.data.network.RetrofitClient;

public class App extends Application {

    public static CharacterApiService characterApiService;
    public static EpisodeApiService episodeApiService;
    public static LocationApiService locationApiService;

    @Override
    public void onCreate() {
        super.onCreate();
        characterApiService = new RetrofitClient().provideCharacterApiService();
        episodeApiService  =  new RetrofitClient().provideEpisodeApiService();
        locationApiService = new RetrofitClient().provideLocationApiService();
    }
}
