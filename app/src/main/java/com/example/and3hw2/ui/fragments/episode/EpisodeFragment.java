package com.example.and3hw2.ui.fragments.episode;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.and3hw2.R;
import com.example.and3hw2.databinding.FragmentEpisodeBinding;
import com.example.and3hw2.ui.adapters.EpisodeAdapter;


public class EpisodeFragment extends Fragment {

    private FragmentEpisodeBinding binding;
    private EpisodeViewModel viewModel;
    private EpisodeAdapter episodeAdapter = new EpisodeAdapter();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentEpisodeBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel =
                new ViewModelProvider(requireActivity()).get(EpisodeViewModel.class);
        initialize();
        setupRequests();
    }

    private void setupRequests() {
        viewModel.fetchEpisodes().observe(getViewLifecycleOwner(),episodeRickAndMortyResponse -> {
            episodeAdapter.addList(episodeRickAndMortyResponse.getResults());
        });
    }

    private void initialize() {
        setupEpisodeRecycler();
    }

    private void setupEpisodeRecycler() {
        binding.recyclerEpisode.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.recyclerEpisode.setAdapter(episodeAdapter);
    }
}