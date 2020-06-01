package com.example.myview.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.myview.R;

/**
 * @author sunweihao
 * @description:自定义加减
 * @date :2020/6/1 7:06
 */
public class InputNumberView extends RelativeLayout {
    private int mCurrentNumber = 0;//这里是默认为0
    private TextView mMinusTv;
    private EditText mValueEdt;
    private TextView mPlusTv;
    private View inflate;

    public InputNumberView(Context context) {
        this(context, null);
    }

    public InputNumberView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public InputNumberView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
        //设置事件
        setUpEvent();
        //

    }



    private void initView(Context context) {
        //前面的修改都会导致都执行这个方法
        //以下三种代码等价
        inflate = LayoutInflater.from(context).inflate(R.layout.input_number_view, this, true);
        mMinusTv = inflate.findViewById(R.id.minus_tv);
        mValueEdt = inflate.findViewById(R.id.value_edt);
        mPlusTv = inflate.findViewById(R.id.plus_tv);

//        LayoutInflater.from(context).inflate(R.layout.input_number_view,this);

//        View view = LayoutInflater.from(context).inflate(R.layout.input_number_view, this, false);
//        addView(view);
    }
    private void setUpEvent() {
        mMinusTv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentNumber--;
                updateText();
            }
        });
        mPlusTv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentNumber++;
                updateText();
            }
        });
    }
    public int getCurrentNumber() {
        return mCurrentNumber;
    }

    public void setCurrentNumber(int value) {
        this.mCurrentNumber = value;
        this.updateText();
    }

    private void updateText() {
        mValueEdt.setText(String.valueOf(mCurrentNumber));
    }
}
