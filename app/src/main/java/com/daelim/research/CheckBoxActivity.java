package com.daelim.research;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;

import com.daelim.R;
import com.daelim.main.ResultActivity;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CheckBoxActivity extends AppCompatActivity {

    private CheckBoxActivity activity;

    private CheckBox[] checkBoxes = new CheckBox[5];
    private ImageView img_team;
    private Button btn_submit;

    private String[] gs = {"스테픈 커리", "클레이 탐슨", "조던 풀", "드레이먼드 그린", "케본 루니"};
    private String[] bulls = {"론조 볼", "잭 라빈", "알렉스 카루소", "더마 드로잔", "니콜라 부세비치"};
    private String[] bnets = {"카이리 어빙", "세스 커리", "케빈 듀란트", "라마커스 알드리지", "안드레 드러먼드"};

    Map<String, String[]> playerMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);

        activity = this;

        Intent intent = getIntent();
        String team = intent.getStringExtra("team");
        System.out.println("team : " + team);

        img_team = findViewById(R.id.img_team);

        checkBoxes[0] = findViewById(R.id.ch_player1);
        checkBoxes[1] = findViewById(R.id.ch_player2);
        checkBoxes[2] = findViewById(R.id.ch_player3);
        checkBoxes[3] = findViewById(R.id.ch_player4);
        checkBoxes[4] = findViewById(R.id.ch_player5);

        for(int i = 0;i<checkBoxes.length;i++) {
            if(team.equals("gs") || team == null) {
                playerMap.put("gs", gs);
                img_team.setImageResource(R.drawable.gs);
            } else if(team.equals("bulls") && team != null) {
                playerMap.put("bulls", bulls);
                img_team.setImageResource(R.drawable.bulls);
            } else {
                playerMap.put("bnets", bnets);
                img_team.setImageResource(R.drawable.bnets);
            }

            String players = Arrays.toString(playerMap.get(team));
            System.out.println("players01 : " + players);

            if(players.indexOf("[") > -1 || players.indexOf("[") > -1) {
                players = players.replaceAll("\\[", "");
                players = players.replaceAll("\\]", "");
            }

            String[] split = players.split(",");
            checkBoxes[i].setText(split[i]);

            System.out.println("players : " + players);
            System.out.println("split : " + split[i]);
        }

        btn_submit = findViewById(R.id.btn_submit);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(activity, ResultActivity.class);
                startActivity(intent1);
            }
        });
    }
}