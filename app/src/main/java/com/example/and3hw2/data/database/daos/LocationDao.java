package com.example.and3hw2.data.database.daos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.and3hw2.model.Episode;
import com.example.and3hw2.model.Location;

import java.util.ArrayList;
import java.util.List;
@Dao
public interface LocationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(ArrayList<Location> location);

    @Query("SELECT * FROM location")
    List<Location> getAll();

}
