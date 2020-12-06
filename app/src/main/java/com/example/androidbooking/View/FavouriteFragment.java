package com.example.androidbooking.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidbooking.Model.Cat;
import com.example.androidbooking.R;
import com.example.androidbooking.ViewModel.FavouriteViewModel;

import java.util.ArrayList;

public class FavouriteFragment extends Fragment {

    private FavouriteViewModel favouriteViewModel;
    RecyclerView.Adapter fCatAdaper;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        favouriteViewModel =
                new ViewModelProvider(this).get(FavouriteViewModel.class);
        View root = inflater.inflate(R.layout.fragment_favourite, container, false);
        RecyclerView recyclerView=(RecyclerView)root.findViewById(R.id.favourite);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        ArrayList<Cat>cats = new ArrayList<>();
        cats.add(new Cat("sdf"));
        cats.add(new Cat("sdgsfg"));
        cats.add(new Cat("sdgsfg"));
        cats.add(new Cat("sdgsfg"));
        fCatAdaper = new FavouriteAdapter(cats);
        recyclerView.setAdapter(fCatAdaper);




        return root;
    }

}