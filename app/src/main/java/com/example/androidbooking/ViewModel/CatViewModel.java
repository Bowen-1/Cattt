package com.example.androidbooking.ViewModel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.androidbooking.Model.Cat;
import com.example.androidbooking.Networking.CatRepository;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class CatViewModel extends ViewModel {
    private DatabaseReference databaseReference;
    public CatViewModel(){
      databaseReference  = FirebaseDatabase.getInstance().getReference();

    }

    public List<Cat>getAllcats(){
        List<Cat>cats = new ArrayList<>();
        databaseReference.child("Cats").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds:snapshot.getChildren()){
                    cats.add(ds.getValue(Cat.class));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                System.out.println("error");

            }
        });
        return cats;
    }



//    public void searchCat(){
//        databaseReference.child("Hodel").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                for(DataSnapshot sp : snapshot.getChildren()){
//                    Cat c = sp.getValue(Cat.class);
//                    Log.d("123",c.toString());
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//    }
//    CatRepository catRepository;
//
//    public CatViewModel(){
//        catRepository = CatRepository.getInstance();
//
//    }
//
//    public MutableLiveData<Cat>getCat(){
//        return catRepository.getCatMutableLiveData();
//    }
//
//    public void getCatfromapi(String s){
//        catRepository.getCatfromapi(s);
//    }
//


}