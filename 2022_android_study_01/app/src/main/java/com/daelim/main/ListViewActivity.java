package com.daelim.main;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.daelim.R;
import com.daelim.data.ListData;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    private ListViewActivity activity;

    private ListView listView;

    private List<ListData> list = new ArrayList<ListData>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        activity = this;

        listView = findViewById(R.id.listView);

        list.add(new ListData(1L, getDrawable(R.drawable.gs), "골든 스테이트 워리어스"));
        list.add(new ListData(2L, getDrawable(R.drawable.bulls), "시카고 불스"));
        list.add(new ListData(3L, getDrawable(R.drawable.bnets), "브루클린 네츠"));

        ArrayAdapter<String> adapter = new ArrayAdapter(activity, android.R.layout.simple_expandable_list_item_1, list);
        listView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public Object getItem(int i) {
                return list.get(i);
            }

            @Override
            public long getItemId(int i) {
                return i;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                final int pos = position;
                final Context context = parent.getContext();

                if (convertView == null) {
                    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    convertView = inflater.inflate(R.layout.custom_list_view_layout, parent, false);
                }

                ImageView iconImageView = (ImageView) convertView.findViewById(R.id.img_team) ;
                TextView titleTextView = (TextView) convertView.findViewById(R.id.tv_name) ;

                ListData listData = list.get(position);

                iconImageView.setImageDrawable(listData.getIcon());
                titleTextView.setText(listData.getTeam());

                return convertView;
            }
        });
    }
}