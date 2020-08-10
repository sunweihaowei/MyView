package com.explain.activitydrawview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.graphics.Color;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.explain.activitydrawview.view.DrawView;

public class ActivityDrawViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_view);
    }
    //创建选项菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(this);     //实例化一个MenuInflater对象
        inflater.inflate(R.menu.toolsmenu,menu);        //解析菜单文件
        return super.onCreateOptionsMenu(menu);
    }
    //画板
    //当菜单项被选择时，做出相应的处理
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        DrawView dv = (DrawView)findViewById(R.id.drawView1);       //获取自定义的绘图视图
        dv.paint.setXfermode(null);                                 //取消擦除效果
        dv.paint.setStrokeWidth(1);                                 //初始化画笔的宽度
        switch (item.getItemId()) {
            case R.id.red:
                dv.paint.setColor(Color.RED);
                item.setChecked(true);
                break;
            case R.id.green:
                dv.paint.setColor(Color.GREEN);
                item.setChecked(true);
                break;
            case R.id.blue:
                dv.paint.setColor(Color.GREEN);
                item.setChecked(true);
                break;
            case R.id.width_1:
                dv.paint.setStrokeWidth(1);
                break;
            case R.id.width_2:
                dv.paint.setStrokeWidth(2);
                break;
            case R.id.width_3:
                dv.paint.setStrokeWidth(3);
                break;
            case R.id.clear:
                dv.clear();
                break;
            case R.id.sava:
                dv.savek();
                break;
        }
        return true;
    }
}


