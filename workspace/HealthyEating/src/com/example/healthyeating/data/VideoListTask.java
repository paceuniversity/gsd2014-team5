package com.example.healthyeating.data;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class VideoListTask extends AsyncTask<Void, Void, Void> {

	
	Activity activity;
	
	
	ProgressDialog dialog;
	Context ctx;
	ListView YouTubeListView;
	ArrayList<String> videoTitleList = new ArrayList<String>();
	ArrayList<String> videoIDList = new ArrayList<String>();
	ArrayList<String> videoThumbnailList = new ArrayList<String>();

	
	public VideoListTask(){
		Log.e	("YouTubeData", "Called");
	}
	
	@Override
	protected void onPreExecute() {
		
		//dialog = new ProgressDialog(ctx);
		//dialog.setTitle("Loading Videos");
		//dialog.show();

		super.onPreExecute();
	}
	@Override
	protected Void doInBackground(Void... params) {
		Log.e	("YouTubeData", "Started");
		HttpResponse response = null;
	DefaultHttpClient client = new DefaultHttpClient();
			HttpGet getRequest = new HttpGet("http://turbotri.com/gsd2014team5.json");
			
			
			try {
					response = client.execute(getRequest);
				} catch (ClientProtocolException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				StatusLine statusLine = response.getStatusLine();
				int statusCode = statusLine.getStatusCode();
				
				if(statusCode != 200){
					return null;
				}
			
				InputStream jsonStream = null;
				try {
					jsonStream = response.getEntity().getContent();
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				BufferedReader reader = new BufferedReader(new InputStreamReader(jsonStream));
				StringBuilder builder = new StringBuilder();
				String line;
				
			try {
				while((line = reader.readLine()) !=null){
						builder.append(line);
					}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String jsonData = builder.toString();
				Log.i("YouTubeData", jsonData);
				
				 
				try {
					JSONObject json = new JSONObject(jsonData);
					Log.e("Json user:", json.getString("user").toString());

				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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
			return null;
		
	}
	@Override
	protected void onPostExecute(Void result) {
		//dialog.dismiss();
		super.onPostExecute(result);
	}

	

	
	
	
}