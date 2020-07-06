package rudra.id.ac.unila.basicknowledge.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;

import androidx.annotation.Nullable;

/**
 * @ClassName View
 * @Description TODO
 * @Author ${孙伟豪}
 * @Date 2020/7/2 9:37
 * @Version 1.0
 */
public class MyView extends android.view.View {

    private Paint mPaint;
    private Rect mBounds;
    private int number=10;
    /**
     * 重写3种构造器
     * @param context
     */
    public MyView(Context context) {
        this(context,null);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();//初始化
    }

    /**
     * 1.定大小
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    /**
     * 2.定位置
     * @param changed
     * @param left
     * @param top
     * @param right
     * @param bottom
     */
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }
    private void initView() {
        mPaint = new Paint();//涂料
        mBounds = new Rect();
    }
    /**
     * 3.绘制
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {//画布
        super.onDraw(canvas);
        mPaint.setColor(Color.RED);
        mPaint.setTextSize(30);
        //getWidth,getHeight手机屏幕的宽高
        canvas.drawCircle(getWidth()/2,getHeight()/2,100,mPaint);
        //测量大小
        //边界
        String text=String.valueOf(number);
        mPaint.getTextBounds(text,0,0,mBounds);
    }

    /**
     * 4.刷新
     */
    @Override
    public void invalidate() {
        super.invalidate();
    }

}
