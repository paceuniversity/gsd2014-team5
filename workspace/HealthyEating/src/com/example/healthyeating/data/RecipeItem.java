package com.example.healthyeating.data;

public class RecipeItem {
	String ID = null;
	String DISH_NAME = null;
	String DISH_DISCRIPTION = null;
	String DISH_RATING = null;
	String DISH_SERVES = null;
	String DISH_IMAGE = null;
	String DISH_COOK_TIME = null;
	String DISH_FULL_DISCRIPTION = null;
	String DISH_INGREDIENTS = null;
	String DISH_STEPS = null;
	
	public RecipeItem(String _ID, String _DISH_NAME, String _DISH_DISCRIPTION,
			String _DISH_RATING, String _DISH_SERVES, String _DISH_IMAGE, String _DISH_COOK_TIME,
			String _DISH_FULL_DISCRIPTION, String _DISH_INGREDIENTS, String _DISH_STEPS) {

		ID = _ID;
		DISH_NAME = _DISH_NAME;
		DISH_DISCRIPTION = _DISH_DISCRIPTION;
		DISH_RATING = _DISH_RATING;
		DISH_SERVES = _DISH_SERVES;
		DISH_IMAGE = _DISH_IMAGE;
		DISH_COOK_TIME = _DISH_COOK_TIME;
		DISH_FULL_DISCRIPTION = _DISH_FULL_DISCRIPTION;
		DISH_INGREDIENTS = _DISH_INGREDIENTS;
		DISH_STEPS = _DISH_STEPS;
	}
	
	@Override
	public String toString() {
		String temp = ID + ", " + DISH_NAME + ", " + DISH_DISCRIPTION + ", " + DISH_SERVES + ", ";
		temp = temp.concat(DISH_IMAGE + ", " + DISH_COOK_TIME + ", " + DISH_FULL_DISCRIPTION + ", " + DISH_INGREDIENTS + ", " + DISH_STEPS);
		return temp;
	}
	public String  getDishID(){ 
		return ID;
	}
	public String  getDishName(){ 
		return DISH_NAME;
	}
	public String  getDishFullDiscription(){ 
		return DISH_FULL_DISCRIPTION;
	}
	public String  getDishRating(){ 
		return DISH_RATING;
	}
	public String  getDishServes(){ 
		return DISH_SERVES;
	}
	public String  getDishImage(){ 
		return DISH_IMAGE;
	}
	public String  getDishCookTime(){ 
		return DISH_COOK_TIME;
	}
	public String  getDishIngredients(){ 
		return DISH_INGREDIENTS;
	}
	public String  getDishSteps(){ 
		return DISH_STEPS;
	}
	public String  getDishListViewDiscription(){ 
		return DISH_DISCRIPTION;
	}
}
