package com.example.viewgroup;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

//生命周期
public class MyViewLifeSycle extends ViewGroup {
    /**1.
     * 这里是构造函数
     * @param context
     */
    public MyViewLifeSycle(Context context) {
        this(context,null);
    }

    public MyViewLifeSycle(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyViewLifeSycle(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 2.测量View的大小
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //度量孩子的大小
        int childCount = getChildCount();//得到孩子的个数
        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);//得到i个view
            childView.measure(widthMeasureSpec,heightMeasureSpec);//对i个View进行测量

        }
        //度量自己的大小
    }

    /**
     * 3.确定view的大小
     * @param w
     * @param h
     * @param oldw
     * @param oldh
     */
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    /**
     * 4.确定子布局（包含View时用）
     * @param changed
     * @param l
     * @param t
     * @param r
     * @param b
     */
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }

    /**
     * 5.实际绘制的内容
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
    /**
     * 6.用户变化时引起操作
     */
    /**
     * 7.结束
     */
    /**
     * 用于刷新
     */
    @Override
    public void invalidate() {
        super.invalidate();
    }
}
