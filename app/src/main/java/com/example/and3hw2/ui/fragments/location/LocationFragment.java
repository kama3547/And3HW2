package com.example.and3hw2.ui.fragments.location;

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
import com.example.and3hw2.databinding.FragmentLocationBinding;
import com.example.and3hw2.ui.adapters.CharacterAdapter;
import com.example.and3hw2.ui.adapters.LocationAdapter;


public class LocationFragment extends BaseFragment<LocationViewModel, FragmentLocationBinding> {

    private LocationAdapter locationAdapter = new LocationAdapter();
    private LocationViewModel viewModel;
    private FragmentLocationBinding binding;
    private int visibleItemCount;
    private int totalItemCount;
    private int pastVisiblesItems;
    public LinearLayoutManager linearLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLocationBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    protected void initialize() {
        super.initialize();
        setupLocationRecycler();
        viewModel = new ViewModelProvider(requireActivity()).get(LocationViewModel.class);
    }

    private void setupLocationRecycler() {
        linearLayoutManager = new LinearLayoutManager(getContext());
        binding.recyclerLocation.setLayoutManager(linearLayoutManager);
        binding.recyclerLocation.setAdapter(locationAdapter);
    }

    @Override
    protected void setUpRequests() {
        super.setUpRequests();
        if (!connectInternet()) {
            locationAdapter.submitList(viewModel.getLocations());
        }
        binding.recyclerLocation.addOnScrollListener(new RecyclerView.OnScrollListener() {
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

    private boolean connectInternet() {
        if (isConnectInternet()) {
            viewModel.fetchLocations().observe(getViewLifecycleOwner(), locationRickAndMortyResponse -> {
                locationAdapter.submitList(locationRickAndMortyResponse.getResults());
            });
            return true;
        } else {
            return false;
        }
    }
}