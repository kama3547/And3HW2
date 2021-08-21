package com.example.and3hw2.ui.fragments.character;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.and3hw2.app.App;
import com.example.and3hw2.model.Character;
import com.example.and3hw2.model.RickAndMortyResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CharacterViewModel extends ViewModel {

    MutableLiveData<RickAndMortyResponse<Character>> fetchCharacters() {
        MutableLiveData<RickAndMortyResponse<Character>> data = new MutableLiveData<>();
        App.characterApiService.fetchCharacters().enqueue(new Callback<RickAndMortyResponse<Character>>() {
            @Override
            public void onResponse(Call<RickAndMortyResponse<Character>> call, Response<RickAndMortyResponse<Character>> response) {
                data.postValue(response.body());
            }

            @Override
            public void onFailure(Call<RickAndMortyResponse<Character>> call, Throwable t) {
                data.postValue(null);
            }
        });
        return data;
    }

    MutableLiveData<Character> dataId = new MutableLiveData<>();

    public MutableLiveData<Character> fetchData(int id) {
        App.characterApiService.fetCharactersId(id).enqueue(new Callback<Character>() {
            @Override
            public void onResponse(Call<Character> call, Response<Character> response) {
                dataId.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Character> call, Throwable t) {
                dataId.setValue(null);
            }
        });
        return dataId;
    }
}
