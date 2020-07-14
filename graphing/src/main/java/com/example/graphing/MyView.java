package com.example.graphing;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MyView extends View {

    private Paint paint;
    private int widthScreen;
    private int heightScreen;

    public MyView(Context context) {
        this(context,null);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();

    }

    private void initView() {
        //得到手机屏幕长宽
        widthScreen = getWidth();//表示宽的一半
        heightScreen = getHeight();//表示屏幕的一半
        //设置画笔
        paint = new Paint();
        paint.setAntiAlias(true);//设置抗锯齿，这里是圆滑
        paint.setColor(0xFFA4C739);//设置画笔颜色
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制机器人的头
        /**
         *
         */
        @SuppressLint("DrawAllocation") RectF rectF=new RectF(0,0,getWidth(),getWidth());//
        rectF.offset(getWidth()/2,getHeight()/2);//这里设置在哪里开始,左，头。这里是设置中间
        canvas.drawArc(rectF,-10,-160,false,paint);//绘制弧
        //
    }
}
