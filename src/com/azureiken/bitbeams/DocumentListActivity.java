package com.azureiken.bitbeams;

import java.util.ArrayList;

import android.app.Activity;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;

import com.azureiken.bitbeams.adapter.FolderListAdapter;
import com.azureiken.bitbeams.db.BitBeamsDbOperations;

//import com.azureiken.bitbeams.AddFolderDialogFragment.AddFolderDialogListener;

public class DocumentListActivity extends Activity {
	private String path;
	private Bundle b;
	private ArrayList<String> values;
	private FolderListAdapter adapter;
	private BitBeamsDbOperations dBOperations;
	private ListView list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_document_list);
		list = (ListView)findViewById(R.id.documents_listview);
		b = getIntent().getExtras();
		path = b.getString("path");
		dBOperations = new BitBeamsDbOperations(getBaseContext());
		values = dBOperations.getFolder(path+"\\");
		adapter = new FolderListAdapter(this, values);
		list.setAdapter(adapter);	
		list.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				
				b = getIntent().getExtras();
				path = b.getString("path");
				b.putString("path",path+"\\word");
				finish();
				startActivity(getIntent().putExtras(b));
			
			}
		});
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
				DialogFragment newFragment = AddFolderDialogFragment
						.newInstance(path);
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

	// @Override
	// public void onDialogPositiveClick(DialogFragment dialog) {
	// // TODO Auto-generated method stub
	//
	// }
	//
	// @Override
	// public void onDialogNegativeClick(DialogFragment dialog) {
	// // TODO Auto-generated method stub
	//
	// }

}
