package com.cristiano.intentexperiment;

import com.cristiano.intentexperiment.R;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	Button btcalc, btchrome, btmaps;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btcalc = (Button) findViewById(R.id.btncalc);
		btchrome = (Button) findViewById(R.id.btnchrome);
		btmaps = (Button) findViewById(R.id.btnmaps);

		btcalc.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				
				/*
				Intent intent = new Intent();
				intent.setAction(Intent.ACTION_MAIN);
				intent.addCategory(Intent.CATEGORY_LAUNCHER);
				intent.setComponent(new ComponentName("com.android.calculator2", "com.android.calculator2.Calculator"));
				startActivity(intent);
				*/
				
				Intent intent = new Intent();
				intent.setAction(Intent.ACTION_MAIN);
				intent.addCategory(Intent.CATEGORY_APP_CALCULATOR);
				//intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(intent);

			}

		});
		
		btchrome.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {

				Uri webpage = Uri.parse("http://fatecourinhos.edu.br");
			    
			    Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
			    //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			    intent.setPackage("com.android.chrome");
			    
			    // try to open chrome directly, if not available, open package manager for browsers
			    try {
			        startActivity(intent);
			    } catch (ActivityNotFoundException e) {
			    	
			    	if (intent.resolveActivity(getPackageManager()) != null) {
			    		intent.setPackage(null);
				        startActivity(intent);
				    }
			    	
			    }

			}

		});
		
		btmaps.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {

				Intent intent = new Intent(Intent.ACTION_VIEW);
				Uri coord = Uri.parse("geo:-22.9507677,-49.8961666?z=15");
			    intent.setData(coord);
			    
			    if (intent.resolveActivity(getPackageManager()) != null) {
			        startActivity(intent);
			    }

			}

		});		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
