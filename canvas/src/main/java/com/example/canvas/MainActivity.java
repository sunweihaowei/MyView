package com.example.canvas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.canvas.ui.view.SaveRestoreView;
import com.example.canvas.ui.view.TransformView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new SaveRestoreView(this));
    }
}
