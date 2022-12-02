package de.kallifabio.shoppinglist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AddItemActivity extends AppCompatActivity implements View.OnClickListener {

    static ArrayAdapter arrayAdapterDropdown;
    TextView tvItemName, tvItemDescription, tvDropdownList;
    EditText etItemName, etItemDescription;
    Button btnSubmitItem, btnCancel;
    Spinner dropdownList;

    public static ArrayAdapter getArrayAdapterDropdown() {
        return arrayAdapterDropdown;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entryitem);

        btnSubmitItem = findViewById(R.id.btnSubmitItem);
        etItemName = findViewById(R.id.etItemName);
        etItemDescription = findViewById(R.id.etItemDescription);
        dropdownList = findViewById(R.id.dropdownList);
        btnCancel = findViewById(R.id.btnCancel);

        btnSubmitItem.setOnClickListener(this);
        btnCancel.setOnClickListener(this);

        //String[] dropdownItems = new String[]{MainActivity.getListList().toString()}; //später hier die ganzen Listen (Einkaufslisten), die erstellt und abgespeichert wurden, übergeben
        //arrayAdapterDropdown = new ArrayAdapter(AddItemActivity.this, android.R.layout.simple_spinner_dropdown_item, dropdownItems);
        dropdownList.setAdapter(arrayAdapterDropdown);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSubmitItem:
                /*if (etItemName.getText().toString().trim().isEmpty() || MainActivity.getListList().isEmpty() || etItemName.getText().toString().trim().isEmpty() && MainActivity.getListList().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Artikel und Liste wurde nicht angegeben", Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(AddItemActivity.this, MainActivity.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "Der Artikel wurde der Liste hinzugefügt", Toast.LENGTH_LONG).show();
                    finish();
                    ItemListActivity.getListItem().add(etItemName.getText().toString().trim());
                    ItemListActivity.getListDescription().add(etItemDescription.getText().toString().trim());
                    ItemListActivity.getArrayAdapterItem().notifyDataSetChanged();
                }*/
                break;
            case R.id.btnCancel:
                Intent intent = new Intent(AddItemActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}