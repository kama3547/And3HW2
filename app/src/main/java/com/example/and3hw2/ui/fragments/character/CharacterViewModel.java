package com.example.and3hw2.ui.fragments.character;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.and3hw2.app.App;
import com.example.and3hw2.data.repositories.CharacterRepository;
import com.example.and3hw2.model.Character;
import com.example.and3hw2.model.RickAndMortyResponse;

import java.util.List;

public class CharacterViewModel extends ViewModel {

    private final CharacterRepository repository = new CharacterRepository();

    MutableLiveData<RickAndMortyResponse<Character>> fetchCharacters() {
        return repository.fetchCharacters();
    }

    public MutableLiveData<Character> fetchData(int id) {
        return repository.fetchData(id);
    }

    List<Character> getCharacters() {
        return repository.getCharacters();
    }
}
