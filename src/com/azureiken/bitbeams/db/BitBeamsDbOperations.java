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
		values.put(BitBeamsEntry.COLUMN_NAME_FILE_PATH, file.get(2)+"\\");
		
		long newRowId;
		newRowId = db.insert(BitBeamsEntry.TABLE_NAME,null,values);
		System.out.println("Row id is :"+ newRowId);
	}
	public ArrayList<String> getFolder(String path){

		String query = "Select * from "+BitBeamsEntry.TABLE_NAME+" where "+BitBeamsEntry.COLUMN_NAME_FILE_PATH+"='"+path+"\\';";
		System.out.println("query is "+query);
		Cursor c = db.rawQuery(query,null);
		ArrayList<String> folders = new ArrayList<String>();
		c.moveToFirst();
		while(!c.isAfterLast()){
			folders.add(c.getString(1));
			c.moveToNext();
		}
		c.close();
		return folders;
	}
	
	public void closeConnection(){
		db.close();
	}
	
	
	
}
