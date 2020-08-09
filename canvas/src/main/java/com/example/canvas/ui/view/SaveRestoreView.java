package com.example.canvas.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class SaveRestoreView extends View {

    private Paint mPaint;

    public SaveRestoreView(Context context) {
        this(context,null);
    }

    public SaveRestoreView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public SaveRestoreView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
        //回复操作
        canvas.translate(200,200);//平移
        int save = canvas.save();
        canvas.rotate(45);//旋转
        canvas.save();
        mPaint.setColor(Color.YELLOW);
        canvas.drawRect(0,0,200,200,mPaint);//黄色正方形
        /*canvas.restore();
        mPaint.setColor(Color.BLUE);
        canvas.drawRect(0,0,200,200,mPaint);//蓝色

        canvas.restore();
        canvas.drawRect(0,0,200,200,mPaint);//黑色*/
        mPaint.setColor(Color.BLACK);
        canvas.restoreToCount(save);
        canvas.drawRect(0,0,200,200,mPaint);//黄色正方形


    }
}
