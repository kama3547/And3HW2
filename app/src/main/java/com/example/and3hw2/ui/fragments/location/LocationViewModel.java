package com.example.and3hw2.ui.fragments.location;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.and3hw2.app.App;
import com.example.and3hw2.base.BaseViewModel;
import com.example.and3hw2.data.repositories.EpisodeRepository;
import com.example.and3hw2.data.repositories.LocationRepository;
import com.example.and3hw2.model.Location;
import com.example.and3hw2.model.RickAndMortyResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LocationViewModel extends BaseViewModel {

    public int page = 1;
    private final LocationRepository repository = new LocationRepository();

    MutableLiveData<RickAndMortyResponse<Location>> fetchLocations() {
     return repository.fetchLocations(page);
    }
    List<Location> getLocations(){
        return repository.getLocation();
    }
}
