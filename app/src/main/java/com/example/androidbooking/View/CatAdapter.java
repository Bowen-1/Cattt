package com.example.androidbooking.View;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidbooking.Model.Cat;
import com.example.androidbooking.R;

import java.util.ArrayList;
import java.util.List;

public class CatAdapter extends RecyclerView.Adapter<CatAdapter.ViewHolder> {
    private List<Cat> mcats;
    public CatAdapter(List<Cat> cats) {
        this.mcats = cats;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.cat_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(mcats.get(position).getName());
        holder.temperament.setText(mcats.get(position).getTemperament());
        holder.wikipedia_url.setText(mcats.get(position).getWikipedia_url());

    }

    public int getItemCount() {
        return mcats.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView temperament;
        TextView wikipedia_url;
        ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            temperament = itemView.findViewById(R.id.temperament);
            wikipedia_url = itemView.findViewById(R.id.wikipedia_url);


        }


    }
}
