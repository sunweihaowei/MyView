package com.explain.activitydrawview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import cn.forward.androids.TouchGestureDetector;

/**
 * @ClassName SimpleDoodleView
 * @Description TODO
 * @Author ${孙伟豪}
 * @Date 2020/8/7 10:38
 * @Version 1.0
 */
public class SimpleDoodleView extends View {
    private static final String TAG = "SimpleDoodleView";

    private Paint mPaint =new Paint();
    private List<Path> mPathList=new ArrayList<>();//保存涂鸦轨迹的集合
    private TouchGestureDetector mTouchGestureDetector;//触摸手势监听
    private float mLastX, mLastY;
    private Path mCurrentPath;//当前涂鸦的轨迹

    public SimpleDoodleView(Context context) {
        this(context,null);
    }

    public SimpleDoodleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public SimpleDoodleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //设置画笔
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);//描边
        mPaint.setStrokeWidth(20);//描边大小为20
        mPaint.setAntiAlias(true);//抗锯齿
        mPaint.setStrokeCap(Paint.Cap.ROUND);//拐角为圆形
        //由手势识别器处理手势
        mTouchGestureDetector=new TouchGestureDetector(getContext(),new TouchGestureDetector.OnTouchGestureListener(){
            //滑动开始
            @Override
            public void onScrollBegin(MotionEvent e) {
                Log.d(TAG, "onScrollBegin: ");
                mCurrentPath=new Path();//新的涂鸦
                mPathList.add(mCurrentPath);//添加到集合中
                mCurrentPath.moveTo(e.getX(),e.getY());
                mLastX=e.getX();
                mLastY=e.getY();
                invalidate();//刷新
            }
            //滑动中
            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                Log.d(TAG, "onScroll: "+e2.getX()+e2.getY());
                mCurrentPath.quadTo(
                        mLastX,
                        mLastY,
                        (e2.getX()+mLastX)/2,
                        (e1.getY()+mLastY)/2//使用贝赛尔曲线，让涂鸦轨迹更圆滑
                );
                mLastX=e2.getX();
                mLastY=e2.getY();
                invalidate();//刷新
                return true;
            }
            //活动结束
            @Override
            public void onScrollEnd(MotionEvent e) {
                Log.d(TAG, "onScrollEnd: ");
                mCurrentPath.quadTo(mLastX,
                        mLastY,
                        (e.getX()+mLastX)/2,
                        (e.getX()+mLastY)/2);//使用贝赛尔曲线 让涂鸦轨迹更圆滑
                mCurrentPath=null;//轨迹结束
                invalidate();//刷新
            }

        });
    }



    /**
     * 由手势识别处理手势
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        boolean consumed = mTouchGestureDetector.onTouchEvent(event);
        if (!consumed) {
            return super.dispatchTouchEvent(event);
        }
        return true;
    }
    /**
     * 绘制
     */
    @Override
    protected void onDraw(Canvas canvas) {
        for (Path path : mPathList) {
            canvas.drawPath(path,mPaint);
        }
    }
}
