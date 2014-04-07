package com.example.healthyeating.data;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class JsonParser {

	static JSONObject mainObject = null;
	
	public JsonParser(JSONObject _object) throws JSONException{
		mainObject = _object;
		System.out.println( "Json Parser " + getTop5().toString());
		
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
		JSONArray  top5 = mainObject.getJSONArray("top5");
		
		for(int i =0; i<top5.length(); i++){
			JSONObject dishObj = top5.getJSONObject(i);
			//JSONObject getIndividualVideoData = dishObj.getJSONObject("DishName");
			DishNames.add(dishObj.get("DishName").toString());
			DishDescrip.add(dishObj.get("DishDescription").toString());
			DishRating.add(dishObj.get("DishRating").toString());
			DishServes.add(dishObj.get("DishServes").toString());
		}
		returnData.add(DishNames);
		returnData.add(DishDescrip);
		returnData.add(DishServes);
		returnData.add(DishRating);
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
