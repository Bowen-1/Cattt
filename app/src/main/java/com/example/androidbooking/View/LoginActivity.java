package com.example.androidbooking.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.androidbooking.Model.Cat;
import com.example.androidbooking.R;
import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
    private static final int RC_SIGN_IN = 90;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        checkIfSignedIn();
//        testDatabase();
    }

    private void checkIfSignedIn() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null)
            goToMainActivity();
    }

    private void goToMainActivity() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    public void signIn(View v) {
        List<AuthUI.IdpConfig> providers = Arrays.asList(
                new AuthUI.IdpConfig.EmailBuilder().build(),
                new AuthUI.IdpConfig.GoogleBuilder().build());

        Intent signInIntent = AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(providers)
                .build();

        startActivityForResult(signInIntent, RC_SIGN_IN);
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            handleSignInRequest(resultCode);
        }
    }

    private void handleSignInRequest(int resultCode) {
        if (resultCode == RESULT_OK)
            goToMainActivity();
        else
            Toast.makeText(this, "SIGN IN CANCELLED", Toast.LENGTH_SHORT).show();
    }

//    public void testDatabase(){
//        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
//        Cat Abyssinian = new Cat("Abyssinian","Active, Energetic, Independent, Intelligent, Gentle","https://en.wikipedia.org/wiki/Abyssinian_(cat)");
//        Cat Aegean = new Cat("Aegean","Affectionate, Social, Intelligent, Playful, Active","https://en.wikipedia.org/wiki/Aegean_cat");
//        Cat AmericanBobtail = new Cat("AmericanBobtail","Intelligent, Interactive, Lively, Playful, Sensitive","https://en.wikipedia.org/wiki/American_Bobtail");
//        Cat AmericanCurl = new Cat("AmericanCurl","Affectionate, Curious, Intelligent, Interactive, Lively, Playful, Social","https://en.wikipedia.org/wiki/American_Curl");
//        Cat AmericanShorthair = new Cat("AmericanShorthair","Active, Curious, Easy Going, Playful, Calm","https://en.wikipedia.org/wiki/American_Shorthair");
//        Cat AmericanWirehair = new Cat("American Wirehair","Affectionate, Curious, Gentle, Intelligent, Interactive, Lively, Loyal, Playful, Sensible, Social","https://en.wikipedia.org/wiki/American_Wirehair");
//        Cat Alley= new Cat("Alley cat","Affectionate, Agile, Curious, Independent, Playful, Loyal","https://en.wikipedia.org/wiki/Arabian_Mau");
//        Cat SpottedMist = new Cat("Spotted Mist","Lively, Social, Fun-loving, Relaxed, Affectionate","https://en.wikipedia.org/wiki/Australian_Mist");
//        Cat LonghairedSiamese = new Cat("Long-haired Siamese","Affectionate, Intelligent, Playful","http://www.vetstreet.com/cats/balinese");
//        Cat Bambino = new Cat("Bambino","Affectionate, Lively, Friendly, Intelligent","https://en.wikipedia.org/wiki/Bambino_cat");
//        Cat Bengal = new Cat("Bengal","Alert, Agile, Energetic, Demanding, Intelligent","https://en.wikipedia.org/wiki/Bengal_(cat)");
//        Cat Birman = new Cat("Birman","Affectionate, Active, Gentle, Social","https://en.wikipedia.org/wiki/Birman");
//        Cat SmallblackPanther = new Cat("Small black Panther","Affectionate, Dependent, Gentle, Intelligent, Playful","https://en.wikipedia.org/wiki/Bombay_(cat)");
//        Cat BritishLonghair = new Cat("British Longhair","Affectionate, Easy Going, Independent, Intelligent, Loyal, Social","https://en.wikipedia.org/wiki/British_Longhair");
//        Cat BritishShorthair = new Cat("British Shorthair","Affectionate, Easy Going, Gentle, Loyal, Patient, calm","https://en.wikipedia.org/wiki/British_Shorthair");
//        Cat Burmese = new Cat("Burmese","Curious, Intelligent, Gentle, Social, Interactive, Playful, Lively","https://en.wikipedia.org/wiki/Burmese_(cat)");
//        Cat Chantilly = new Cat("Chantilly","Affectionate, Demanding, Interactive, Loyal","https://en.wikipedia.org/wiki/Chantilly-Tiffany");
//        Cat Chartreux = new Cat("Chartreux","Affectionate, Loyal, Intelligent, Social, Lively, Playful","https://en.wikipedia.org/wiki/Chartreux");
//        Cat Cheetoh = new Cat("Cheetoh","Affectionate, Gentle, Intelligent, Social","https://en.wikipedia.org/wiki/Bengal_cat#Cheetoh");
//        Cat Cymric = new Cat("Cymric","Gentle, Loyal, Intelligent, Playful","https://en.wikipedia.org/wiki/Cymric_(cat)");
//        Cat Donskoy = new Cat("Donskoy","Playful, affectionate, loyal, social","https://en.wikipedia.org/wiki/Donskoy_(cat)");
//        Cat DragonLi = new Cat("Dragon Li","Intelligent, Friendly, Gentle, Loving, Loyal","http://www.vetstreet.com/cats/li-hua");
//        Cat Pharaoh = new Cat("Pharaoh","Agile, Dependent, Gentle, Intelligent, Lively, Loyal, Playful","https://en.wikipedia.org/wiki/Egyptian_Mau");
//        Cat EuropeanBurmese = new Cat("European Burmese","Sweet, Affectionate, Loyal","https://en.wikipedia.org/wiki/Burmese_cat");
//        Cat Exotic = new Cat("Exotic","Affectionate, Sweet, Loyal, Quiet, Peaceful","https://en.wikipedia.org/wiki/Exotic_Shorthair");
//        Cat HavanaBrown = new Cat("Havana Brown","Affectionate, Curious, Demanding, Friendly, Intelligent, Playful","https://en.wikipedia.org/wiki/Havana_Brown");
//        Cat HimalayanPersian  = new Cat("Himalayan Persian","Dependent, Gentle, Intelligent, Quiet, Social","https://en.wikipedia.org/wiki/Himalayan_(cat)");
//        Cat JapaneseBobtail = new Cat("Japanese Bobtail","Active, Agile, Clever, Easy Going, Intelligent, Lively, Loyal, Playful, Social","https://en.wikipedia.org/wiki/Japanese_Bobtail");
//        Cat Javanese = new Cat("Javanese","Active, Devoted, Intelligent, Playful","https://en.wikipedia.org/wiki/Javanese_cat");
//        Cat Korat = new Cat("Korat","Active, Loyal, highly intelligent, Expressive, Trainable","https://en.wikipedia.org/wiki/Korat");
//        Cat LaPerms = new Cat("LaPerms","Affectionate, Friendly, Gentle, Intelligent, Playful, Quiet","https://en.wikipedia.org/wiki/LaPerm");
//        Cat Malayans = new Cat("Malayans","Affectionate, Interactive, Playful, Social","https://en.wikipedia.org/wiki/Asian_cat");
//        List<Cat>cats = new ArrayList<>();
//        cats.add(Abyssinian);
//        cats.add(Aegean);
//        cats.add(AmericanBobtail);
//        cats.add(AmericanCurl);
//        cats.add(AmericanShorthair);
//        cats.add(AmericanWirehair);
//        cats.add(Alley);
//        cats.add(SpottedMist);
//        cats.add(LonghairedSiamese);
//        cats.add(Bambino);
//        cats.add(Bengal);
//        cats.add(Birman);
//        cats.add(SmallblackPanther);
//        cats.add(BritishLonghair);
//        cats.add(BritishShorthair);
//        cats.add(Burmese);
//        cats.add(Chantilly);
//        cats.add(Chartreux);
//        cats.add(Cheetoh);
//        cats.add(Cymric);
//        cats.add(Donskoy);
//        cats.add(DragonLi);
//        cats.add(Pharaoh);
//        cats.add(EuropeanBurmese);
//        cats.add(Exotic);
//        cats.add(HavanaBrown);
//        cats.add(HimalayanPersian);
//        cats.add(Javanese);
//        cats.add(JapaneseBobtail);
//        cats.add(Korat);
//        cats.add(LaPerms);
//        cats.add(Malayans);
//
//
//        databaseReference.child("Cats").setValue(cats);
//
//
//    }




}