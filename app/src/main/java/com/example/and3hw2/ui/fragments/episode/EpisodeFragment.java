package com.example.and3hw2.ui.fragments.episode;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.and3hw2.R;
import com.example.and3hw2.base.BaseFragment;
import com.example.and3hw2.databinding.FragmentEpisodeBinding;
import com.example.and3hw2.ui.adapters.EpisodeAdapter;


public class EpisodeFragment extends BaseFragment<EpisodeViewModel, FragmentEpisodeBinding> {

    private FragmentEpisodeBinding binding;
    private EpisodeViewModel viewModel;
    private EpisodeAdapter episodeAdapter = new EpisodeAdapter();
    private LinearLayoutManager linearLayoutManager;
    private int visibleItemCount;
    private int totalItemCount;
    private int pastVisiblesItems;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentEpisodeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


    @Override
    protected void initialize() {
        super.initialize();
        setupEpisodeRecycler();
        viewModel = new ViewModelProvider(requireActivity()).get(EpisodeViewModel.class);
    }

    @Override
    protected void setUpRequests() {
        super.setUpRequests();
        if (!connectInternet()){
            episodeAdapter.submitList(viewModel.getEpisodes());
        }
        binding.recyclerEpisode.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0) {
                    visibleItemCount = linearLayoutManager.getChildCount();
                    totalItemCount = linearLayoutManager.getItemCount();
                    pastVisiblesItems = linearLayoutManager.findFirstVisibleItemPosition();
                    if ((visibleItemCount + pastVisiblesItems) >= totalItemCount) {
                        viewModel.page++;
                        connectInternet();
                    }
                }
            }
        });
    }

    private void setupEpisodeRecycler() {
        linearLayoutManager = new LinearLayoutManager(getContext());
        binding.recyclerEpisode.setLayoutManager(linearLayoutManager);
        binding.recyclerEpisode.setAdapter(episodeAdapter);
    }
    private boolean connectInternet() {
        if (isConnectInternet()) {
            viewModel.fetchEpisodes().observe(getViewLifecycleOwner(), characterRickAndMortyResponse -> {
                episodeAdapter.submitList(characterRickAndMortyResponse.getResults());
            });
            return true;
        } else {
            return false;
        }
    }
}
