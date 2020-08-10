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
import android.view.animation.LinearInterpolator;

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
    private int d=6;//粒子直径
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
        mBitmap= BitmapFactory.decodeResource(getResources(), R.mipmap.weixin);//有了它，就可以将bitmap转为对象
        for (int i = 0; i < mBitmap.getWidth(); i++) {
            for (int j = 0; j < mBitmap.getHeight(); j++) {
                Ball ball=new Ball();
                ball.color=mBitmap.getPixel(i,j);//获取第几个像素
                ball.x=i*d+d/2;
                ball.y=j*d+d/2;
                ball.r=d/2;//粒子的半径
                /**
                 * 初始化速度与加速度
                 */
                //速度（-20,20）
//                ball.vX= (float) Math.pow(-1,Math.ceil(Math.random()*1000)*20*Math.random());
                ball.vX= rangInt(-25,35);
                ball.vY=rangInt(-25,35);
//                ball.vY=10;
                //加速度
                ball.aX=0;
                ball.aY=0.98f;
                mBalls.add(ball);
                Log.d(TAG, "init: "+i);
            }
        }
        mAnimator=ValueAnimator.ofFloat(0,1);//开始运行
        mAnimator.setRepeatCount(-1);//重复运行
        mAnimator.setDuration(4000);
        mAnimator.setInterpolator(new LinearInterpolator());//线性插值器
        //监听
        mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                updateBall();
                invalidate();//刷新
            }
        });

    }
    private int rangInt(int i,int j){
        int max=Math.max(i,j);
        int min=Math.min(i,j)-1;
        //在0到（max-,min)范围内变化，取大于x的最小整数，再随机
        return (int)(min+Math.ceil(Math.random()*(max-min)));//60
    }
    private void updateBall() {
        //更新粒子的位置
        for (Ball ball : mBalls) {
            ball.x+=ball.vX;
            ball.y+=ball.vY;

            ball.vX+=ball.aX;
            ball.vY+=ball.aY;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.translate(0,0);
        for (Ball ball : mBalls) {
            mPaint.setColor(ball.color);//每一个像素的颜色不同
            canvas.drawCircle(ball.x,ball.y,ball.r,mPaint);
//            canvas.drawText("豪",ball.x,ball.y,mPaint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction()== MotionEvent.ACTION_DOWN) {
            //执行动画
            mAnimator.start();
        }
        return true;
    }
}
//问题，图片太大绘制不出来
