package com.manalilatkar.android.dime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.manalilatkar.android.dime.data.Item;

import java.util.ArrayList;

public class ContainerAdapter extends ArrayAdapter<Item> {
    public ContainerAdapter(@NonNull Context context, ArrayList<Item> items, int resource) {
        super(context, 0, items);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        View listItemView = convertView;


        //Check if the existing view is being used, else inflate the view
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        //Get the Word object located at this position in the list.
        final Item currentItem = getItem(position);

        TextView nameTextView =
                (TextView) listItemView.findViewById(R.id.container_item_name);
        nameTextView.setText(currentItem.getName());

        TextView locationTextView =
                (TextView) listItemView.findViewById(R.id.container_item_location);
        locationTextView.setText(currentItem.getlocation());

        TextView attr1TextView =
                (TextView) listItemView.findViewById(R.id.container_item_attr1);
        attr1TextView.setText(currentItem.getAttr1());

        TextView attr2TextView =
                (TextView) listItemView.findViewById(R.id.container_item_attr2);
        attr2TextView.setText(currentItem.getAttr2());

//     TODO: add photo as background

//        int ImageResourceID = currentWord.getImageResourceID();
//        ImageView imageView = (ImageView) listItemView.findViewById(R.id.photoImgView);
//        if (currentWord.hasImage()){
//
//            imageView.setImageResource(ImageResourceID);
//        }
//        else{
//            imageView.setVisibility(View.GONE);
//        }



        return listItemView;
    }


}
