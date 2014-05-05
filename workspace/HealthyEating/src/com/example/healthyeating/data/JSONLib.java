package com.example.healthyeating.data;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONObject;

import android.util.Log;

public class JSONLib {
	ArrayList<String> index;
	ArrayList<RecipeItem> recipe;
	
	public JSONLib() {
		index = new ArrayList<String>();
		recipe = new ArrayList<RecipeItem>();
	}
	
	public void addRecipe(String ID, RecipeItem Recipe){
		if(ID!=null&&Recipe!=null){
		index.add(ID);
		recipe.add(index.indexOf(ID), Recipe);
		Log.e("ID", index.toString());
		Log.e("Recipe", recipe.toString());
		}
	}
	public RecipeItem getRecipe(String ID){
		if(recipe.get(index.indexOf(ID))!=null){
		return recipe.get(index.indexOf(ID));
		}
		else return null;
	}
}

