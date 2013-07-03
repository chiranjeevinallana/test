package com.azureiken.bitbeams;

import java.io.File;
import java.util.ArrayList;

import com.azureiken.bitbeams.dao.BitBeamsFile;
import com.azureiken.bitbeams.db.BitBeamsDbOperations;

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
	private static String path;
	private final String FILE_TYPE = "FOLDER";
	private BitBeamsDbOperations dbOperations;
	private ArrayList<String> fileInfo;
	private BitBeamsFile dBFile;
	

	// public interface AddFolderDialogListener {
	// public void onDialogPositiveClick(DialogFragment dialog);
	// public void onDialogNegativeClick(DialogFragment dialog);
	// }
	//
	// AddFolderDialogListener mListener;
	//
	// @Override
	// public void onAttach(Activity activity) {
	// super.onAttach(activity);
	// try {
	// // Instantiate the NoticeDialogListener so we can send events to the
	// // host
	// mListener = (AddFolderDialogListener) activity;
	// } catch (ClassCastException e) {
	// // The activity doesn't implement the interface, throw exception
	// throw new ClassCastException(activity.toString()
	// + " must implement AddFolderDialogListener");
	// }
	// }

	public static AddFolderDialogFragment newInstance(String path1) {
		AddFolderDialogFragment frag = new AddFolderDialogFragment();
//		Bundle args = new Bundle();
//		args.putString("path", path);
//		frag.setArguments(args);
		path = path1;
		return frag;
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
//		path = getArguments().getString("path");
		
		fileInfo = new ArrayList<String>();
		dbOperations = new BitBeamsDbOperations(getActivity().getBaseContext());
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		LayoutInflater inflater = getActivity().getLayoutInflater();
		final View dialogView = inflater.inflate(
				R.layout.activity_new_folder_dialog, null);
		builder.setView(dialogView)
				.setPositiveButton(R.string.createFolder,
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int id) {

								System.out.println("Folder creation started");
								EditText et = (EditText) dialogView
										.findViewById(R.id.folderName);
								String folderName = et.getText().toString();
								dBFile = new BitBeamsFile();
								dBFile.setFileName(folderName);
								dBFile.setFileType(FILE_TYPE);
								dBFile.setFilePath(path + "\\");

								fileInfo.add(dBFile.getFileName());
								fileInfo.add(dBFile.getFileType());
								fileInfo.add(dBFile.getFilePath());

								dbOperations.InsertData(fileInfo);
							}
						})
				.setNegativeButton(R.string.cancel,
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								AddFolderDialogFragment.this.getDialog()
										.cancel();
							}
						});

		return builder.create();
	}

}
