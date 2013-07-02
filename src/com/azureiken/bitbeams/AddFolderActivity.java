package com.azureiken.bitbeams;

import java.io.File;

import com.azureiken.bitbeams.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;


public class AddFolderActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		System.out.println("------------ Folder Creation: ---------------");
		setContentView(R.layout.activity_add_folder);
		File wallpaperDirectory = new File("/sdcard/Wallpaper");
		wallpaperDirectory.mkdirs();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_folder, menu);
		return true;
	}

}
