package com.daelim.calculate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.daelim.R;

public class CalActivity extends AppCompatActivity {

    private CalActivity activity;
    private CalculateHelper calculateHelper;

    private boolean isDot;
    private boolean isBracket;

    boolean isPreview;

    private TextView tv_first_txt;
    private TextView tv_second_txt;

    private int size;
    private String result;

    private Button btn_num0;
    private Button btn_num1;
    private Button btn_num2;
    private Button btn_num3;
    private Button btn_num4;
    private Button btn_num5;
    private Button btn_num6;
    private Button btn_num7;
    private Button btn_num8;
    private Button btn_num9;

    private Button btn_add;
    private Button btn_sub;
    private Button btn_mul;
    private Button btn_div;
    private Button btn_clear;
    private Button btn_bracket;
    private Button btn_percent;
    private Button btn_back;
    private Button btn_dot;
    private Button btn_equal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal);
        activity = this;

        calculateHelper = new CalculateHelper();

        size = 0;
        setButton();
        setTextView();
    }

    private void setButton() {
        btn_num0 = findViewById(R.id.btn_num0);
        btn_num1 = findViewById(R.id.btn_num1);
        btn_num2 = findViewById(R.id.btn_num2);
        btn_num3 = findViewById(R.id.btn_num3);
        btn_num4 = findViewById(R.id.btn_num4);
        btn_num5 = findViewById(R.id.btn_num5);
        btn_num6 = findViewById(R.id.btn_num6);
        btn_num7 = findViewById(R.id.btn_num7);
        btn_num8 = findViewById(R.id.btn_num8);
        btn_num9 = findViewById(R.id.btn_num9);

        btn_add = findViewById(R.id.btn_add);
        btn_sub = findViewById(R.id.btn_sub);
        btn_mul = findViewById(R.id.btn_mul);
        btn_div = findViewById(R.id.btn_div);
        btn_clear = findViewById(R.id.btn_clear);
        btn_bracket = findViewById(R.id.btn_bracket);
        btn_percent = findViewById(R.id.btn_percent);
        btn_back = findViewById(R.id.btn_back);
        btn_dot = findViewById(R.id.btn_dot);

        btn_equal = findViewById(R.id.btn_equal);

        btn_num0.setOnClickListener(numClick);
        btn_num1.setOnClickListener(numClick);
        btn_num2.setOnClickListener(numClick);
        btn_num3.setOnClickListener(numClick);
        btn_num4.setOnClickListener(numClick);
        btn_num5.setOnClickListener(numClick);
        btn_num6.setOnClickListener(numClick);
        btn_num7.setOnClickListener(numClick);
        btn_num8.setOnClickListener(numClick);
        btn_num9.setOnClickListener(numClick);

        btn_add.setOnClickListener(markClick);
        btn_sub.setOnClickListener(markClick);
        btn_mul.setOnClickListener(markClick);
        btn_div.setOnClickListener(markClick);
        btn_clear.setOnClickListener(markClick);
        btn_bracket.setOnClickListener(markClick);
        btn_percent.setOnClickListener(markClick);
        btn_back.setOnClickListener(markClick);
        btn_dot.setOnClickListener(markClick);

        btn_equal.setOnClickListener(markClick);
    }

    View.OnClickListener numClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn_num0:
                    tv_first_txt.append("0");
                    break;
                case R.id.btn_num1:
                    tv_first_txt.append("1");
                    break;
                case R.id.btn_num2:
                    tv_first_txt.append("2");
                    break;
                case R.id.btn_num3:
                    tv_first_txt.append("3");
                    break;
                case R.id.btn_num4:
                    tv_first_txt.append("4");
                    break;
                case R.id.btn_num5:
                    tv_first_txt.append("5");
                    break;
                case R.id.btn_num6:
                    tv_first_txt.append("6");
                    break;
                case R.id.btn_num7:
                    tv_first_txt.append("7");
                    break;
                case R.id.btn_num8:
                    tv_first_txt.append("8");
                    break;
                case R.id.btn_num9:
                    tv_first_txt.append("9");
                    break;
            }
            preview();
        }
    };

    View.OnClickListener markClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn_add:
                    tv_first_txt.append(" + ");
                    isPreview = true;
                    break;
                case R.id.btn_sub:
                    tv_first_txt.append(" - ");
                    isPreview = true;
                    break;
                case R.id.btn_mul:
                    tv_first_txt.append(" * ");
                    isPreview = true;
                    break;
                case R.id.btn_div:
                    tv_first_txt.append(" / ");
                    isPreview = true;
                    break;
                case R.id.btn_percent:
                    tv_first_txt.append(" % ");
                    isPreview = true;
                    break;
                case R.id.btn_clear:
                    tv_first_txt.setText("");
                    tv_second_txt.setText("");
                    calculateHelper = new CalculateHelper();
                    isPreview =false;
                    break;
                case R.id.btn_bracket:
                    if(!isBracket) {
                        tv_first_txt.append("(");
                        isBracket = true;
                    } else {
                        tv_first_txt.append(" )");
                        isBracket = false;
                    }
                    isPreview = true;
                    break;
                case R.id.btn_back:
                    size = tv_first_txt.getText().length();
                    if(size != 0)
                        tv_first_txt.setText(tv_first_txt.getText().toString().substring(0, size -1));
                    if(size > 1) {
                        if(calculateHelper.checkNumber(tv_first_txt.getText().toString().substring(size -2)))
                            preview();
                        else {
                            isPreview = false;
                            tv_second_txt.setText("");
                        }
                    }
                    break;
                case R.id.btn_dot:
                    tv_first_txt.append(".");
                    isDot = true;
                    break;
                case R.id.btn_equal:
                    result = tv_first_txt.getText().toString();
                    double r = calculateHelper.process(result);
                    if(!isDot)
                        tv_first_txt.setText(String.valueOf((int) r));
                    else
                        tv_first_txt.setText(String.valueOf(r));

                    tv_second_txt.setText("");
                    isDot = false;
                    isPreview = false;
                    break;
            }
        }
    };

    private void preview(){
        if(isPreview){
            result = tv_first_txt.getText().toString();
            double r = calculateHelper.process(result);

            if(!isDot){
                tv_second_txt.setText(String.valueOf((int)r));
            }else{
                tv_second_txt.setText(String.valueOf(r));
            }
        }
    }

    private void setTextView(){
        tv_first_txt = findViewById(R.id.tv_first_txt);
        tv_second_txt = findViewById(R.id.tv_second_txt);
    }
}