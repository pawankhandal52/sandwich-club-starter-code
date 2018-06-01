/*
 
 *Copyright (C) 2018 The Android Sandwich Project made under Udacity Nanodegree Course
 
 */
package com.udacity.sandwichclub.model;

import android.support.annotation.Nullable;

import java.util.List;

/**
 * This the Sandwich class is POJO
 */
public class Sandwich {

    private String mainName;
    //TODO: List value may be null if value is passed in constructor null.
    @Nullable
    private List<String> alsoKnownAs = null;
    private String placeOfOrigin;
    private String description;
    private String image;
    //TODO: List value may be null if value is passed in constructor null.
    @Nullable
    private List<String> ingredients = null;
    
    //TODO: List value may be null if value is passed in constructor null.
    public Sandwich(String mainName, @Nullable List<String> alsoKnownAs, String placeOfOrigin, String description, String image, @Nullable List<String> ingredients) {
        this.mainName = mainName;
        this.alsoKnownAs = alsoKnownAs;
        this.placeOfOrigin = placeOfOrigin;
        this.description = description;
        this.image = image;
        this.ingredients = ingredients;
    }

    public String getMainName() {
        return mainName;
    }
    
    //TODO: List value may be null if value is passed in constructor null.
    @Nullable
    public List<String> getAlsoKnownAs() {
        return alsoKnownAs;
    }
    
    public String getPlaceOfOrigin() {
        return placeOfOrigin;
    }
    
    public String getDescription() {
        return description;
    }
    
    public String getImage() {
        return image;
    }
    
    //TODO: List value may be null if value is passed in constructor null.

    @Nullable
    public List<String> getIngredients() {
        return ingredients;
    }
    
}
