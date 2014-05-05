package com.example.healthyeating.data;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class JsonParser {

	static JSONObject mainObject = null;
	JSONLib Libary;
	
	public JsonParser(JSONObject _object, JSONLib lib) throws JSONException{
		mainObject = _object;
		Libary = lib;		
	}
	
	public String getAllOfValue__(String value){
		String DishNames = null;
		
		return DishNames;
	}
	
	public ArrayList<ArrayList<String>> getTop5() throws JSONException{
		if(mainObject!=null){
		ArrayList<ArrayList<String>> returnData = new ArrayList<ArrayList<String>>();
		ArrayList<String> DishNames = new ArrayList<String>();
		ArrayList<String> DishDescrip = new ArrayList<String>();
		ArrayList<String> DishRating = new ArrayList<String>();
		ArrayList<String> DishServes = new ArrayList<String>();
		ArrayList<String> DishImageURL = new ArrayList<String>();
		ArrayList<String> index = new ArrayList<String>();
		ArrayList<RecipeItem> recipes = new ArrayList<RecipeItem>();
		JSONArray  top5 = mainObject.getJSONArray("Top5");
		Log.d("top5 length", Integer.toString(top5.length()));
		for(int i =0; i<top5.length(); i++){
			JSONObject dishObj = top5.getJSONObject(i);
			//JSONObject getIndividualVideoData = dishObj.getJSONObject("DishName");
			DishNames.add(dishObj.get("DishName").toString());
			DishDescrip.add(dishObj.get("DishDescription").toString());
			DishRating.add(dishObj.get("DishRating").toString());
			DishServes.add(dishObj.get("DishServes").toString());
			DishImageURL.add(dishObj.get("DishImage").toString());
			/*recipes.add(new RecipeItem(dishObj.get("id").toString(), dishObj.get("DishName").toString(), dishObj.get("DishDescription").toString(), dishObj.get("DishRating").toString(),
					dishObj.get("DishServes").toString(), dishObj.get("DishURL").toString(), dishObj.get("DishCookTime").toString(), dishObj.get("DishFullDiscription").toString(),
					dishObj.get("DishIngredients").toString(), dishObj.get("DishSteps").toString()));
			index.add(dishObj.get("id").toString());*/
			Libary.addRecipe(dishObj.get("ID").toString(), new RecipeItem(dishObj.get("ID").toString(), dishObj.get("DishName").toString(), dishObj.get("DishDescription").toString(), dishObj.get("DishRating").toString(),
					dishObj.get("DishServes").toString(), dishObj.get("DishImage").toString(), dishObj.get("CookTime").toString(), dishObj.get("FullDiscription").toString(),
					dishObj.get("Ingredients").toString(), dishObj.get("Steps").toString()));
					}
		
		returnData.add(DishNames);
		returnData.add(DishDescrip);
		returnData.add(DishServes);
		returnData.add(DishRating);
		returnData.add(DishImageURL);
		return  returnData;
		}
		else return null;
	}
	
	
	/*JSONObject data = json.getJSONObject("data");
	JSONArray  items = data.getJSONArray("items");
	
	for(int i =0; i<items.length(); i++){
		JSONObject video = items.getJSONObject(i);
		JSONObject getIndividualVideoData = video.getJSONObject("video");
		
		Videos temp = new Videos(getIndividualVideoData.getString("id"), getIndividualVideoData.getString("title"), getIndividualVideoData.getJSONObject("thumbnail").getString("sqDefault"));
		libary.add(temp);
		videoTitleList.add(libary.getVideoTitle(i));
		videoThumbnailList.add(libary.getVideoThumbNailURL(i));
		Log.i("videoinfo", getIndividualVideoData.getJSONObject("thumbnail").getString("sqDefault"));
		videoIDList.add(libary.getVideoID(i));
	}
	
} catch (ClientProtocolException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (JSONException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}*/
	
	
}
