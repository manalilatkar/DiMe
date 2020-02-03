package com.manalilatkar.android.dime.data;

import android.database.Cursor;

import java.util.ArrayList;

public class Item {
    private String name;
    private String attr1;
    private String attr2;
    private String attr3;
    private String attr4;
    private String location;
    private boolean isContainer;
    private boolean isFinalContainer;

    public static ArrayList<Item> getContainerList(Cursor cursor) {
        ArrayList<Item> itemList = new ArrayList<Item>();

        while(cursor.moveToNext()){
            Item item = new Item();
            item.name = cursor.getString(0);
            item.attr1 = cursor.getString(1);
            item.attr2 = cursor.getString(2);
            item.location = cursor.getString(3);
            itemList.add(item);

        }
        return itemList;
    }


    public String getName(){
        return name;
    }

    public String getlocation(){
        return location;
    }

    public String getAttr1(){
        return attr1;
    }

    public String getAttr2(){
        return attr2;
    }


}
