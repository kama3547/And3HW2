package com.example.and3hw2.data.repositories;

import androidx.lifecycle.MutableLiveData;

import com.example.and3hw2.app.App;
import com.example.and3hw2.model.Episode;
import com.example.and3hw2.model.Location;
import com.example.and3hw2.model.RickAndMortyResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LocationRepository  {

   public MutableLiveData<RickAndMortyResponse<Location>> fetchLocations(){
        MutableLiveData<RickAndMortyResponse<Location>> data = new MutableLiveData<>();
        App.locationApiService.fetchLocations().enqueue(new Callback<RickAndMortyResponse<Location>>() {
            @Override
            public void onResponse(Call<RickAndMortyResponse<Location>> call, Response<RickAndMortyResponse<Location>> response) {
                App.locationDao.insertAll(response.body().getResults());
                data.postValue(response.body());
            }

            @Override
            public void onFailure(Call<RickAndMortyResponse<Location>> call, Throwable t) {
                data.postValue(null);
            }
        });
        return data;
    }
    public List<Location> getLocation() {
        return App.locationDao.getAll();
    }
}
