package com.azureiken.bitbeams;

import com.azureiken.bitbeams.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class WorkingFolderActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_working_folder);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.working_folder, menu);
		return true;
	}

}
