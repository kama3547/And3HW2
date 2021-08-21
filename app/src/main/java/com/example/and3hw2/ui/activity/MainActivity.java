package com.example.and3hw2.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.widget.Toast;

import com.example.and3hw2.R;
import com.example.and3hw2.databinding.ActivityMainBinding;
import com.example.and3hw2.model.RickAndMortyResponse;

public class MainActivity extends AppCompatActivity {


     private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setupNavigation();
    }

    private void setupNavigation() {
        NavHostFragment navHostFragment =
                (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        NavController navController = navHostFragment.getNavController();

        AppBarConfiguration appBarConfiguration =
                new AppBarConfiguration.Builder(
                        R.id.characterFragment,
                        R.id.episodeFragment,
                        R.id.locationFragment,
                        R.id.characterDetailFragment
                ).build();

        NavigationUI.setupActionBarWithNavController(this, navController,appBarConfiguration);
        NavigationUI.setupWithNavController(binding.bottomNav,navController);
    }
}