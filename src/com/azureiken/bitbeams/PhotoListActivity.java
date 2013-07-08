package com.azureiken.bitbeams;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Properties;

import com.azureiken.bitbeams.R;
import com.azureiken.bitbeams.adapter.FolderListAdapter;
import com.azureiken.bitbeams.dao.OrderedProperties;
import com.azureiken.bitbeams.db.BitBeamsDbOperations;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ListView;

public class PhotoListActivity extends Activity {
	
	private ArrayList<String> values;
	private BitBeamsDbOperations dbOperations;
	private String path;
	private Bundle b;
	private ListView list;
	private FolderListAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_photo_list);
		list = (ListView)findViewById(R.id.photo_list);
		b = getIntent().getExtras();
		path = b.getString("path");
		dbOperations = new BitBeamsDbOperations(getBaseContext());
		values = dbOperations.getFolder(path);
		adapter = new FolderListAdapter(this, values);
		list.setAdapter(adapter);	

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.photo_list, menu);
		return true;
	}

}
