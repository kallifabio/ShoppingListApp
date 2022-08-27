package de.kallifabio.shoppinglist;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ItemListActivity extends AppCompatActivity implements View.OnClickListener {

    static ArrayList<String> listItem = new ArrayList<>();
    static ArrayList<String> listDescription = new ArrayList<>();
    static ArrayAdapter arrayAdapterItem;
    static ArrayAdapter arrayAdapterDescription;
    ListView lvItemList;

    public static ArrayList<String> getListItem() {
        return listItem;
    }

    public static ArrayList<String> getListDescription() {
        return listDescription;
    }

    public static ArrayAdapter getArrayAdapterItem() {
        return arrayAdapterItem;
    }

    public static ArrayAdapter getArrayAdapterDescription() {
        return arrayAdapterDescription;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itemlist);

        lvItemList = findViewById(R.id.lvItemList);
        arrayAdapterItem = new ArrayAdapter(ItemListActivity.this, android.R.layout.simple_list_item_1, listItem);
        lvItemList.setAdapter(arrayAdapterItem);
    }

    @Override
    public void onClick(View view) {

    }
}