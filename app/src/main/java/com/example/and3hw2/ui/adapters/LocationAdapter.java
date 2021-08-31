package com.example.and3hw2.ui.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.and3hw2.databinding.ItemEpisodesBinding;
import com.example.and3hw2.databinding.ItemLocationBinding;
import com.example.and3hw2.model.Episode;
import com.example.and3hw2.model.Location;

import java.util.ArrayList;
import java.util.List;

public class LocationAdapter extends ListAdapter<Location, LocationAdapter.LocationViewHolder> {


    public static class LocationDiffUtil extends DiffUtil.ItemCallback<Location> {

        @Override
        public boolean areItemsTheSame(@NonNull Location oldItem, @NonNull Location newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(@NonNull Location oldItem, @NonNull Location newItem) {
            return oldItem == newItem;
        }
    }

    public LocationAdapter() {
        super(new LocationDiffUtil());
    }

    @NonNull
    @Override
    public LocationAdapter.LocationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LocationViewHolder(ItemLocationBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LocationAdapter.LocationViewHolder holder, int position) {
        holder.onBind(getItem(position));
    }


    public class LocationViewHolder extends RecyclerView.ViewHolder {
        ItemLocationBinding binding;

        public LocationViewHolder(@NonNull ItemLocationBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        private void onBind(Location item) {
            binding.itemLocation.setText(item.getName());
            binding.itemLocation2.setText(item.getType());
            binding.itemLocation3.setText(item.getDimension());
            binding.itemLocation4.setText(item.getCreated());
        }
    }
}
