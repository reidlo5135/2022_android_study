package com.daelim.web;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.daelim.R;

public class WebActivity extends AppCompatActivity {

    private WebActivity activity;

    private WebView wv_main;

    private EditText et_url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        activity = this;

        wv_main = findViewById(R.id.wv_main);
        wv_main.setWebViewClient(new WebViewClientClass());
        wv_main.getSettings().setJavaScriptEnabled(true);

        et_url = findViewById(R.id.et_url);
        et_url.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if(i == EditorInfo.IME_ACTION_SEARCH){
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(textView.getWindowToken(),0);

                    String url = et_url.getText().toString();
                    System.out.println("URL : " + url);
                    wv_main.loadUrl(url);
                    et_url.setText("");
                    return true;
                }
                return false;
            }
        });
    }

    private class WebViewClientClass extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}