package com.example.canvas.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class TransformView extends View {

    private Paint mPaint;

    public TransformView(Context context) {
        this(context,null);
    }

    public TransformView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TransformView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(10);
        mPaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //1.平移操作
        /*canvas.drawRect(0,0,400,400,mPaint);
        canvas.translate(50,50);
        mPaint.setColor(Color.YELLOW);
        canvas.drawRect(0,0,400,400,mPaint);
        canvas.drawLine(0,0,600,600,mPaint);*/
        //缩放
        /*canvas.scale(1.5f,1.5f);
        mPaint.setColor(Color.RED);
        canvas.drawRect(0,500,600,1100,mPaint);
        canvas.scale(2,2,100,500);
        canvas.drawCircle(400,400,200,mPaint);*/
        //缩放
        canvas.rotate(0,450,450);
        mPaint.setColor(Color.RED);
        canvas.drawRect(0,0,500,500,mPaint);
        canvas.skew(1,0);//表示tan西塔
        mPaint.setColor(Color.BLACK);
        canvas.drawRect(0,0,500,500,mPaint);
        //裁剪
//        省略

    }
}
