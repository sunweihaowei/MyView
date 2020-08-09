package com.example.canvas;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import com.example.canvas.ui.view.SplitView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new SplitView(MainActivity2.this));

        /*Bitmap bitmap= BitmapFactory.decodeResource(getResources(),R.mipmap.xiaoxvan);
        bitmap.getWidth();
        bitmap.getHeight();
        int pixel = bitmap.getPixel(0, 0);//获取第一个像素值*/
    }
}