package com.example.healthyeating;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class RecipesMain extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.recipesmain);
		super.onCreate(savedInstanceState);
		setUpTabHost();
	}
	
	//Sets up the tab host that will hold all of the taps to navigate to other parts of the app
  	public void setUpTabHost(){
  		//_________Initializes and sets up Tap Host_________//
  		
  				TabHost th = (TabHost) findViewById(R.id.tabhost);
  			    th.setup();
  			    
  			    //---Adds Home Tab to TabHost---//
  			    TabSpec specs = th.newTabSpec("tab1");
  			    specs.setContent(R.id.tab1);
  			    specs.setIndicator("All");
  			    th.addTab(specs);
  			    
  			    //---Adds Recipes Tab to TabHost---//
  			    specs = th.newTabSpec("tab2");
  			    specs.setContent(R.id.tab2);
  			    specs.setIndicator("Highest Rated");
  			    th.addTab(specs);
  			    
  			    //---Adds Favortits Tab to TabHost---//	    
  			    specs = th.newTabSpec("tab3");
  			    specs.setContent(R.id.tab3);
  			    specs.setIndicator("Newest");
  			    th.addTab(specs);
  			    
  		//_____________________________________________________//
  	}
}
