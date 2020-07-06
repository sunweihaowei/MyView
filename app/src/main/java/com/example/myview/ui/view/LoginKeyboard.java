package com.example.myview.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.myview.R;

import java.util.zip.Inflater;

/**
 * @ClassName LoginKeyboard
 * @Description TODO
 * @Author ${孙伟豪}
 * @Date 2020/6/8 10:06
 * @Version 1.0
 */
class LoginKeyboard extends LinearLayout {
    private static final String TAG = "LoginKeyboard";

    public LoginKeyboard(Context context) {
        this(context,null);
    }
/*基础知识*/
    public LoginKeyboard(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public LoginKeyboard(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.num_key_pad,this,true);
        //问题加载不出来，background与android：background搞混了
        for (int i=0;i<getChildCount();i++){
            getChildAt(i).setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    CharSequence text=((TextView)v).getText();
                    Log.d(TAG, "onClick: "+text);
                }
            });
        }
    }
}
