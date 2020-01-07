package com.manalilatkar.android.dime.data;

import android.provider.BaseColumns;

public class ItemContract {
    private ItemContract(){}

    public static final class ItemEntry implements BaseColumns{

        public final static String TABLE_NAME = "Items";
        public final static String _ID = BaseColumns._ID;

        public final static String COLUMN_ITEM_NAME = "Name";
        public final static String COLUMN_ATTR1 = "Attribute1";
        public final static String COLUMN_ATTR2 = "Attribute2";
        public final static String COLUMN_ATTR3 = "Attribute3";
        public final static String COLUMN_ATTR4 = "Attribute4";

        public final static String COLUMN_IS_CONTAINER = "IsContainer";
        public final static String COLUMN_LOCATION = "Location";
        public final static String COLUMN_PHOTO = "Photo";
        public final static String COLUMN_IS_FINAL_CONTAINER = "IsFinalContainer";



    }
}
