package com.daelim.main;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.daelim.R;

public class ResultActivity extends AppCompatActivity {

    private ResultActivity activity;

    private TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        activity = this;

        tv_result = findViewById(R.id.tv_result);
        Intent intent = getIntent();
        String[] favArr = intent.getStringArrayExtra("fav");
        String result = null;
        for(int i=0;i<favArr.length;i++) {
            result += favArr[i];
        }
        tv_result.setText(result);
    }
}