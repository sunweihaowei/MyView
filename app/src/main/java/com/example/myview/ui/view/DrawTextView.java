package com.example.myview.ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * @ClassName DrawTextView
 * @Description TODO
 * @Author ${孙伟豪}
 * @Date 2020/6/17 14:06
 * @Version 1.0
 */
public class DrawTextView extends View {
    private Paint mPaint ;
    private String text = "A";
    private String colorString ="#FF4081";
    private Bitmap textBitmap;

    public Bitmap getTextBitmap() {
        return textBitmap;
    }

    public void setTextBitmap(Bitmap textBitmap) {
        this.textBitmap = textBitmap;
    }

    public String getColorString() {
        return colorString;
    }

    public void setColorString(String colorString) {
        this.colorString = colorString;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public DrawTextView(Context context) {
        this(context,null);
    }

    public DrawTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public DrawTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }


    /**
     * 初始化画笔设置
     */
    private void initPaint() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.parseColor(colorString));
        mPaint.setTextSize(90f);
        textBitmap = Bitmap.createBitmap((int) mPaint.measureText(text),200,Bitmap.Config.ARGB_8888);
    }

    /**
     * 绘制
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawText(text, getWidth()/2 ,getHeight()/2 ,mPaint);
    }

    /**
     * 测量
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int wSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int wSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int hSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int hSpecSize = MeasureSpec.getSize(heightMeasureSpec);

        if (wSpecMode == MeasureSpec.AT_MOST && hSpecMode == MeasureSpec.AT_MOST){
            setMeasuredDimension(300,300);
        }else  if (wSpecMode == MeasureSpec.AT_MOST){
            setMeasuredDimension(300,hSpecSize);
        }else if (hSpecMode ==  MeasureSpec.AT_MOST) {
            setMeasuredDimension(wSpecSize,300);
        }
    }
}
