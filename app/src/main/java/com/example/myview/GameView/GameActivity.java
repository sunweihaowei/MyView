package com.example.myview.GameView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myview.R;
import com.example.myview.ui.view.GameView;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {
    private GameView gameview = null;
    private Button clear = null;
    private TextView tv30, tv25, tv20, tv15, tv10, tv5, tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        initView();
        initListener();
    }

    private void initView() {
        gameview = (GameView) findViewById(R.id.gameview);
        clear = (Button) findViewById(R.id.btn_clear);
        tv30 = (TextView) findViewById(R.id.tv_30);
        tv25 = (TextView) findViewById(R.id.tv_25);
        tv20 = (TextView) findViewById(R.id.tv_20);
        tv15 = (TextView) findViewById(R.id.tv_15);
        tv10 = (TextView) findViewById(R.id.tv_10);
        tv5 = (TextView) findViewById(R.id.tv_5);
        tv2 = (TextView) findViewById(R.id.tv_2);
    }

    private void initListener() {
// TODO Auto-generated method stub
        clear.setOnClickListener(this);
        tv30.setOnClickListener(this);
        tv25.setOnClickListener(this);
        tv20.setOnClickListener(this);
        tv15.setOnClickListener(this);
        tv10.setOnClickListener(this);
        tv5.setOnClickListener(this);
        tv2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

    }
}