package com.azureiken.bitbeams;

import com.azureiken.bitbeams.AddFolderDialogFragment.AddFolderDialogListener;
import com.azureiken.bitbeams.R;

import android.os.Bundle;
import android.app.Activity;
import android.app.DialogFragment;

import android.view.Menu;
import android.view.MenuItem;

public class DocumentListActivity extends Activity implements AddFolderDialogListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_document_list);
		String path = savedInstanceState.getString("path");
		System.out.println("path is: "+path+"\\");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.document_list, menu);
		
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub

		try {
			switch (item.getItemId()) {
			case R.id.addFolder:
				DialogFragment newFragment = new AddFolderDialogFragment();
				newFragment.show(getFragmentManager(), "add_folder");
				break;
			case R.id.settings:
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public void onDialogPositiveClick(DialogFragment dialog) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDialogNegativeClick(DialogFragment dialog) {
		// TODO Auto-generated method stub
		
	}

}
