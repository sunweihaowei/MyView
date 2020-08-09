package com.example.viewpath;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * @ClassName ViewPath
 * @Description TODO
 * @Author ${孙伟豪}
 * @Date 2020/7/15 14:05
 * @Version 1.0
 */
public class MyViewPath extends View {

    private Paint paint;
    private Path path;
    private float radius;
    private Path.Direction dir;

    public MyViewPath(Context context) {
        this(context,null);
    }

    public MyViewPath(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyViewPath(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //创建paint
        paint = new Paint();
        paint.setColor(Color.YELLOW);
        paint.setAntiAlias(false);
        paint.setStyle(Paint.Style.STROKE);
        paint.setTextSize(30);
        //创建path
        path = new Path();
        radius = 100;
        //逆时针
        dir = Path.Direction.CCW;

    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        /**
         * 画圆环
         */
        path.addCircle(getWidth()/2,getHeight()/2,radius,dir);
        paint.setStrokeWidth(20);
        canvas.drawPath(path,paint);
        /**
         * 写文本
         */

        /*paint.setColor(Color.RED);
        String text="80";
        //得到文本的边界
        Rect bounds=new Rect();
        paint.getTextBounds(text,0, text.length(), bounds);
        int textWidth = bounds.width();
        int textHeight = bounds.height();
        float textX=getWidth()/2-textWidth/2;
        float textY=getHeight()/2+textHeight/2;
        canvas.drawText(text, textX, textY, paint);*/
        /**
         * 画弧
         */
        paint.setColor(Color.RED);
        RectF oval=new RectF(1,1,1,1);
        path.addArc(oval,1,2);
        canvas.drawPath(path,paint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
