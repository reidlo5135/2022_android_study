package com.daelim.research;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.daelim.R;

public class ResearchActivity extends AppCompatActivity {

    private ResearchActivity activity;

    private RadioGroup rd_group;
    private ImageView img_survey;
    private Button btn_next;

    private String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_research);

        activity = this;

        rd_group = findViewById(R.id.rd_group);
        img_survey = findViewById(R.id.img_survey);

        rd_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == R.id.rd_gs) {
                    img_survey.setImageResource(R.drawable.gs);
                    result = "gs";
                }else if(i == R.id.rd_bulls) {
                    img_survey.setImageResource(R.drawable.bulls);
                    result = "bulls";
                }else if(i == R.id.rd_bnets) {
                    img_survey.setImageResource(R.drawable.bnets);
                    result = "bnets";
                }
            }
        });

        btn_next = findViewById(R.id.btn_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(activity, CheckBoxActivity.class);
                it.putExtra("team", result);
                System.out.println(result);
                startActivity(it);
            }
        });

    }
}