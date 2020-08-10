package com.example.carousel;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.bumptech.glide.Glide;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

public class CarouselActivity extends AppCompatActivity {
    /**
     * 权限
     */
    private static int REQUEST_PERMISSION_CODE = 1;//请求状态码
    CarouselView carouselView;
    private final String TAG = CarouselActivity.class.getSimpleName();

    int[] sampleImages = {R.drawable.yd1, R.drawable.yd2, R.drawable.yd3, R.drawable.yd4, R.drawable.yd5};
    private ImageView imageView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carousel);
        initView();
        carouselView = (CarouselView) findViewById(R.id.carouselView);

        //1.设置轮播图数量
        carouselView.setPageCount(5);

        carouselView.setImageListener(imageListener);
        carouselView.setImageClickListener(new ImageClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(CarouselActivity.this, "hh" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            //2.设置资源
//            imageView.setImageResource(sampleImages[position]);
            Glide.with(CarouselActivity.this).load(UrlUtils.getImgUrl(position + 3)).into(imageView);
//            Uri url=Uri.parse(UrlUtils.getImgUrl(3));
//            imageView.setImageURI(url);
        }
    };
    private void initView() {
        imageView1 = (ImageView) findViewById(R.id.imageView);
        Glide.with(CarouselActivity.this).load(UrlUtils.getImgUrl(3)).into(imageView1);
    }
}
