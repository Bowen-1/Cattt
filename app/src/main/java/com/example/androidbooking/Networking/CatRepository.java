package com.example.androidbooking.Networking;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.androidbooking.Model.Cat;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static okhttp3.internal.Internal.instance;

public class CatRepository {
//    private static CatRepository intance;
//    private  MutableLiveData<Cat> catMutableLiveData;
//    private static CatApi catApi;
//    private CatRepository(){
//        catMutableLiveData = new MutableLiveData<>();
//    }
//
//    public static synchronized CatRepository getInstance() {
//        if (instance == null) {
//            intance = new CatRepository();
//            catApi = ServerGenerator.getCatApi();
//        }
//        return intance;
//    }
//
//    public MutableLiveData<Cat> getCatMutableLiveData() {
//        return catMutableLiveData;
//    }
//
//    public void getCatfromapi(String CatName){
//        Call<Cat> call = catApi.getCat(CatName);
//        call.enqueue(new Callback<Cat>() {
//            @Override
//            public void onResponse(Call<Cat> call, Response<Cat> response) {
//                catMutableLiveData.setValue(response.body());
//            }
//
//            @Override
//            public void onFailure(Call<Cat> call, Throwable t) {
//                System.out.println("internet error");
//
//            }
//        });
//
//    }

//
//    public void updateCat(String catName) {
//        CatApi catApi = ServerGenerator.getCatApi();
//        Call<CatRespose> call = catApi.getCat(catName);
//        call.enqueue(new Callback<CatRespose>() {
//            @Override
//            public void onResponse(Call<CatRespose> call, Response<CatRespose> response) {
//                if (response.code() == 200){
//                    catMutableLiveData.setValue(response.body().getCat());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<CatRespose> call, Throwable t) {
//                Log.i("Retrofit", "Something went wrong :(");
//
//            }
//        });
//
//
//    }


}