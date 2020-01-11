package com.manalilatkar.android.dime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.manalilatkar.android.dime.data.ItemContract;
import com.manalilatkar.android.dime.data.ItemDbHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button saveButton = (Button) findViewById(R.id.saveItemButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertItem();
            }
        });
    }

    private void insertItem() {

        ItemDbHelper dbHelper = new ItemDbHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        EditText mNameEditText = (EditText) findViewById(R.id.edit_name);
        EditText locationEditText = (EditText) findViewById(R.id.edit_name);
        EditText attr1EditText = (EditText) findViewById(R.id.edit_name);
        EditText attr2EditText = (EditText) findViewById(R.id.edit_name);
        EditText attr3EditText = (EditText) findViewById(R.id.edit_name);
        EditText attr4EditText = (EditText) findViewById(R.id.edit_name);
        boolean isContainer = findViewById(R.id.checkBox).isSelected();

        String nameString = mNameEditText.getText().toString().trim();
        String location = locationEditText.getText().toString().trim();
        String attr1 = attr1EditText.getText().toString().trim();
        String attr2 = attr2EditText.getText().toString().trim();
        String attr3 = attr3EditText.getText().toString().trim();
        String attr4 = attr4EditText.getText().toString().trim();

        ContentValues cv = new ContentValues();
        cv.put(ItemContract.ItemEntry.COLUMN_ITEM_NAME, nameString);
        cv.put(ItemContract.ItemEntry.COLUMN_LOCATION, location);
        cv.put(ItemContract.ItemEntry.COLUMN_ATTR1, attr1);
        cv.put(ItemContract.ItemEntry.COLUMN_ATTR2, attr2);
        cv.put(ItemContract.ItemEntry.COLUMN_ATTR3, attr3);
        cv.put(ItemContract.ItemEntry.COLUMN_ATTR4, attr4);
        cv.put(ItemContract.ItemEntry.COLUMN_IS_CONTAINER, isContainer);

        long id = db.insert(ItemContract.ItemEntry.TABLE_NAME, null, cv);

        if (id == -1) {
            // If the row ID is -1, then there was an error with insertion.
            Toast.makeText(this, "Error with saving item", Toast.LENGTH_SHORT).show();
        } else {
            // Otherwise, the insertion was successful and we can display a toast with the row ID.
            Toast.makeText(this, "Item saved with row id: " + id, Toast.LENGTH_SHORT).show();
        }



    }
}
