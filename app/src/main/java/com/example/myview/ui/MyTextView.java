package com.example.myview.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class MyTextView extends View {
    /**
     * 这里是重写方法与方法在什么时候被使用
     */
    //new 的时候调用
    public MyTextView(Context context) {
        super(context,null);//这样修改会调用第二个
    }
    //<Text/>的时候调用
    public MyTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs,0);//这样修改会调用第三个
    }
    //<style/>的时候用
    public MyTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);//前面的方法都会调用第三个
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

    /**
     * 用于绘制
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc();//这里是画弧
        canvas.drawCircle();//这里是画圆
        canvas.drawText();//画文本
    }

    /**
     * 用于处理用户交互的，手指触摸等等
     * @param event 事件分发事件拦截
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                //按下
                break;
            case MotionEvent.ACTION_MOVE:
                //手指移动
                    break;
            case MotionEvent.ACTION_UP:
                //手指抬起
                break;
        }
        return super.onTouchEvent(event);
    }
    private String mText;
    private int mTextSize=15;
    private int mTextColor= Color.BLACK;
}
