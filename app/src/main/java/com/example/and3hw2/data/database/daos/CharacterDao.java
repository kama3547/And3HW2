package com.example.and3hw2.data.database.daos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.and3hw2.model.Character;
import com.example.and3hw2.model.Episode;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface CharacterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(ArrayList<Character> character);

    @Query("SELECT * FROM character")
    List<Character> getAll();
}
