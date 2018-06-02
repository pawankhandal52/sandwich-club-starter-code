/*
 
 *Copyright (C) 2018 The Android Sandwich Project made under Udacity Nanodegree Course
 
 */
package com.udacity.sandwichclub.utils;

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
    
    
    public static Sandwich parseSandwichJson(String json) throws JSONException{
        try {
            //Convert String into Json
            JSONObject jsonObject = new JSONObject(json);
            //Get the Sandwich name
            String sandwichName = jsonObject.optJSONObject("name").optString("mainName");
            
            //Get all the Also Known as Name
            List<String> alsoKnownAsStringList = new ArrayList<>();
            JSONArray alsoKnownAsJsonArray =  jsonObject.optJSONObject("name").optJSONArray("alsoKnownAs");
            for (int i = 0; i < alsoKnownAsJsonArray.length(); i++) {
                alsoKnownAsStringList.add(alsoKnownAsJsonArray.optString(i));
            }
            
            //Get Place Of Origin
            String placeOfOrigin = jsonObject.optString("placeOfOrigin");
            
            //Get Image
            String sandwichImage =  jsonObject.optString("image");
            
            //Get Description
            String description =  jsonObject.optString("description");
            
            //Get ingredients
            List<String> ingredientsList = new ArrayList<>();
            JSONArray ingredientsJsonArray =  jsonObject.getJSONArray("ingredients");
            for (int i = 0; i < ingredientsJsonArray.length(); i++) {
                ingredientsList.add(ingredientsJsonArray.optString(i));
            }
            
            //Add all the values in Sandwich
            return new Sandwich(sandwichName,alsoKnownAsStringList,placeOfOrigin,description,sandwichImage,ingredientsList);
            
        } catch (JSONException e) {
            e.printStackTrace();
            throw new JSONException("unable to parse");
            
        }
    
        
    }
    
    
}
