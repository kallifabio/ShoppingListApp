package de.kallifabio.shoppinglist;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;


public class MainActivity extends AppCompatActivity {

    static ArrayList<String> listList = new ArrayList<>();
    static ArrayAdapter arrayAdapterList;
    ListView lvList;
    Button btnAddItem, btnCreateList;
    String url1 = "https://familienfotoswebsite.de/Home/insertListData.php";
    String url2 = "https://familienfotoswebsite.de/Home/readListData.php";

    public static String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date today = Calendar.getInstance().getTime();
        return dateFormat.format(today);
    }

    @Override
    protected void onStop() {
        super.onStop();
        //FirebaseAuth.getInstance().signOut();
    }

    /*@Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnAddItem:

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
    }*/

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

        //arrayAdapterList = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, listList);
        lvList = findViewById(R.id.lvList);
        lvList.setAdapter(arrayAdapterList);

        btnAddItem = findViewById(R.id.btnAddItem);
        btnCreateList = findViewById(R.id.btnCreateList);

        btnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddItemActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnCreateList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = "Einkauf vom ";
                String created_username = "Test";
                class SendPostReqAsyncTask extends AsyncTask<String, Void, String> {
                    @Override
                    protected String doInBackground(String... params) {
                        String name = "Einkauf vom ";
                        String created_username = "Test";

                        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();

                        nameValuePairs.add(new BasicNameValuePair("name", name));
                        nameValuePairs.add(new BasicNameValuePair("created_username", created_username));

                        try {
                            HttpClient httpClient = new DefaultHttpClient();
                            HttpPost httpPost = new HttpPost(url1);
                            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                            HttpResponse httpResponse = httpClient.execute(httpPost);
                            HttpEntity httpEntity = httpResponse.getEntity();
                        } catch (ClientProtocolException e) {
                        } catch (IOException e) {
                        }
                        return "Data Inserted Successfully";
                    }

                    @Override
                    protected void onPostExecute(String result) {
                        super.onPostExecute(result);
                        Toast.makeText(MainActivity.this, "Data Submit Successfully", Toast.LENGTH_LONG).show();
                    }
                }

                SendPostReqAsyncTask sendPostReqAsyncTask = new SendPostReqAsyncTask();
                sendPostReqAsyncTask.execute(name, created_username);
            }
        });
    }
}