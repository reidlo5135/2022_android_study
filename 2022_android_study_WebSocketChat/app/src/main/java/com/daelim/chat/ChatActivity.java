package com.daelim.chat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.daelim.R;
import com.daelim.user.LoginActivity;
import com.daelim.utils.PreferencesManager;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ChatActivity extends AppCompatActivity {

    ChatActivity activity;
    ChatAdapter adapter;

    static WebSocketClient ws;

    ArrayList<ChatVO> list = new ArrayList<>();

    private EditText et_chat;
    private Button btn_send;
    private ListView lv_chat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        activity = this;

        String id = PreferencesManager.getString(activity, "et_id");
        String pw = PreferencesManager.getString(activity, "et_pw");

        et_chat = findViewById(R.id.et_chat);
        btn_send = findViewById(R.id.btn_send);
        lv_chat = findViewById(R.id.lv_chat);

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ws.send("CHAT|" + id + "|" + et_chat.getText().toString());
                et_chat.setText("");
            }
        });

        adapter = new ChatAdapter(activity, list);
        lv_chat.setAdapter(adapter);

        Log.e("!!! ", "id : " + id);
        Log.e("!!! ", "pw : " + pw);

        try {
            ws = new WebSocketClient(new URI("ws://61.83.168.88:4877")) {

                @Override
                public void onOpen(ServerHandshake serverHandshake) {
                    Log.e("!!!", "onOpen");
                    ws.send("LOGIN|" + id);
                }

                @Override
                public void onMessage(String s) {
                    Log.e("!!!", "onMessage s : " + s);
                    String[] str = s.split("\\|");
                    Log.e("!!!", "onMessage str : " + str[0]);

                    if(str[0].equals("LOGIN")) {
                        Log.e("!!!", "onMessage LOGIN MODE");
                        list.add(new ChatVO(2, str[1]));
                    } else if(str[0].equals("CHAT")) {
                        if(str[1].equals(id)){
                            list.add(new ChatVO(1, str[1], str[2]));
                        } else {
                            list.add(new ChatVO(0, str[1], str[2]));
                        }
                        Log.e("!!!", "onMessage list : " + list);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                adapter.notifyDataSetChanged();
                            }
                        });
                    } else if(str[0].equals("LOGOUT")) {
                        Intent intent = new Intent(activity, LoginActivity.class);
                        startActivity(intent);
                    }
                }

                @Override
                public void onClose(int i, String s, boolean b) {
                    Log.e("!!!", "onClose s : " + s);
                }

                @Override
                public void onError(Exception e) {
                    Log.e("!!!", "onError");
                    e.printStackTrace();
                }
            };
            ws.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}