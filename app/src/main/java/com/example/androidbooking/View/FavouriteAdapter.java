package com.example.androidbooking.View;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidbooking.Model.Cat;
import com.example.androidbooking.R;

import java.util.List;


public class FavouriteAdapter extends RecyclerView.Adapter<FavouriteAdapter.ViewHolder> {
    private List<Cat> fcats;

    public  FavouriteAdapter(List<Cat>cats){
        this.fcats = cats;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.favourite_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.favouritename.setText(fcats.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return fcats.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        TextView favouritename;

        ViewHolder(View itemView) {
            super(itemView);
            favouritename = itemView.findViewById(R.id.favourite_name);


        }
    }

}

