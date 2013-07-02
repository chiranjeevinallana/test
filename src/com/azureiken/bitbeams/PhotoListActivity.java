package com.azureiken.bitbeams;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Properties;

import com.azureiken.bitbeams.R;
import com.azureiken.bitbeams.dao.OrderedProperties;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class PhotoListActivity extends Activity {
	private static ArrayList<String> values;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_photo_list);


	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.photo_list, menu);
		return true;
	}

}
