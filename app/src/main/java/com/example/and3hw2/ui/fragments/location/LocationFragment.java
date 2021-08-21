package com.example.and3hw2.ui.fragments.location;

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
import com.example.and3hw2.databinding.FragmentLocationBinding;
import com.example.and3hw2.ui.adapters.LocationAdapter;


public class LocationFragment extends Fragment {

   private LocationAdapter locationAdapter = new LocationAdapter();
   private LocationViewModel viewModel;
   private FragmentLocationBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLocationBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(LocationViewModel.class);
        initalize();
        setupRequests();
    }

    private void setupRequests() {
        viewModel.fetchLocations().observe(getViewLifecycleOwner(),locationRickAndMortyResponse -> {
            locationAdapter.addList(locationRickAndMortyResponse.getResults());
        });
    }

    private void initalize() {
        setupLocationRecycler();
    }

    private void setupLocationRecycler() {
        binding.recyclerLocation.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.recyclerLocation.setAdapter(locationAdapter);
    }
}