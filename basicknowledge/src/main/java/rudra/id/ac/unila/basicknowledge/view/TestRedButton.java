package rudra.id.ac.unila.basicknowledge.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import rudra.id.ac.unila.basicknowledge.R;

/**
 * @ClassName View
 * @Description TODO
 * @Author ${孙伟豪}
 * @Date 2020/7/2 9:37
 * @Version 1.0
 */
public class TestRedButton extends android.view.View implements View.OnClickListener {

    private static final String TAG ="MyView" ;
    private Paint mPaint;
    private Rect mRect;
    private int mNumber =10;//默认为10
    private RectF rectF;
    //在xml上的属性
    private int mBackgroundColor;

    /**
     * 重写3种构造器
     * @param context
     */
    public TestRedButton(Context context) {
        this(context,null);
    }

    public TestRedButton(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TestRedButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context,attrs);//初始化
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
    private void initView(Context context,AttributeSet attrs) {
        mPaint = new Paint();//涂料
        mRect = new Rect();//矩形，用于确定位置
        //形状
        rectF = new RectF(-100, -100, 100, 100);
        rectF.offset(getWidth()/2,getHeight()/2);//在哪里开始画
        //本身就是view，所以本身可以监听
        TestRedButton.this.setOnClickListener(this);
        //加载attrs文件
        TypedArray typedArray=context.obtainStyledAttributes(attrs, R.styleable.TestRedButton);//尴尬，这里居然错了
        //获取里面的某一个属性
        mBackgroundColor=typedArray.getColor(R.styleable.TestRedButton_backgroundColor,Color.RED);
    }
    /**
     * 3.绘制
     * @param canvas
     * 不能再这里new，因为这里会一直刷新，会占空间
     */
    @Override
    protected void onDraw(Canvas canvas) {//画布
        super.onDraw(canvas);
        //颜色画笔
//        mPaint.setColor(Color.RED);
        mPaint.setColor(mBackgroundColor);
        mPaint.setTextSize(30);
        //getWidth,getHeight手机屏幕的宽高--x,y,radius,笔
        canvas.drawCircle(getWidth()/2,getHeight()/2,getWidth()/2,mPaint);//画圆，radius：半径
        /**
         * 中间有一个白色的字
         */
        mPaint.setColor(Color.WHITE);//涂料设置为白色
        mPaint.setTextSize(100);
        //测量大小
        //边界
        String text=String.valueOf(mNumber);

        mPaint.getTextBounds(text,0,text.length(), mRect);//mRect表示文字的边界
        int widthText = mRect.width();//文本的宽度
        int heightText = mRect.height();//文本的高度
        canvas.drawText(text,getWidth()/2-widthText/2,getHeight()/2+heightText/2,mPaint);
    }

    /**
     * 4.刷新
     */
    @Override
    public void invalidate() {
        super.invalidate();
    }

    @Override
    public void onClick(View v) {
        mNumber=mNumber<=0?20:mNumber-1;
        Log.d(TAG, "onClick: "+mNumber);
        invalidate();
    }
}
