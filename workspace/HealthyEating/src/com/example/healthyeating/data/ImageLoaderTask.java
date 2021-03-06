package com.example.healthyeating.data;

import java.io.InputStream;

import com.example.healthyeating.R;

import android.graphics.AvoidXfermode.Mode;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.ImageView;

public class ImageLoaderTask extends AsyncTask<String, Void, Bitmap>{
	ImageView recipeListViewImageView;
	ImageButton imageButton;
	Boolean imageView = null;
	  public ImageLoaderTask(ImageView input_recipeListViewImageView, Boolean isImageView, ImageButton input_recipeListViewImageButton) {
	      imageView = isImageView;
		  if(isImageView){
		  this.recipeListViewImageView = input_recipeListViewImageView;
	      }
	      else{
	    	  imageButton = input_recipeListViewImageButton;
	      }
	  }

	  protected Bitmap doInBackground(String... urls) {
	      String urldisplay = urls[0];
	      Bitmap thumbNail = null;
	      try {
	        InputStream in = new java.net.URL(urldisplay).openStream();
	        thumbNail = BitmapFactory.decodeStream(in);
	      } catch (Exception e) {
	          Log.e("Error", e.getMessage());
	          e.printStackTrace();
	      }

	      return thumbNail;
	  }

	  protected void onPostExecute(Bitmap result) {
		  
		  if(imageView){
		  if(result!=null){
	      result = result.createScaledBitmap(result, 100, 95, true);
	      result = roundCorner(result, 5f);
		  recipeListViewImageView.setImageBitmap(result);
		  }else{
		  recipeListViewImageView.setImageResource(R.drawable.ic_launcher);
		  }		
		  }
		  
		  else{
			  if(result!=null){
			  int width = imageButton.getWidth();
			  int height = imageButton.getHeight();
			  result = result.createScaledBitmap(result, width, height, true);
		      result = roundCorner(result, 0f);
			  imageButton.setImageBitmap(result);
			  }else{
			  imageButton.setImageResource(R.drawable.ic_launcher);
			  }
		  }
		  return;
	  }
	  
	  @SuppressWarnings("deprecation")
	public static Bitmap roundCorner(Bitmap src, float round) {
		    // image size
		    int width = src.getWidth();
		    int height = src.getHeight();
		    // create bitmap output
		    Bitmap result = Bitmap.createBitmap(width, height, Config.ARGB_8888);
		    // set canvas for painting
		    Canvas canvas = new Canvas(result);
		    canvas.drawARGB(0, 0, 0, 0);
		 
		    // config paint
		    final Paint paint = new Paint();
		    paint.setAntiAlias(true);
		    paint.setColor(Color.BLACK);
		 
		    // config rectangle for embedding
		    final Rect rect = new Rect(0, 0, width, height);
		    final RectF rectF = new RectF(rect);
		 
		    // draw rect to canvas
		    canvas.drawRoundRect(rectF, round, round, paint);
		 
		    // create Xfer mode
		    paint.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_IN));
		    // draw source image to canvas
		    canvas.drawBitmap(src, rect, rect, paint);
		 
		    // return final image
		    return result;
		}


	}
