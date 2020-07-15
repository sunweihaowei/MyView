package com.example.viewgroup;

import android.content.Context;
import android.graphics.Insets;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * @ClassName FlowLayout
 * @Description TODO
 * @Author ${孙伟豪}
 * @Date 2020/7/15 11:49
 * @Version 1.0
 */
public class FlowLayout extends ViewGroup {
    private static final String TAG="FlowLayout";
    private int mHorizontalSpacing=dp2px(16);//每个item横向间距

    private int mVerticalSpacing=dp2px(8);//每个item纵向间距

    private int dp2px(int i) {
        return 0;
    }
    public FlowLayout(Context context) {
        this(context,null);
    }
    //反射
    public FlowLayout(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 确定view的大小
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        /**
         * 度量孩子的大小
         */
        int childCount = getChildCount();//得到子布局数
        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);//得到第i个子view
            LayoutParams childLP = childView.getLayoutParams();
            //TODO:
            /*int childWidthMeasureSpec=getChildMeasureSpec(widthMeasureSpec,paddingLeft,paddingRight,childLP.width);
            int childHeightMeasureSpec=getChildMeasureSpec(widthMeasureSpec,paddingTop,paddingBottom,childLP.height);
            childView.measure(childWidthMeasureSpec,childHeightMeasureSpec);*/
        }
        /**
         * 度量自己的大小
         */
        /*setMeasuredDimension(measureWidht,measuredHeight);*/
    }

    /**
     * 确定字布局
     * @param changed
     * @param l
     * @param t
     * @param r
     * @param b
     */
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }

}
