package com.azureiken.bitbeams.adapter;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.azureiken.bitbeams.R;

public class FolderListAdapter extends BaseAdapter {
	private Activity activity;
	
	private ArrayList<String> values;
	
	private static LayoutInflater inflater=null;
	
	public FolderListAdapter(Activity activity, ArrayList<String> values) {
		this.activity = activity;
		this.values = values;
		System.out.println("FolderListAdapter created..");
		inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
	
	public void setValues(ArrayList<String> values){
		this.values = values;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return values.size();
	}


	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View vi = convertView;
		System.out.println("View method");
		if(convertView==null)
			vi = inflater.inflate(R.layout.list_row,null);
		ImageView imageView = (ImageView)vi.findViewById(R.id.list_image);
		TextView title = (TextView)vi.findViewById(R.id.title);
		
		
		title.setText(values.get(position));
		
		String s=(String) values.get(position);
		title.setText(s);
		
		if (s.equals("Documents")) {
			imageView.setImageResource(R.drawable.folder_documents);
			title.setText(R.string.title_activity_document_list);
		} else if (s.equals("Cloud base")) {
			imageView.setImageResource(R.drawable.cloud);
			title.setText(R.string.title_activity_box_floders);
		} else if (s.equals("Work area")) {
			imageView.setImageResource(R.drawable.works_in_progress);
			title.setText(R.string.title_activity_working_folder);
		} else if (s.equals("Photos")){
			imageView.setImageResource(R.drawable.camera);
			title.setText(R.string.title_activity_photo_list);
		} else if(s.equals("Songs/Voice memos")){
			imageView.setImageResource(R.drawable.music);
			title.setText(R.string.title_activity_audio_list);
		}
		else {
			imageView.setImageResource(R.drawable.folder);
		}
		return vi;
	}
	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	
}
