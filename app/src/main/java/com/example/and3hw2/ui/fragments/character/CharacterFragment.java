package com.example.and3hw2.ui.fragments.character;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.and3hw2.R;
import com.example.and3hw2.databinding.FragmentCharacterBinding;
import com.example.and3hw2.model.Character;
import com.example.and3hw2.model.RickAndMortyResponse;
import com.example.and3hw2.ui.adapters.CharacterAdapter;


public class CharacterFragment extends Fragment {

    private FragmentCharacterBinding binding;
    private CharacterAdapter characterAdapter = new CharacterAdapter();
    private CharacterViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentCharacterBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel =
                new ViewModelProvider(requireActivity()).get(CharacterViewModel.class);
        initialize();
        setupRequests();
    }

    private void setupRequests() {
        viewModel.fetchCharacters().observe(getViewLifecycleOwner(), characterRickAndMortyResponse ->
                characterAdapter.addList(characterRickAndMortyResponse.getResults()));
    }

    private void initialize() {
        setupCharacterRecycler();
    }

    private void setupCharacterRecycler() {
        binding.recyclerCharacter.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.recyclerCharacter.setAdapter(characterAdapter);

        characterAdapter.setOnItemClickListener(position -> {
            Navigation.findNavController(requireActivity(), R.id.nav_host_fragment)
                    .navigate(CharacterFragmentDirections.actionCharacterFragmentToCharacterDetailFragment().setPosition(position));
        });
    }
}