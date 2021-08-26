package com.example.and3hw2.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.and3hw2.databinding.ItemEpisodesBinding;
import com.example.and3hw2.databinding.ItemLocationBinding;
import com.example.and3hw2.model.Episode;
import com.example.and3hw2.model.Location;

import java.util.ArrayList;
import java.util.List;

public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.LocationViewHolder> {

    private ItemLocationBinding binding;
    private List<Location> list = new ArrayList<>();

    @NonNull
    @Override
    public LocationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemLocationBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new LocationViewHolder(binding.getRoot()) ;
    }

    @Override
    public void onBindViewHolder(@NonNull LocationViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addList(List<Location> list){
        this.list = list;
        notifyDataSetChanged();
    }

    public class LocationViewHolder extends RecyclerView.ViewHolder {

        private void onBind(Location item){
            binding.itemLocation.setText(item.getName());
            binding.itemLocation2.setText(item.getType());
            binding.itemLocation3.setText(item.getDimension());
            binding.itemLocation4.setText(item.getCreated());
        }

        public LocationViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
