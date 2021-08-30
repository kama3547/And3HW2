package com.example.and3hw2;

import android.app.Application;

import com.example.and3hw2.data.database.RoomClient;
import com.example.and3hw2.data.database.daos.CharacterDao;
import com.example.and3hw2.data.database.daos.EpisodeDao;
import com.example.and3hw2.data.database.daos.LocationDao;
import com.example.and3hw2.data.network.apiservice.CharacterApiService;
import com.example.and3hw2.data.network.apiservice.EpisodeApiService;
import com.example.and3hw2.data.network.apiservice.LocationApiService;
import com.example.and3hw2.data.network.RetrofitClient;

public class App extends Application {

    public static CharacterApiService characterApiService;
    public static EpisodeApiService episodeApiService;
    public static LocationApiService locationApiService;
    public static CharacterDao characterDao;
    public static EpisodeDao episodeDao;
    public static LocationDao locationDao;
    public RetrofitClient retrofitClient = new RetrofitClient();

    @Override
    public void onCreate() {
        super.onCreate();
        characterApiService = retrofitClient.provideCharacterApiService();
        episodeApiService = retrofitClient.provideEpisodeApiService();
        locationApiService = retrofitClient.provideLocationApiService();
        RoomClient roomClient = new RoomClient();
        characterDao = roomClient.provideCharacterDao(roomClient.provideDatabase(this));
        episodeDao = roomClient.provideEpisodeDao(roomClient.provideDatabase(this));
        locationDao = roomClient.provideLocationDao(roomClient.provideDatabase(this));
    }
}
