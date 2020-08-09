package com.example.canvas.ui.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.canvas.R;
import com.example.canvas.utils.Ball;

import java.util.ArrayList;
import java.util.List;

public class SplitView extends View {
    private static final String TAG = "SplitView";
    private Paint mPaint;
    private Bitmap mBitmap;
    private List<Ball> mBalls=new ArrayList<>();
    private int d=3;//粒子直径
    private ValueAnimator mAnimator;//属性动画
    public SplitView(Context context) {
        this(context,null);
    }

    public SplitView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public SplitView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint=new Paint();
        mPaint.setStrokeWidth(10);
        mPaint.setStyle(Paint.Style.STROKE);
        mBitmap= BitmapFactory.decodeResource(getResources(), R.mipmap.wx3_05);//有了它，就可以将bitmap转为对象
        for (int i = 0; i < mBitmap.getWidth(); i++) {
            for (int j = 0; j < mBitmap.getHeight(); j++) {
                Ball ball=new Ball();
                ball.color=mBitmap.getPixel(i,j);//获取第几个像素
                ball.x=i*d+d/2;
                ball.y=j*d+d/2;
                ball.r=d/2;
                mBalls.add(ball);
                Log.d(TAG, "init: "+i);
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.translate(getWidth()/2,getHeight()/2);
        for (Ball ball : mBalls) {
            mPaint.setColor(ball.color);//每一个像素的颜色不同
            canvas.drawCircle(ball.x,ball.y,ball.r,mPaint);
        }
        mPaint.setColor(Color.RED);
        canvas.drawCircle(10,10,200,mPaint);
    }

    /*@Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction()== MotionEvent.ACTION_DOWN) {
            //执行动画
        }
    }*/
}
//问题，图片太大绘制不出来
