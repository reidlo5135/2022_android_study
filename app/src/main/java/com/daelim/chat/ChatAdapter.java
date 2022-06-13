package com.daelim.chat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.daelim.R;

import java.util.ArrayList;


public class ChatAdapter extends BaseAdapter {
    private final int NOT_ME = 0;
    private final int IS_ME = 1;
    private final int NOTICE_LOGIN = 2;

    private Context context;
    private ArrayList<ChatVO> chatData;

    private TextView nameView;
    private TextView chatView;
    private TextView loginView;

    public ChatAdapter(Context context, ArrayList<ChatVO> chatData) {
        this.context = context;
        this.chatData = chatData;
    }

    @Override
    public int getCount() {
        return chatData.size();
    }

    @Override
    public int getItemViewType(int position) {
        return chatData.get(position).getType();
    }

    @Override
    public int getViewTypeCount() {
        return NOTICE_LOGIN + 1;
    }

    @Override
    public Object getItem(int position) {
        return chatData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        int viewType = getItemViewType(i);

        switch (viewType) {
            case NOT_ME:
                convertView = inflater.inflate(R.layout.chat_custom_listview, parent, false);

                nameView = (TextView) convertView.findViewById(R.id.tv_name);
                chatView = (TextView) convertView.findViewById(R.id.tv_chat);

                nameView.setText(chatData.get(i).getId());
                chatView.setText(chatData.get(i).getContent());
                break;
            case IS_ME:
                convertView = inflater.inflate(R.layout.chat_not_me, parent, false);

                nameView = (TextView) convertView.findViewById(R.id.tv_name);
                chatView = (TextView) convertView.findViewById(R.id.tv_chat);

                nameView.setText(chatData.get(i).getId());
                chatView.setText(chatData.get(i).getContent());
                break;
            case NOTICE_LOGIN:
                convertView = inflater.inflate(R.layout.chat_notice_login, parent, false);

                loginView = (TextView) convertView.findViewById(R.id.tv_login);
                loginView.setText(chatData.get(i).getId() + "님이 입장하셨습니다!");
                break;
        }

        return convertView;
    }
}
