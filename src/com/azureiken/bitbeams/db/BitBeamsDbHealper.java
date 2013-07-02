package com.azureiken.bitbeams.db;

import com.azureiken.bitbeams.db.BitBeamsContract.BitBeamsEntry;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BitBeamsDbHealper extends SQLiteOpenHelper{
	private static final String TEXT_TYPE = " TEXT";
	private static final String COMMA_SEP = ",";
	private static final String SQL_CREATE_ENTRIES =
			"CREATE TABLE "+BitBeamsEntry.TABLE_NAME+" ("+
			BitBeamsEntry._ID+ " INTEGER PRIMARY KEY,"+
			BitBeamsEntry.COLUMN_NAME_FILE_NAME + TEXT_TYPE + COMMA_SEP +
			BitBeamsEntry.COLUMN_NAME_FILE_TYPE + TEXT_TYPE + COMMA_SEP + 
			BitBeamsEntry.COLUMN_NAME_FILE_PATH + TEXT_TYPE + " )";
	
	private static final String SQL_DELETE_ENTRIES =
		    "DROP TABLE IF EXISTS " + BitBeamsEntry.TABLE_NAME;
	
	public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "BitBeams.db";
    
    public BitBeamsDbHealper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(SQL_CREATE_ENTRIES);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		 db.execSQL(SQL_DELETE_ENTRIES);
	        onCreate(db);
		
	}

}
