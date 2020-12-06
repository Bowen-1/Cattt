package com.example.androidbooking.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.androidbooking.Model.Cat;
import com.example.androidbooking.View.FavouriteAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FavouriteViewModel extends ViewModel {
    private DatabaseReference databaseReference;
    public FavouriteViewModel(){
        databaseReference  = FirebaseDatabase.getInstance().getReference();
    }
}