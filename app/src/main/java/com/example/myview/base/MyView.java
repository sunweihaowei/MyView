package com.example.myview.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * @author sunweihao
 * @description:这是自定义View 的基础
 * @date :2020/5/31 9:48
 */

public class MyView  extends View {
    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 主题绘制
     * textView文字，ImageView图像等等
     * @param canvas 具体执行操作的是canvas画布 参数
     */
    @Override

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        /**
         * 普通绘制
         */
        Paint paint=new Paint();
//        paint.setColor();
        canvas.drawCircle(getX(), getY(),3,paint);
        /**
         * 裁切
         */
//        canvas.clipRect()//裁切
//        canvas.clipPath()//五角星
        /**
         * 绘制内容的几何变换
         */
        //拉伸，缩放等等
        /**
         * 绘制顺序,那个在最前，那个在最后，这样那些那些显示在里面
         */


    }
}
