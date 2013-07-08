package com.azureiken.bitbeams;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Properties;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;

import com.azureiken.bitbeams.adapter.FolderListAdapter;
import com.azureiken.bitbeams.dao.OrderedProperties;
import com.azureiken.bitbeams.dao.ReadResources;
import com.azureiken.bitbeams.db.BitBeamsDbOperations;

public class MainActivity extends Activity {
	private static final String prefix = "home";
	public static final int RESOURCE_REQ =1;
	private static Intent intent;
	private static Class myClass;
	private FolderListAdapter adapter;
	private SearchView mSearchView;

	MenuItem searchItem;
	private ListView list;
	private ArrayList<String> values;
	private final String PATH=null;
	private BitBeamsDbOperations dbOperations;
	
	// private Folder folderList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
		intent = new Intent(this,ReadResources.class);
		startActivityForResult(intent, RESOURCE_REQ);
		setContentView(R.layout.activity_main);
		list = (ListView) findViewById(R.id.main_listview);
		
		
		
		dbOperations = new BitBeamsDbOperations(getBaseContext());
		
		
		
//		boolean mboolean = false;
//
//		SharedPreferences settings = getSharedPreferences("PREFS_NAME", 0);
//		mboolean = settings.getBoolean("FIRST_RUN", false);
//		if (!mboolean) {
//			// do the thing for the first time
//			try {
//				InputStream properties = getResources().openRawResource(
//						R.raw.development);
//				Properties props = new OrderedProperties();
//				props.load(properties);
//
//				String keyValue = null;
//				values = new ArrayList<String>();
//
//				Enumeration<?> key = props.propertyNames();
//
//				while (key.hasMoreElements()) {
//					keyValue = (String) key.nextElement();
//					if (keyValue.startsWith(prefix)) {
//						values.add(props.getProperty(keyValue));
//					}
//				}
//				ArrayList<String> fileInfo = new ArrayList<String>();
//				for (String file : values) {
//					fileInfo.add(file);
//					fileInfo.add("folder");
//					fileInfo.add("null");
//					dbOperations.InsertData(fileInfo);
//					
//					fileInfo.clear();
//				}
//
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//
//			SharedPreferences.Editor editor = settings.edit();
//			editor.putBoolean("FIRST_RUN", true);
//			editor.commit();
//		}
	
		values = dbOperations.getFolder(PATH);
		adapter = new FolderListAdapter(this, values);
		list.setAdapter(adapter);
		list.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				System.out.println("id is : ------------------" + id);
				Bundle bundle = new Bundle();
				try {
					if ((int) id == 0) {
						myClass = Class
								.forName("com.azureiken.bitbeams.DocumentListActivity");
						bundle.putString("path", "Documents");

					} else if ((int) id == 1){
						myClass = Class
								.forName("com.azureiken.bitbeams.CloudFoldersActivity");
						bundle.putString("path", "Cloudbase");
					}
					else if ((int) id == 2){
						myClass = Class
								.forName("com.azureiken.bitbeams.WorkingFolderActivity");
						bundle.putString("path", "WrokingFolder");
					}
					else if ((int) id == 3){
						myClass = Class
								.forName("com.azureiken.bitbeams.PhotoListActivity");
						bundle.putString("path", "Photos");
					}
					else if ((int) id == 4){
						myClass = Class
								.forName("com.azureiken.bitbeams.AudioListActivity");
						bundle.putString("path", "Audio");
					}
					intent = new Intent(MainActivity.this, myClass);
					intent.putExtras(bundle);
					startActivity(intent);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.box_menu, menu);
		searchItem = menu.findItem(R.id.search);
        

		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		try {

			switch (item.getItemId()) {

			case R.id.boxLogin:
				myClass = Class
						.forName("com.azureiken.boxcloudstorage.BoxLoginActivity");
				break;

			case R.id.settings:
				return true;

			}
			intent = new Intent(MainActivity.this, myClass);
			startActivity(intent);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}




	
	


}
