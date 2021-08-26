package com.example.and3hw2.data.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.and3hw2.data.database.daos.CharacterDao;
import com.example.and3hw2.data.database.daos.EpisodeDao;
import com.example.and3hw2.data.database.daos.LocationDao;
import com.example.and3hw2.model.Character;
import com.example.and3hw2.model.Episode;
import com.example.and3hw2.model.Location;

@Database(entities = {Character.class, Episode.class, Location.class},version = 3)
abstract class AppDataBase extends  RoomDatabase {
        public abstract CharacterDao characterDao();
        public abstract EpisodeDao episodeDao();
        public abstract LocationDao locationDao();
}
