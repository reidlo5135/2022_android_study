package com.daelim.user;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.daelim.R;
import com.daelim.chat.ChatActivity;
import com.daelim.utils.PreferencesManager;

import org.java_websocket.client.WebSocketClient;

public class LoginActivity extends AppCompatActivity {

    LoginActivity activity;

    private EditText et_id;
    private EditText et_pw;
    private Button btn_login;

    private AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        activity = this;

        et_id = findViewById(R.id.et_id);
        et_pw = findViewById(R.id.et_pw);

        btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, ChatActivity.class);

                PreferencesManager.setString(activity, "et_id", et_id.getText().toString());
                PreferencesManager.setString(activity, "et_pw", et_pw.getText().toString());

                String id = PreferencesManager.getString(activity, "et_id");
                String pw = PreferencesManager.getString(activity, "et_pw");

                Log.e("! ", "id : " + id);
                Log.e("! ", "pw : " + pw);

                if(id == null || pw == null) {
                    setDialog("ALERT", "아이디와 비밀번호를 입력해주세요.");
                } else {
                    setDialog("WELCOME", id + "님 환영합니다!");
                    startActivity(intent);
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