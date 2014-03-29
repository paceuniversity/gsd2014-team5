package com.example.healthyeating;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class Splash extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        
        Thread splashTimer = new Thread(){
        	
        	public void run() {
				try{
					sleep(5000);
				} catch(InterruptedException e){
					e.printStackTrace();
				}finally{
					Intent startHome = new Intent("com.example.healthyeating.HomePage");
					startActivity(startHome);
				
				}
			}
        	
        };
        splashTimer.start();
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
 
    @Override
    protected void onPause() {
    	// TODO Auto-generated method stub
    	super.onPause();
    	finish();
    }
    
}
