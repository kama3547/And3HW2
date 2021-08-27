package com.example.and3hw2.ui.fragments.character;

import static androidx.core.content.ContextCompat.getSystemService;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Dao;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.and3hw2.R;
import com.example.and3hw2.app.App;
import com.example.and3hw2.base.BaseFragment;
import com.example.and3hw2.data.repositories.CharacterRepository;
import com.example.and3hw2.databinding.FragmentCharacterBinding;
import com.example.and3hw2.model.Character;
import com.example.and3hw2.model.RickAndMortyResponse;
import com.example.and3hw2.ui.adapters.CharacterAdapter;


public class CharacterFragment extends BaseFragment<CharacterViewModel, FragmentCharacterBinding> {

    private FragmentCharacterBinding binding;
    private CharacterAdapter characterAdapter = new CharacterAdapter();
    private CharacterViewModel viewModel;
    private LinearLayoutManager linearLayoutManager;
    private int visibleItemCount;
    private int totalItemCount;
    private int pastVisiblesItems;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCharacterBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        isConnectInternet();
    }

    @Override
    protected void isConnectInternet() {
        super.isConnectInternet();
        ConnectivityManager connectivityManager = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            setUpRequests();
        } else {
            characterAdapter.addList(viewModel.getCharacters());
        }
    }

    @Override
    protected void initialize() {
        super.initialize();
        viewModel = new ViewModelProvider(requireActivity()).get(CharacterViewModel.class);
        setupCharacterRecycler();
    }

    private void setupCharacterRecycler() {
        linearLayoutManager = new LinearLayoutManager(getContext());
        binding.recyclerCharacter.setLayoutManager(linearLayoutManager);
        binding.recyclerCharacter.setAdapter(characterAdapter);

        characterAdapter.setOnItemClickListener(position -> {
            Navigation.findNavController(requireActivity(), R.id.nav_host_fragment)
                    .navigate(CharacterFragmentDirections.actionCharacterFragmentToCharacterDetailFragment().setPosition(position));
        });
    }

    @Override
    protected void setUpRequests() {
        super.setUpRequests();
        viewModel.fetchCharacters().observe(getViewLifecycleOwner(), characterRickAndMortyResponse -> {
            characterAdapter.addList(characterRickAndMortyResponse.getResults());
        });
        binding.recyclerCharacter.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0){
                    visibleItemCount = linearLayoutManager.getChildCount();
                    totalItemCount = linearLayoutManager.getItemCount();
                    pastVisiblesItems = linearLayoutManager.findFirstVisibleItemPosition();
                    if ((visibleItemCount + pastVisiblesItems) >= totalItemCount){
                        viewModel.page++;
                        viewModel.fetchCharacters().observe(getViewLifecycleOwner(),characterRickAndMortyResponse -> {
                            characterAdapter.addList(characterRickAndMortyResponse.getResults());
                        });
                    }
                }
            }
        });
    }
}
