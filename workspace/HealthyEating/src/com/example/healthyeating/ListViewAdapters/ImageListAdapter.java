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
import com.example.healthyeating.*;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.LocalSocketAddress.Namespace;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageListAdapter extends ArrayAdapter<String> {

	private LayoutInflater mInflater;
	
	private ArrayList<String> albumNames;
	private TypedArray mIcons;
	private ArrayList<Bitmap> albumArt;
	private int mViewResourceId;
	private HashMap<String, Integer> albumTitlePosition;

	public ImageListAdapter(Context ctx, int viewResourceId,
			ArrayList<String> arrayList) {
		super(ctx, viewResourceId, arrayList);
		
		mInflater = (LayoutInflater)ctx.getSystemService(
				Context.LAYOUT_INFLATER_SERVICE);
		
		albumNames = arrayList;
		
		mViewResourceId = viewResourceId;
		albumTitlePosition = new HashMap<String, Integer>();
	}

	@Override
	public int getCount() {
		return albumNames.size();
	}

	@Override
	public String getItem(int position) {
		return albumNames.get(position);
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

		ImageView dishImage = (ImageView)convertView.findViewById(R.id.dishImage);
		dishImage.setImageResource(R.drawable.ic_launcher);

		ImageView dishRating = (ImageView)convertView.findViewById(R.id.dishRating);
		dishRating.setImageResource(R.drawable.three_stars);
		
		TextView dishName = (TextView)convertView.findViewById(R.id.dishName);
		dishName.setText("Dish_Name");
		
		TextView servings = (TextView)convertView.findViewById(R.id.dishServes);
		servings.setText("Serves: 4");
		
		TextView discription = (TextView)convertView.findViewById(R.id.dishDiscription);
		discription.setText("This will be a very breif discription on the dish");
		return convertView;
	}
}
