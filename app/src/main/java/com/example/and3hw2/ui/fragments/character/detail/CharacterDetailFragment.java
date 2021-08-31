package com.example.and3hw2.ui.fragments.character.detail;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.and3hw2.base.BaseFragment;
import com.example.and3hw2.data.repositories.CharacterRepository;
import com.example.and3hw2.databinding.FragmentCharacterDetailBinding;
import com.example.and3hw2.ui.adapters.CharacterAdapter;
import com.example.and3hw2.ui.fragments.character.CharacterViewModel;


public class CharacterDetailFragment extends BaseFragment<CharacterViewModel, FragmentCharacterDetailBinding> {

    private FragmentCharacterDetailBinding binding;
    private CharacterViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentCharacterDetailBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    protected void initialize() {
        super.initialize();
        viewModel = new ViewModelProvider(requireActivity()).get(CharacterViewModel.class);
    }

    @Override
    protected void setUpRequests() {
        super.setUpRequests();
        viewModel.fetchData(
                CharacterDetailFragmentArgs.fromBundle(getArguments()).getPosition()
        ).observe(getViewLifecycleOwner(), character -> {
            Glide.with(binding.imageItemCharacterD)
                    .load(character.getImage())
                    .into(binding.imageItemCharacterD);
            binding.textItemCharacter1.setText(character.getName());
            binding.textItemCharacter2.setText(character.getStatus());
            binding.textItemCharacter3.setText(character.getSpecies());
            binding.textItemCharacter4.setText(character.getGender());
            binding.textItemCharacter5.setText(character.getCreated());
        });
    }
}

