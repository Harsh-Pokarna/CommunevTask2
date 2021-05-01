package com.example.comunevtask2java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {
    String seed, version;
    int page, results;
    TextView seedView, versionView, pageView, resultsView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        seed = getIntent().getStringExtra("seed");
        version = getIntent().getStringExtra("version");
        page = getIntent().getIntExtra("page", 1);
        results = getIntent().getIntExtra("version", 100);
        seedView = findViewById(R.id.seedView);
        versionView = findViewById(R.id.versionView);
        pageView = findViewById(R.id.pageView);
        resultsView = findViewById(R.id.resultsView);
        seedView.setText(seed);
        versionView.setText(version);
        pageView.setText(String.valueOf(page));
        resultsView.setText(String.valueOf(results));
    }
}