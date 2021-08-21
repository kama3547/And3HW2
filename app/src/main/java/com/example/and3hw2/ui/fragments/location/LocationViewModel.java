package com.example.and3hw2.ui.fragments.location;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.and3hw2.app.App;
import com.example.and3hw2.model.Location;
import com.example.and3hw2.model.RickAndMortyResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LocationViewModel extends ViewModel {

    MutableLiveData<RickAndMortyResponse<Location>> fetchLocations(){
        MutableLiveData<RickAndMortyResponse<Location>> data = new MutableLiveData<>();
        App.locationApiService.fetchLocations().enqueue(new Callback<RickAndMortyResponse<Location>>() {
            @Override
            public void onResponse(Call<RickAndMortyResponse<Location>> call, Response<RickAndMortyResponse<Location>> response) {
                data.postValue(response.body());
            }

            @Override
            public void onFailure(Call<RickAndMortyResponse<Location>> call, Throwable t) {
                data.postValue(null);
            }
        });
        return data;
    }
}
