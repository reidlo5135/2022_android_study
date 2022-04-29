package com.daelim.main;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.daelim.R;
import com.daelim.calculate.CalActivity;
import com.daelim.dialog.SharedPreferenceActivity;
import com.daelim.research.ResearchActivity;
import com.daelim.web.WebActivity;

public class InitActivity extends AppCompatActivity {

    private InitActivity activity;

    public static final int REQUEST_CODE = 100;

    private TextView tv_data;

    private Button btn_cal;
    private Button btn_next;
    private Button btn_survey;
    private Button btn_list;
    private Button btn_shared;
    private Button btn_call;
    private Button btn_email;
    private Button btn_web;

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn_cal:
                    startActivity(new Intent(activity, CalActivity.class));
                    break;
                case R.id.btn_next:
                    Intent it = new Intent(activity, NextActivity.class);
                    startActivityForResult(it, 0);
                    break;
                case R.id.btn_survey:
                    Intent it2 = new Intent(activity, ResearchActivity.class);
                    startActivity(it2);
                    break;
                case R.id.btn_list:
                    Intent it3 = new Intent(activity, ListViewActivity.class);
                    startActivity(it3);
                    break;
                case R.id.btn_shared:
                    Intent it4 = new Intent(activity, SharedPreferenceActivity.class);
                    startActivity(it4);
                    break;
                case R.id.btn_call:
                    Intent it5 = new Intent(Intent.ACTION_DIAL);
                    it5.setData(Uri.parse("tel:01048542023"));
                    startActivity(it5);
                    break;
                case R.id.btn_email:
                    Intent it6 = new Intent(Intent.ACTION_VIEW);
                    it6.setData(Uri.parse("http://www.naver.com"));
                    startActivity(it6);
                    break;
                case R.id.btn_web:
                    Intent it7 = new Intent(activity, WebActivity.class);
                    startActivity(it7);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init);

        activity = this;

        btn_cal = findViewById(R.id.btn_cal);
        btn_cal.setOnClickListener(click);

        btn_next = findViewById(R.id.btn_next);
        btn_next.setOnClickListener(click);

        btn_survey = findViewById(R.id.btn_survey);
        btn_survey.setOnClickListener(click);

        btn_list = findViewById(R.id.btn_list);
        btn_list.setOnClickListener(click);

        btn_shared = findViewById(R.id.btn_shared);
        btn_shared.setOnClickListener(click);

        btn_call = findViewById(R.id.btn_call);
        btn_call.setOnClickListener(click);

        btn_email = findViewById(R.id.btn_email);
        btn_email.setOnClickListener(click);

        btn_web = findViewById(R.id.btn_web);
        btn_web.setOnClickListener(click);

        tv_data = findViewById(R.id.tv_data);
        Intent intent = new Intent();
        String str = intent.getStringExtra("data");
        tv_data.setText(str);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String str = data.getStringExtra("data");
        System.out.println(str);
        System.out.println("1212");
        if (requestCode == REQUEST_CODE) {
            if (resultCode != Activity.RESULT_OK) {
                return;
            }
            finish();
        }
        tv_data.setText(str);
    }
}