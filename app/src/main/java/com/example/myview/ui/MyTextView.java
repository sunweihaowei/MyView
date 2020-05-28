package com.example.myview.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class MyTextView extends View {
    /**
     * 这里是重写方法与方法在什么时候被使用
     */
    //new 的时候调用
    public MyTextView(Context context) {
        super(context);
    }
    //<Text/>的时候调用
    public MyTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    //<style/>的时候用
    public MyTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 这里是得到布局的宽高
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int atMost = MeasureSpec.AT_MOST;//wrap_content
        int exactly = MeasureSpec.EXACTLY;//match_parent
        int unspecified = MeasureSpec.UNSPECIFIED;//尽可能的大，ListView，scrollView
    }

}
