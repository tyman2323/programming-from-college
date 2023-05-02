package com.example.managerversion3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.File;

public class filelistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filelist);
        RecyclerView recyclerView = findViewById(R.id.recylerview);
        TextView nofilestext = findViewById(R.id.nofilestv);
        String path = getIntent().getStringExtra("path");
        File root = new File(path);
        File[] stuff = root.listFiles();
        if(stuff == null || stuff.length == 0){
            nofilestext.setVisibility(View.VISIBLE);
            return;
        }
        nofilestext.setVisibility(View.INVISIBLE);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new adapter(getApplicationContext(),stuff));
    }
}