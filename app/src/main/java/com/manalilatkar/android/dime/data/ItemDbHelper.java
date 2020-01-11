package com.manalilatkar.android.dime.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ItemDbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Items.db";

    public ItemDbHelper(Context context){
    super(context, DATABASE_NAME, null, DATABASE_VERSION);

}

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String SQL_CREATE_ITEMS_TABLE = " CREATE TABLE " + ItemContract.ItemEntry.TABLE_NAME + " (" +
                ItemContract.ItemEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ItemContract.ItemEntry.COLUMN_ITEM_NAME + " TEXT, "
                + ItemContract.ItemEntry.COLUMN_ATTR1 + " TEXT, "
                + ItemContract.ItemEntry.COLUMN_ATTR2 + " TEXT, "
                + ItemContract.ItemEntry.COLUMN_ATTR3 + " TEXT, "
                + ItemContract.ItemEntry.COLUMN_ATTR4 + " TEXT, "
                + ItemContract.ItemEntry.COLUMN_LOCATION + " TEXT, "
                + ItemContract.ItemEntry.COLUMN_IS_CONTAINER + " BOOLEAN NOT NULL, "
                + ItemContract.ItemEntry.COLUMN_PHOTO + " TEXT, "
                + ItemContract.ItemEntry.COLUMN_IS_FINAL_CONTAINER + " BOOLEAN );";

        Log.v("Look here......", SQL_CREATE_ITEMS_TABLE);

        try {
            sqLiteDatabase.execSQL(SQL_CREATE_ITEMS_TABLE);
            Log.v("ItemDbHelper class", "table was created here.");
        }
        catch (Exception ex){
            Log.e("Exception here", ex.getMessage());
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void getDatabase() {

    }
}

