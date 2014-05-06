package com.example.healthFacts;

import android.graphics.Bitmap;

public class HealthFactItem {

	String factImageURL;
	String ID;
	String Data;
	public HealthFactItem(String _factImageURL, String _ID, String _Data) {
		factImageURL = _factImageURL;
		ID = _ID;
		Data = _Data;
	}
	
	public String getURL(){
		return factImageURL;
	}
	
	public String getID(){
		return ID;
	}
	
	public String getData(){
		return Data;
	}
	
}
