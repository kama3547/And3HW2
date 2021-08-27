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

    private List<Episode> list = new ArrayList<>();

    @NonNull
    @Override
    public EpisodeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new EpisodeViewHolder(ItemEpisodesBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
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
        this.list.addAll(list);
        notifyDataSetChanged();
    }

     class EpisodeViewHolder extends RecyclerView.ViewHolder {
        ItemEpisodesBinding binding;

         public EpisodeViewHolder( ItemEpisodesBinding binding) {
             super(binding.getRoot());
             this.binding = binding;
         }
        private void onBind(Episode item){
            binding.itemEpisode.setText(item.getName());
            binding.itemEpisode2.setText(item.getAir_date());
            binding.itemEpisode3.setText(item.getCreated());
            binding.itemEpisode4.setText(item.getEpisode());
        }
    }
}
