package com.example.and3hw2.data.database;

import android.content.Context;

import androidx.room.Room;

import com.example.and3hw2.data.database.daos.CharacterDao;
import com.example.and3hw2.data.database.daos.EpisodeDao;
import com.example.and3hw2.data.database.daos.LocationDao;

public class RoomClient {

    public AppDataBase provideDatabase(Context context) {
        AppDataBase db = Room
                .databaseBuilder(context, AppDataBase.class, "rick-and-morty_database")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();
        return db;
    }

    public CharacterDao provideCharacterDao(AppDataBase appDataBase) {
        return appDataBase.characterDao();
    }
    public EpisodeDao provideEpisodeDao(AppDataBase appDataBase){
        return appDataBase.episodeDao();
    }
    public LocationDao provideLocationDao(AppDataBase appDataBase){
        return  appDataBase.locationDao();
    }
}
