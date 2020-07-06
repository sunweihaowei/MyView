package com.example.myview;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myview.ui.view.InputNumberView;
//后台保活
public class MainActivity extends AppCompatActivity implements InputNumberView.OnNumberChangeListener {

    private static final String TAG = "MainActivity";
    private InputNumberView myView_inv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*initView();
        myView_inv.setOnNumberChangeListener(this);
        InputNumberView inputNumberView=new InputNumberView(this);*/
    }

//    private void initView() {
//        myView_inv = (InputNumberView) findViewById(R.id.MyView_inv);
//    }

    @Override
    public void onNumberChange(int value) {
        Log.d(TAG, "onNumberChange: "+value);
    }
}
