package com.daelim.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.daelim.R;

public class NextActivity extends AppCompatActivity {

    private NextActivity activity;

    private Intent intent = new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        activity = this;

        TextView tv_value = findViewById(R.id.tv_value);

        Button prev = findViewById(R.id.btn_prev);
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("data", "00000");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        intent.putExtra("data", "12345");
        setResult(RESULT_OK, intent);
        finish();
        super.onBackPressed();
    }
}