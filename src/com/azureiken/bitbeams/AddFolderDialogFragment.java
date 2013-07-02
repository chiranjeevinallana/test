package com.azureiken.bitbeams;

import java.io.File;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView.FindListener;
import android.widget.EditText;

public class AddFolderDialogFragment extends DialogFragment {
	
	public interface AddFolderDialogListener {
		public void onDialogPositiveClick(DialogFragment dialog);
		public void onDialogNegativeClick(DialogFragment dialog);
	}

	AddFolderDialogListener mListener;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
			// Instantiate the NoticeDialogListener so we can send events to the
			// host
			mListener = (AddFolderDialogListener) activity;
		} catch (ClassCastException e) {
			// The activity doesn't implement the interface, throw exception
			throw new ClassCastException(activity.toString()
					+ " must implement AddFolderDialogListener");
		}
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		LayoutInflater inflater = getActivity().getLayoutInflater();
		final View dialogView = inflater.inflate(R.layout.activity_new_folder_dialog, null);
		builder.setView(dialogView)
				.setPositiveButton(R.string.createFolder,
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int id) {
								
								System.out.println("Folder creation started");
								EditText et = (EditText) dialogView.findViewById(R.id.folderName);
								String folderName = et.getText().toString();
								String extStorageDirectory = Environment.getExternalStorageDirectory()
										.toString();
								System.out.println("Dir path: "+extStorageDirectory);
								File myNewFolder = new File(extStorageDirectory + "/"+folderName);
								boolean result = myNewFolder.mkdir();
								
								System.out.println("Folder created: "+result);
								
							}
						})
				.setNegativeButton(R.string.cancel,
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								AddFolderDialogFragment.this.getDialog().cancel();
							}
						});

		return builder.create();
	}

}
