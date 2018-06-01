/*
 
 *Copyright (C) 2018 The Android Sandwich Project made under Udacity Nanodegree Course
 
 */
package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * This the JsonUtils class is used to parse the Json data
 */
public class JsonUtils {
    private static final String TAG = JsonUtils.class.getSimpleName();
    
    
    public static Sandwich parseSandwichJson(String json) throws JSONException{
        try {
            //Convert String into Json
            JSONObject jsonObject = new JSONObject(json);
            Log.d(TAG, "parseSandwichJson: jsonObject "+jsonObject);
            
            //Get the Sandwich name
            String sandwichName = jsonObject.getJSONObject("name").getString("mainName");
            
            //Get all the Also Known as Name
            List<String> alsoKnownAsStringList = new ArrayList<>();
            JSONArray alsoKnownAsJsonArray =  jsonObject.getJSONObject("name").getJSONArray("alsoKnownAs");
            for (int i = 0; i < alsoKnownAsJsonArray.length(); i++) {
                alsoKnownAsStringList.add(alsoKnownAsJsonArray.getString(i));
            }
            
            //Get Place Of Origin
            String placeOfOrigin = jsonObject.getString("placeOfOrigin");
            
            //Get Image
            String sandwichImage =  jsonObject.getString("image");
            
            //Get Description
            String description =  jsonObject.getString("description");
            
            //Get ingredients
            List<String> ingredientsList = new ArrayList<>();
            JSONArray ingredientsJsonArray =  jsonObject.getJSONArray("ingredients");
            for (int i = 0; i < ingredientsJsonArray.length(); i++) {
                ingredientsList.add(ingredientsJsonArray.getString(i));
            }
            
            //Add all the values in Sandwich
            return new Sandwich(sandwichName,alsoKnownAsStringList,placeOfOrigin,description,sandwichImage,ingredientsList);
            
        } catch (JSONException e) {
            e.printStackTrace();
            throw new JSONException("unable to parse");
            
        }
    
        
    }
    
    
}
