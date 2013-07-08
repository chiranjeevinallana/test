package com.azureiken.bitbeams;

import java.util.ArrayList;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

import com.azureiken.bitbeams.adapter.FolderListAdapter;
import com.azureiken.bitbeams.db.BitBeamsDbOperations;

public class CloudFoldersActivity extends Activity {
	private ArrayList<String> values;
	private BitBeamsDbOperations dbOperations;
	private String path;
	private Bundle b;
	private ListView list;
	private FolderListAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cloud_floders);
		list = (ListView)findViewById(R.id.cloud_list);
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
		getMenuInflater().inflate(R.menu.cloud_floders, menu);
		return true;
	}
	

}
