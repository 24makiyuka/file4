package com.example.recycleview;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleview.databinding.ItemStudyBinding;

import java.util.ArrayList;

public class StudeAdapter extends RecyclerView.Adapter<StudeAdapter.ViewHolder>{
    private final ArrayList<String> data;

    public StudeAdapter(ArrayList<String> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemStudyBinding binding = ItemStudyBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String hello = data.get(position);
        holder.binding.textView.setText(hello);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemStudyBinding binding;

        public ViewHolder(ItemStudyBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
