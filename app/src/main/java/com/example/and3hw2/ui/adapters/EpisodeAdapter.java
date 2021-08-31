package com.example.and3hw2.ui.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.and3hw2.databinding.ItemCharacterBinding;
import com.example.and3hw2.databinding.ItemEpisodesBinding;
import com.example.and3hw2.model.Character;
import com.example.and3hw2.model.Episode;

import java.util.ArrayList;
import java.util.List;

public class EpisodeAdapter extends ListAdapter<Episode, EpisodeAdapter.EpisodeViewHolder> {

    public static class EpisodeDiffUtil extends DiffUtil.ItemCallback<Episode> {

        @Override
        public boolean areItemsTheSame(@NonNull Episode oldItem, @NonNull Episode newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(@NonNull Episode oldItem, @NonNull Episode newItem) {
            return oldItem == newItem;
        }
    }

    public EpisodeAdapter() {
        super(new EpisodeDiffUtil());
    }

    @NonNull
    @Override
    public EpisodeAdapter.EpisodeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new EpisodeViewHolder(ItemEpisodesBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull EpisodeAdapter.EpisodeViewHolder holder, int position) {
        holder.onBind(getItem(position));
    }

    class EpisodeViewHolder extends RecyclerView.ViewHolder {
        ItemEpisodesBinding binding;

        public EpisodeViewHolder(ItemEpisodesBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        private void onBind(Episode item) {
            binding.itemEpisode.setText(item.getName());
            binding.itemEpisode2.setText(item.getAir_date());
            binding.itemEpisode3.setText(item.getCreated());
            binding.itemEpisode4.setText(item.getEpisode());
        }
    }
}
