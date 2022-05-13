package com.daelim.dialog;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.daelim.R;

public class SharedPreferenceActivity extends AppCompatActivity {

    private SharedPreferenceActivity activity;

    private EditText et_value;
    private Button btn_save;
    private Button btn_check_value;
    private AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference);

        activity = this;

        et_value = findViewById(R.id.et_value);
        btn_save = findViewById(R.id.btn_save);
        btn_check_value = findViewById(R.id.btn_check_value);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PreferencesManager.setString(activity, "et_text", et_value.getText().toString());
                String text = PreferencesManager.getString(activity, "et_text");
                System.out.println("et_text SAVE : " + text);
                if (text.equals("") || text == null) {
                    setDialog("ALERT", "값을 입력해주세요.");
                } else {
                    setDialog("SUCCESS", "값이 저장되었습니다.");
                }
            }
        });

        btn_check_value.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = PreferencesManager.getString(activity,"et_text");
                System.out.println("et_text : " + text);
                if (text.equals("") || text == null) {
                    setDialog("ALERT", "값을 입력해주세요.");
                } else {
                    setDialog("SUCCESS", "입력하신 값은 " + text + " 입니다.");
                }
            }
        });

    }

    private void setDialog(String title, String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(title).setMessage(msg);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                return;
            }
        });
        alertDialog = builder.create();
        alertDialog.show();
    }
}