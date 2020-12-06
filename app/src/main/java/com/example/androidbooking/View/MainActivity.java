package com.example.androidbooking.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidbooking.Model.Cat;
import com.example.androidbooking.R;
import com.example.androidbooking.ViewModel.CatViewModel;
import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private CatViewModel catViewModel;
    private TextView textuser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        textuser = findViewById(R.id.textUser);
//        button = findViewById(R.id.like);
//        name = findViewById(R.id.name);
        checkIfSignedIn();
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_cat, R.id.navigation_favourite, R.id.navigation_account)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

//        editTextTypeName = findViewById(R.id.editTextTypeName);
//        editTextIntell = findViewById(R.id.editTextintell);

//        catViewModel.getCat().observe(this, new Observer<Cat>() {
//            @Override
//            public void onChanged(Cat cat) {
//
//
//            }
//        });
//        editText = findViewById(R.id.editText);
//        imageView = findViewById(R.id.imageView);
//        catViewModel.getCat().observe(this, new Observer<Cat>() {
//            @Override
//            public void onChanged(Cat cat) {
//                Glide.with(MainActivity.this).load(cat.getImageUrl()).into(imageView);
//            }
//        });

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.



//        mCatList = findViewById(R.id.recyclerview);
//        mCatList.hasFixedSize();
//        mCatList.setLayoutManager(new LinearLayoutManager(this));
//        ArrayList<Cat>cats = new ArrayList<>();
//        cats.add(new Cat("cat1"));
//        cats.add(new Cat("cat2"));
//
//        mCatAdapter = new CatAdapter(cats);
//        mCatList.setAdapter(mCatAdapter);

    }
//    public void getfavorite(View view){
//        String favoritename = name.getText().toString();
//        Toast.makeText(this, "Welcome " + favoritename, Toast.LENGTH_SHORT).show();
//    }


    private void checkIfSignedIn() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();


        if (user != null)
            Toast.makeText(this, "Welcome " + user.getDisplayName(), Toast.LENGTH_SHORT).show();

        else
            startLoginActivity();
    }

    private void startLoginActivity() {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }
    public void signOut(View v) {
        AuthUI.getInstance()
                .signOut(this)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    public void onComplete(@NonNull Task<Void> task) {
                        startLoginActivity();
                    }
                });
    }
//    public void showUsernam(){
//
//    }
//
//        public void updateCat(View view){
//        catViewModel.getCatfromapi(editTextTypeName.getText().toString());
//    }



}


