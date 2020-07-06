package com.example.myview.ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.myview.R;

/**
 * @ClassName GameView
 * @Description TODO
 * @Author ${孙伟豪}
 * @Date 2020/6/17 15:06
 * @Version 1.0
 */
public class GameView extends View {

    private Paint paint = null; //

    private Bitmap originalBitmap = null;//原始图

    private Bitmap new1Bitmap = null;

    private Bitmap new2Bitmap = null;

    private float clickX =0;

    private float clickY=0;

    private float startX=0;

    private float startY=0;

    private boolean isMove = true;

    private boolean isClear = false;

    private int color = Color.RED;//默认画笔颜色为红色

    private float strokeWidth =2.0f;//默认画笔粗度



    public GameView(Context context) {
        this(context,null);
        // TODO Auto-generated constructor stub
    }
    public GameView(Context context, AttributeSet atts) {
        this(context,atts,0);
        // TODO Auto-generated constructor stub
    }
    public GameView(Context context,AttributeSet atts,int defStyle) {
        super(context,atts,defStyle);
        // TODO Auto-generated constructor stub

        originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher_background).copy(Bitmap.Config.ARGB_8888, true);//加载一张背景
        new1Bitmap=originalBitmap.createBitmap(originalBitmap);
    }

    //清除函数
    public void clear(){
        isClear =true;
        new2Bitmap=originalBitmap.createBitmap(originalBitmap);
        invalidate();//重载
    }

    public void setStrokeWidth(float width){
        this.strokeWidth=width;
        initPaint();
    }
    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        super.onDraw(canvas);
        canvas.drawBitmap(writer(new1Bitmap),0,0, null);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // TODO Auto-generated method stub


        clickX =event.getX();

        clickY=event.getY();

        if(event.getAction()==MotionEvent.ACTION_DOWN){
            isMove =false;
            invalidate();
            return true;
        }
        else if(event.getAction()==MotionEvent.ACTION_MOVE){
            isMove =true;
            invalidate();
            return true;
        }


        return super.onTouchEvent(event);
    }

    /**
     * @Title: writer
     * @Description: TODO(生成bitmap)
     * @param @param pic
     * @param @return  设定文件
     * @return Bitmap  返回类型
     * @throws
     */
    public Bitmap writer(Bitmap pic){
        initPaint();

        Canvas canvas =null;
        if(isClear){
            canvas=new Canvas(new2Bitmap);
        }else{
            canvas=new Canvas(pic);
        }

        if(isMove){
            canvas.drawLine(startX, startY, clickX, clickY, paint);//划线
        }
        startX = clickX;

        startY =clickY;
        if(isClear){
            return new2Bitmap;
        }
        return pic;
    }

    private void initPaint(){

        paint = new Paint();//新建画笔

        paint.setStyle(Paint.Style.STROKE);//设置为画线

        paint.setAntiAlias(true);//可以让线条圆滑一些

        paint.setColor(color);//设置画笔颜色

        paint.setStrokeWidth(strokeWidth);//设置画笔线条的粗细
    }

    /**
     * @Title: setColor
     * @Description: TODO(设置线条颜色的对外接口)
     * @param @param color  设定文件
     * @return void  返回类型
     * @throws
     */
    public void setColor(int color){

        this.color=color;
        initPaint();
    }


}
