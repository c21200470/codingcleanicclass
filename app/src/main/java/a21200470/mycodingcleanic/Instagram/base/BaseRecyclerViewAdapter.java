package com.inflearn.lightinstagram.ui.base;

import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public abstract class BaseRecyclerViewAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    protected List<Object> items = new ArrayList<>();

    public void addAll(List<?> items) {
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    protected abstract BaseViewHolder getViewHolder(int viewType, ViewGroup parent);

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return getViewHolder(viewType, parent);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}