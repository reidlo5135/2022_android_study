package com.daelim.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.daelim.R;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    private ListViewActivity activity;

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        activity = this;

        listView = findViewById(R.id.listView);

        List<String> list = new ArrayList<>();
        list.add("골든 스테이트");
        list.add("시카고 불스");
        list.add("브루클린 네츠");

        ArrayAdapter<String> adapter = new ArrayAdapter(activity, android.R.layout.simple_expandable_list_item_1, list);
        listView.setAdapter(adapter);
    }
}