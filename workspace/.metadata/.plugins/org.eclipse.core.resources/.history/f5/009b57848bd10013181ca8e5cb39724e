package com.example.healthyeating.ListViewAdapters;


/**
 * This file is part of AdvancedListViewDemo.
 * You should have downloaded this file from www.intransitione.com, if not, 
 * please inform me by writing an e-mail at the address below:
 *
 * Copyright [2011] [Marco Dinacci <marco.dinacci@gmail.com>]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.

 * The license text is available online and in the LICENSE file accompanying the distribution
 * of this program.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

import com.example.healthyeating.*;
import com.example.healthyeating.data.ImageLoaderTask;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.LocalSocketAddress.Namespace;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageListAdapter extends ArrayAdapter<String> {

	private LayoutInflater mInflater;
	
	private ArrayList<String> dishNames;
	private ArrayList<String> dishDescription;
	private ArrayList<String> dishServes;
	private ArrayList<Bitmap> dishImages;
	private TypedArray mIcons;
	private ArrayList<Bitmap> albumArt;
	private int mViewResourceId;
	private HashMap<String, Integer> albumTitlePosition;
	

	public ImageListAdapter(Context ctx, int viewResourceId,
			ArrayList<String> _dishNames, ArrayList<String> _dishDescription, ArrayList<String> _dishServes) {
		super(ctx, viewResourceId, _dishNames);
		
		mInflater = (LayoutInflater)ctx.getSystemService(
				Context.LAYOUT_INFLATER_SERVICE);
		
		dishNames = _dishNames;
		dishDescription = _dishDescription;
		dishServes = _dishServes;
		dishImages = new ArrayList<Bitmap>();
		mViewResourceId = viewResourceId;
		albumTitlePosition = new HashMap<String, Integer>();
		
		//Image Loader to get images from server download them and add them to list view

	}

	@Override
	public int getCount() {
		return dishNames.size();
	}

	@Override
	public String getItem(int position) {
		return dishNames.get(position);
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}
	
	public HashMap<String, Integer> getAlbumTiltlePositions(){
		return albumTitlePosition;
	}
 
	
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		convertView = mInflater.inflate(mViewResourceId, null);

		//Sets the dish image retrieved from the server to the item within the list view
		ImageView dishImage = (ImageView)convertView.findViewById(R.id.dishImage);
		if(dishImages.size()-1 >= position && dishImages.get(position)!=null){
			dishImage.setImageBitmap(dishImages.get(position));
		}
		else{
		ImageLoaderTask imageLoader = new ImageLoaderTask(dishImage);
		imageLoader.execute("http://turbotri.com/gsd2014team5/images/ic_launcher.png");
		try {
			dishImages.add(position, imageLoader.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		//dishImage.setImageResource(R.drawable.ic_launcher);
		
		//Sets the image for rating retrieved from the server to the item within the list view
		ImageView dishRating = (ImageView)convertView.findViewById(R.id.dishRating);
		dishRating.setImageResource(R.drawable.three_stars);
		
		//Sets the dish name retrieved from the server to the item within the list view
		TextView dishName = (TextView)convertView.findViewById(R.id.dishName);
		dishName.setText(dishNames.get(position));
		
		//Sets the serving size retrieved from the server to the item within the list view
		TextView servings = (TextView)convertView.findViewById(R.id.dishServes);
		servings.setText("Serves: " + dishServes.get(position));
		
		//Sets the discription retrieved from the server to the item within the list view
		TextView discription = (TextView)convertView.findViewById(R.id.dishDiscription);
		discription.setText(dishDescription.get(position));
		return convertView;
	}
}
