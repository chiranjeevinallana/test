package com.azureiken.bitbeams.db;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.azureiken.bitbeams.db.BitBeamsContract.BitBeamsEntry;

public class BitBeamsDbOperations {
	private BitBeamsDbHealper dbHealper;
	private SQLiteDatabase db; 
	public BitBeamsDbOperations(Context context) {
		// TODO Auto-generated constructor stub
		dbHealper = new BitBeamsDbHealper(context);
		db = dbHealper.getWritableDatabase();
	}
	public void InsertData(ArrayList<String> file){
		
		ContentValues values = new ContentValues();
		values.put(BitBeamsEntry.COLUMN_NAME_FILE_NAME, file.get(0));
		values.put(BitBeamsEntry.COLUMN_NAME_FILE_TYPE, file.get(1));
		values.put(BitBeamsEntry.COLUMN_NAME_FILE_PATH, file.get(2));
		
		long newRowId;
		newRowId = db.insert(BitBeamsEntry.TABLE_NAME,null,values);
		System.out.println("Row id is :"+ newRowId);
	}
	public ArrayList<String> getFolder(){
		String[] projection = {BitBeamsEntry._ID, BitBeamsEntry.COLUMN_NAME_FILE_NAME, 
				BitBeamsEntry.COLUMN_NAME_FILE_TYPE, BitBeamsEntry.COLUMN_NAME_FILE_PATH};
		String shortOrder = BitBeamsEntry._ID+" ASC";
//		Cursor c = db.query(BitBeamsEntry.TABLE_NAME, projection, null, null, null, null, shortOrder);
		Cursor c = db.rawQuery("Select * from "+BitBeamsEntry.TABLE_NAME+";",null);
		ArrayList<String> folders = new ArrayList<String>();
		c.moveToFirst();
		while(!c.isAfterLast()){
			folders.add(c.getString(1));
			c.moveToNext();
		}
		return folders;
	}
	
	
	
}
