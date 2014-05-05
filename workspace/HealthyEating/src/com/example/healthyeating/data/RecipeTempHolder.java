package com.example.healthyeating.data;

public class RecipeTempHolder {

	public static RecipeItem clickedItem;
	
	public static void setClilckedItem(RecipeItem item) {
		clickedItem = item;
	}
	public static RecipeItem getClickedItem() {
		return clickedItem;
	}
}
