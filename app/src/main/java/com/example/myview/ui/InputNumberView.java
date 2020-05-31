package com.example.myview.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.myview.R;

/**
 * @author sunweihao
 * @description:自定义加减
 * @date :2020/6/1 7:06
 */
public class InputNumberView extends RelativeLayout {
    public InputNumberView(Context context) {
        this(context,null);
    }

    public InputNumberView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public InputNumberView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //前面的修改都会导致都执行这个方法
        //以下三种代码等价
        LayoutInflater.from(context).inflate(R.layout.input_number_view,this,true);

//        LayoutInflater.from(context).inflate(R.layout.input_number_view,this);

//        View view = LayoutInflater.from(context).inflate(R.layout.input_number_view, this, false);
//        addView(view);
    }
}
