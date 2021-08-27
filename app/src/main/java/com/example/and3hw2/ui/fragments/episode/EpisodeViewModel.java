package com.example.and3hw2.ui.fragments.episode;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.and3hw2.base.BaseViewModel;
import com.example.and3hw2.data.repositories.EpisodeRepository;
import com.example.and3hw2.model.Episode;
import com.example.and3hw2.model.RickAndMortyResponse;

import java.util.List;

public class EpisodeViewModel extends BaseViewModel {

    public int page = 1;
    private final EpisodeRepository repository = new EpisodeRepository();

    MutableLiveData<RickAndMortyResponse<Episode>> fetchEpisodes(){
     return repository.fetchEpisodes(page);
    }

    List<Episode> getEpisodes() {
        return repository.getEpisode();
    }
}

