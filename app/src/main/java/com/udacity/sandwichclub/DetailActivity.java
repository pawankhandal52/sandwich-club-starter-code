/*
 
 *Copyright (C) 2018 The Android Sandwich Project made under Udacity Nanodegree Course
 
 */
package com.udacity.sandwichclub;

import android.content.Intent;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;

import android.widget.ImageView;

import android.widget.TextView;

import android.widget.Toast;

import com.squareup.picasso.Picasso;

import com.udacity.sandwichclub.model.Sandwich;

import com.udacity.sandwichclub.utils.JsonUtils;

import org.json.JSONException;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * This the DetailActivity class is used to show the details of sandwich
 */
public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_POSITION = "extra_position";
    private static final int DEFAULT_POSITION = -1;
    
     @BindView(R.id.origin_text_tv) TextView placeOfOrigin;
     @BindView(R.id.also_known_text_tv)TextView alsoKnownAs;
     @BindView(R.id.ingredients_text_tv)TextView ingredients;
     @BindView(R.id.description_text_tv)TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        ImageView sandwichIv = findViewById(R.id.image_iv);

        Intent intent = getIntent();
        if (intent == null) {
            closeOnError();
        }
    
        int position = 0;
        if (intent != null) {
            position = intent.getIntExtra(EXTRA_POSITION, DEFAULT_POSITION);
        }
        if (position == DEFAULT_POSITION) {
            // EXTRA_POSITION not found in intent
            closeOnError();
            return;
        }

        String[] sandwiches = getResources().getStringArray(R.array.sandwich_details);
        String json = sandwiches[position];
        Sandwich sandwich = null;
        try {
            sandwich = JsonUtils.parseSandwichJson(json);
        } catch (JSONException e) {
            e.printStackTrace();
            closeOnError();
        }
        if (sandwich == null) {
            // Sandwich data unavailable
            closeOnError();
            return;
        }

        populateUI(sandwich);
        Picasso.with(this)
                .load(sandwich.getImage()).placeholder(R.mipmap.ic_launcher_round)
                .into(sandwichIv);

        setTitle(sandwich.getMainName());
    }

    private void closeOnError() {
        finish();
        Toast.makeText(this, R.string.detail_error_message, Toast.LENGTH_SHORT).show();
    }

    private void populateUI(Sandwich sandwich) {
        
        if (sandwich.getPlaceOfOrigin().length()!=0){
            placeOfOrigin.setText(sandwich.getPlaceOfOrigin());
        }else{
            placeOfOrigin.setText(R.string.na);
        }
        
        if (sandwich.getDescription().length()!=0){
            description.setText(sandwich.getDescription());
        }else {
            description.setText(R.string.na);
        }
        
        //Set Also know as
        List<String> alsoKnownAsList = sandwich.getAlsoKnownAs();
        if (alsoKnownAsList.size() != 0){
            for (int i = 0; i < alsoKnownAsList.size(); i++) {
                alsoKnownAs.append(alsoKnownAsList.get(i)+",");
            }
        }else{
            alsoKnownAs.setText(R.string.na);
        }
        
        
        //Set Ingredients
        List<String> ingredientsList = sandwich.getIngredients();
        if (ingredientsList.size() != 0){
            for (int i = 0; i < ingredientsList.size(); i++) {
                ingredients.append(ingredientsList.get(i)+",");
            }
        }else{
            ingredients.setText( R.string.na);
        }
        

    }
}
