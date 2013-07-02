package com.azureiken.bitbeams.db;

import android.provider.BaseColumns;

public final class BitBeamsContract {
	public BitBeamsContract(){}
	
	public static abstract class BitBeamsEntry implements BaseColumns{
		public static final String TABLE_NAME = "file_entry";
		public static final String COLUMN_NAME_FILE_NAME = "file_name";
        public static final String COLUMN_NAME_FILE_TYPE = "file_type";
        public static final String COLUMN_NAME_FILE_PATH = "file_path";
	}

}
