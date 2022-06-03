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

    private Context context;
    private ArrayList<ChatVO> chatData;

    public ChatAdapter(Context context, ArrayList<ChatVO> chatData) {
        this.context = context;
        this.chatData = chatData;
    }

    @Override
    public int getCount() {
        return chatData.size();
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
        convertView = inflater.inflate(R.layout.chat_custom_listview, parent, false);

        TextView nameView = (TextView) convertView.findViewById(R.id.tv_name);
        TextView chatView = (TextView) convertView.findViewById(R.id.tv_chat);

        nameView.setText(chatData.get(i).getId());
        chatView.setText(chatData.get(i).getContent());

        return convertView;
    }
}
