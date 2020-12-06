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
import com.example.androidbooking.ViewModel.CatViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;

public class CatFragment extends Fragment {

    private CatViewModel catViewModel;
//    private EditText editText;
//    private ImageView imageView;
//    private Button button;

//

    RecyclerView.Adapter mCatAdapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        catViewModel =
                new ViewModelProvider(this).get(CatViewModel.class);
        View root = inflater.inflate(R.layout.fragment_cat, container, false);
        RecyclerView recyclerView = (RecyclerView)root.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//

//
//        ArrayList<Cat>cats = new ArrayList<>();
//        cats.add(new Cat("asf","sdgsfg","wasf"));
//        cats.add(new Cat("asf","sdgsfg","wasf"));
//        cats.add(new Cat("asf","sdgsfg","wasf"));
//        cats.add(new Cat("asf","sdgsfg","wasf"));
//        cats.add(new Cat("asf","sdgsfg","wasf"));
//        cats.add(new Cat("asf","sdgsfg","wasf"));
//        mCatAdapter  = new CatAdapter(cats);
//
        mCatAdapter = new CatAdapter(getallCats());
        recyclerView.setAdapter(mCatAdapter);







        return root;
    }




//        editText = editText.findViewById(R.id.editText);
//        imageView = imageView.findViewById(R.id.imageView);

//        catViewModel = new ViewModelProvider(this).get(CatViewModel.class);
//        search();

//        mCatList = mCatList.findViewById(R.id.recyclerview);
//        mCatList.hasFixedSize();
//        mCatList.setLayoutManager(new LinearLayoutManager(this));
//        ArrayList<Cat> cats = new ArrayList<>();
//        cats.add(new Cat("cat1",R.drawable.catcartoon));
//        cats.add(new Cat("cat2",R.drawable.catcartoon));
//
//        mCatAdapter = new CatAdapter(cats);
//        mCatList.setAdapter(mCatAdapter);
//        catViewModel.getCat().observe(this, new Observer<Cat>() {
//            @Override
//
//            public void onChanged(Cat cat) {
//                Glide.with(CatFragment.this).load(cat.getImageUrl()).into(imageView);
//            }
//        });
//        mCatList = mCatList.findViewById(R.id.recyclerview);
//        mCatList.hasFixedSize();
//        mCatList.setLayoutManager(new LinearLayoutManager(this));

//    public void search(){
//        catViewModel.searchCat();
//    }

    public List<Cat> getallCats(){
       return catViewModel.getAllcats();
    }


//    public void updateCat(View view){
//        catViewModel.updateCat(editText.getText().toString());
//    }

}