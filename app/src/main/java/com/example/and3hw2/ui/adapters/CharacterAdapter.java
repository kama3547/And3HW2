package com.example.and3hw2.ui.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.and3hw2.R;
import com.example.and3hw2.databinding.ItemCharacterBinding;
import com.example.and3hw2.model.Character;

import java.util.ArrayList;
import java.util.List;

public class CharacterAdapter extends ListAdapter<Character,CharacterAdapter.CharacterViewHolder> {

    private OnItemClick listener;
    public static class CharacterDiffUtil extends DiffUtil.ItemCallback<Character>{

        @Override
        public boolean areItemsTheSame(@NonNull Character oldItem, @NonNull Character newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(@NonNull Character oldItem, @NonNull Character newItem) {
            return oldItem == newItem;
        }
    }
    public CharacterAdapter() {
        super(new CharacterDiffUtil());
    }

    @NonNull
    @Override
    public CharacterAdapter.CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CharacterAdapter.CharacterViewHolder(ItemCharacterBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterAdapter.CharacterViewHolder holder, int position) {
        holder.onBind(getItem(position));
    }

    class CharacterViewHolder extends RecyclerView.ViewHolder {
        ItemCharacterBinding binding;

        public CharacterViewHolder(ItemCharacterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        private void onBind(Character item) {
            Glide
                    .with(binding.imageItemCharacter)
                    .load(item.getImage())
                    .into(binding.imageItemCharacter);
            binding.textItemCharacter.setText(item.getName());
            binding.getRoot().setOnClickListener(v -> {
                listener.onItemClick(item.getId());

            });
        }
    }

    public interface OnItemClick {
        void onItemClick(int position);
    }


    public void setOnItemClickListener(OnItemClick listener) {
        this.listener = listener;
    }
}
