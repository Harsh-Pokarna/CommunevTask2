package com.example.comunevtask2java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView nameRecyclerView;
    private NameAdapter nameAdapter;
    ArrayList<Model> modelArrayList;
    private Button viewInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameRecyclerView = findViewById(R.id.nameRecyclerView);
        viewInfo = findViewById(R.id.viewInfo);
        nameRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        modelArrayList = new ArrayList<>();
        fetchData();
        viewInfo.setOnClickListener(v -> fetchInfo());

    }

    private void fetchInfo() {

        RequestQueue mQueue = Volley.newRequestQueue(this);
        String url = "https://randomuser.me/api/?results=100&inc=name";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                url, null, response -> {
            try {
                JSONObject jsonObject1 = response.getJSONObject("info");
                String seed = jsonObject1.getString("seed");
                int results = jsonObject1.getInt("results");
                int page = jsonObject1.getInt("page");
                String  version = jsonObject1.getString("version");
                Intent intent = new Intent(MainActivity.this, InfoActivity.class);
                intent.putExtra("seed", seed);
                intent.putExtra("results", results);
                intent.putExtra("page", page);
                intent.putExtra("version", version);
                startActivity(intent);

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }, error -> {

        });
        mQueue.add(jsonObjectRequest);

    }

    private void fetchData() {
        RequestQueue mQueue = Volley.newRequestQueue(this);
        String url = "https://randomuser.me/api/?results=100&inc=name";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                url, null, response -> {
                    try {
                        JSONArray jsonArray = response.getJSONArray("results");
                        for (int i=0; i<jsonArray.length(); i++){
                            JSONObject object = jsonArray.getJSONObject(i);
                            JSONObject finalObject = object.getJSONObject("name");

                            String title = finalObject.getString("title");
                            String firstName = finalObject.getString("first");
                            String lastName = finalObject.getString("last");

                            modelArrayList.add(new Model(title, firstName, lastName));
                        }
                        nameAdapter = new NameAdapter(MainActivity.this, modelArrayList);
                        nameRecyclerView.setAdapter(nameAdapter);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }, error -> {

                });
        mQueue.add(jsonObjectRequest);
    }
}