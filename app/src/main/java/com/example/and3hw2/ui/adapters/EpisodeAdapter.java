package com.example.and3hw2.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.and3hw2.databinding.ItemCharacterBinding;
import com.example.and3hw2.databinding.ItemEpisodesBinding;
import com.example.and3hw2.model.Character;
import com.example.and3hw2.model.Episode;

import java.util.ArrayList;
import java.util.List;

public class EpisodeAdapter extends RecyclerView.Adapter<EpisodeAdapter.EpisodeViewHolder> {

    private ItemEpisodesBinding binding;
    private List<Episode> list = new ArrayList<>();

    @NonNull
    @Override
    public EpisodeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemEpisodesBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new  EpisodeViewHolder(binding.getRoot()) ;
    }

    @Override
    public void onBindViewHolder(@NonNull EpisodeViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public void addList(List<Episode> list){
        this.list = list;
        notifyDataSetChanged();
    }

    public class EpisodeViewHolder extends RecyclerView.ViewHolder {

        private void onBind(Episode item){
            binding.itemEpisode.setText(item.getName());
            binding.itemEpisode2.setText(item.getAir_date());
            binding.itemEpisode3.setText(item.getCreated());
            binding.itemEpisode4.setText(item.getEpisode());
        }

        public EpisodeViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
