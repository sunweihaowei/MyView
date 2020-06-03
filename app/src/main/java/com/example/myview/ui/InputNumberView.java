package com.example.myview.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.myview.R;

/**
 * @author sunweihao
 * @description:自定义加减
 * @date :2020/6/1 7:06
 */
public class InputNumberView extends RelativeLayout {
    private static final String TAG = "InputNumberView";
    private int mCurrentNumber = 0;//这里是默认为0
    private TextView mMinusTv;
    private EditText mValueEdt;
    private TextView mPlusTv;
    private View inflate;
    private int max;
    private int min;
    private int step;
    private boolean disable;
    private int resourceId;
    private float dimension;
    private TypedArray typedArray;


    public InputNumberView(Context context) {
        this(context, null);
    }

    public InputNumberView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public InputNumberView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttrs(context, attrs);
        initView(context);
        //设置事件
        setUpEvent();
        //

    }

    private void initAttrs(Context context, AttributeSet attrs) {
        //设置属性
        typedArray = context.obtainStyledAttributes(attrs, R.styleable.InputNumberView);
        //默认值为0
        max = typedArray.getInt(R.styleable.InputNumberView_max, 0);
        min = typedArray.getInt(R.styleable.InputNumberView_min, 0);
        step = typedArray.getInt(R.styleable.InputNumberView_step, 0);
        disable = typedArray.getBoolean(R.styleable.InputNumberView_disable, false);
        resourceId = typedArray.getResourceId(R.styleable.InputNumberView_btnColor, -1);
        dimension = typedArray.getDimension(R.styleable.InputNumberView_default_size, 0);
        Log.d(TAG, "initAttrs: "
        +"\n"+max
        +"\n"+min
        +"\n"+step
        +"\n"+disable
        +"\n"+resourceId
        +"\n"+dimension
        );
        typedArray.recycle();
    }


    private void initView(Context context) {
        //前面的修改都会导致都执行这个方法
        //以下三种代码等价
        inflate = LayoutInflater.from(context).inflate(R.layout.input_number_view, this, true);
        mMinusTv = inflate.findViewById(R.id.minus_tv);
        mValueEdt = inflate.findViewById(R.id.value_edt);
        mPlusTv = inflate.findViewById(R.id.plus_tv);

//        LayoutInflater.from(context).inflate(R.layout.input_number_view,this);

//        View view = LayoutInflater.from(context).inflate(R.layout.input_number_view, this, false);
//        addView(view);
    }

    private void setUpEvent() {
        //3.首先在它的控件上设置监听，里面有方法
        mMinusTv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentNumber--;
                updateText();
            }
        });
        mPlusTv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentNumber++;//先加，后再更新
                updateText();
            }
        });
    }

    public int getCurrentNumber() {
        return mCurrentNumber;
    }

    public void setCurrentNumber(int value) {
        this.mCurrentNumber = value;
        this.updateText();//想要this吗
    }

    private void updateText() {
        mValueEdt.setText(String.valueOf(mCurrentNumber));
        //3.
        if (mOnNumberChangeListener != null) {
            mOnNumberChangeListener.onNumberChange(this.mCurrentNumber);
        }

    }

    /**
     * 监听
     */
    private OnNumberChangeListener mOnNumberChangeListener;
    //公共方法
    public void setOnNumberChangeListener(OnNumberChangeListener listener) {
        this.mOnNumberChangeListener = listener;//2.将方法转为成员变量
    }
    //1.接口
    public interface OnNumberChangeListener {//类里面的接口

        void onNumberChange(int value);
    }

}
