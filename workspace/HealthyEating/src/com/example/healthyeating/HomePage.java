package com.example.healthyeating;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.example.healthyeating.ListViewAdapters.ImageListAdapter;
import com.example.healthyeating.data.RetriveData;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class HomePage extends Activity {
	
	//------Top 5 Recipes--------///
	ListView top20ListView; // list view for top 10 recipes on home page
	ImageListAdapter top20adabter;
	//---------------------------///
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
        top20ListView = (ListView) findViewById(R.id.top20); // Initializes the list view

        //Class method to set up the tap host 
        setUpTabHost();
        //Calls the method to populate the top 5 list view with all the needed information
        populateTop20ListView(top20ListView);
        
        RetriveData temp = new RetriveData();
        temp.execute();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    
    //Handles all the work reguired in order to populate the list view
    private void populateTop20ListView(ListView listview){
    	ArrayList<String> names = new ArrayList<String>();
    	names.add("Hello");
    	names.add("Hello");
    	names.add("Hello");
    	names.add("Hello");
    	names.add("Hello");
    	names.add("Hello");
    	names.add("Hello");
    	names.add("Hello");
    	names.add("Hello");
    	names.add("Hello");
    	names.add("Hello");
    	names.add("Hello");
    	names.add("Hello");
    	names.add("Hello");
    	names.add("Hello");
    	names.add("Hello");
    	names.add("Hello");
    	names.add("Hello");
    	names.add("Hello");
    	names.add("Hello");
    	
    	
		top20adabter = new ImageListAdapter(getApplicationContext(), R.layout.image_list_item, names);
		top20ListView.setAdapter(top20adabter); //Populates the list view one the home page with the top 5 recipes
    }
    
    
  //Sets up the tab host that will hold al of the video list
  	public void setUpTabHost(){
  		//_________Initializes and sets up Tap Host_________//
  		
  				TabHost th = (TabHost) findViewById(R.id.tabhost);
  			    th.setup();
  			    
  			    //---Adds Hip/Hop Tab to TabHost---//
  			    TabSpec specs = th.newTabSpec("tab1");
  			    specs.setContent(R.id.tab1);
  			    specs.setIndicator("Home");
  			    th.addTab(specs);
  			    
  			    //---Adds Rock Tab to TabHost---//
  			    specs = th.newTabSpec("tab2");
  			    specs.setContent(R.id.tab2);
  			    specs.setIndicator("Recipes");
  			    th.addTab(specs);
  			    
  			    //---Adds Country Tab to TabHost---//	    
  			    specs = th.newTabSpec("tab3");
  			    specs.setContent(R.id.tab3);
  			    specs.setIndicator("Favorits");
  			    th.addTab(specs);
  			    
  		//_____________________________________________________//
  	}
    
  	
  	
  
  	
	
  	
  	
  	
  	
}