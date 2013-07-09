package com.azureiken.bitbeams.dao;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Properties;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.azureiken.bitbeams.R;
import com.azureiken.bitbeams.db.BitBeamsDbOperations;

public class ReadResources extends Activity {

	private BitBeamsDbOperations dbOperations;
	private ArrayList<String> values;
	private ArrayList<String> keys;
	private Intent intent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		dbOperations = new BitBeamsDbOperations(getBaseContext());
		
			// do the thing for the first time
			System.out.println("First Run");
			try {
				InputStream properties = getResources().openRawResource(
						R.raw.development);
				
				Properties props = new OrderedProperties();
				
				
				props.load(properties);

				String keyValue = null;
				values = new ArrayList<String>();
				keys = new ArrayList<String>();
				Enumeration<?> key = props.propertyNames();

				

				while (key.hasMoreElements()) {
					keyValue = (String) key.nextElement();
					keys.add(keyValue);
					values.add(props.getProperty(keyValue));
				}
				ArrayList<String> fileInfo = new ArrayList<String>();

				for (int i = 0; i < values.size(); i++) {
					fileInfo.add(values.get(i));
					fileInfo.add("folder");
					if (keys.get(i).startsWith("home")) {
						fileInfo.add("null");
					} else if (keys.get(i).startsWith("cloudBase")) {
						fileInfo.add("Cloudbase");
					} else if (keys.get(i).startsWith("photos")) {
						fileInfo.add("Photos");
					}
					dbOperations.InsertData(fileInfo);

					fileInfo.clear();

				}
			

			} catch (Exception e) {
				e.printStackTrace();
			}

			
		dbOperations.closeConnection();
		
		setResult(RESULT_OK);
		finish();

	}

}
