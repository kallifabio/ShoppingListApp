package de.kallifabio.shoppinglist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    static ArrayList<String> listList = new ArrayList<>();
    static ArrayAdapter arrayAdapterList;
    ListView lvList;
    Button btnAddItem, btnCreateList;
    FirebaseAuth auth = FirebaseAuth.getInstance();
    String email = "";
    String password = "";

    public static String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date today = Calendar.getInstance().getTime();
        return dateFormat.format(today);
    }

    public static ArrayList<String> getListList() {
        return listList;
    }

    public static ArrayAdapter getArrayAdapterList() {
        return arrayAdapterList;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayAdapterList = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, listList);
        lvList = findViewById(R.id.lvList);
        lvList.setAdapter(arrayAdapterList);

        btnAddItem = findViewById(R.id.btnAddItem);
        btnCreateList = findViewById(R.id.btnCreateList);

        btnAddItem.setOnClickListener(this);
        btnCreateList.setOnClickListener(this);
        lvList.setOnItemClickListener(this);

        /*FirebaseUser user = auth.getCurrentUser();
        if (user != null) {
            recreate();
        }

        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {

                }
            }
        });*/

    }

    @Override
    protected void onStop() {
        super.onStop();
        //FirebaseAuth.getInstance().signOut();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnAddItem:
                Intent intent = new Intent(MainActivity.this, AddItemActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.btnCreateList:
                if (listList.contains("Einkauf vom " + getCurrentDate())) {
                    Toast.makeText(getApplicationContext(), "Eine Liste von heute existiert bereits", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Liste wurde erstellt", Toast.LENGTH_LONG).show();
                    listList.add("Einkauf vom " + getCurrentDate());
                    arrayAdapterList.notifyDataSetChanged();
                }
                break;
        }
    }

    public void onItemClick(AdapterView<?> l, View v, int position, long id) {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}