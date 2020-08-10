package com.example.canvas.utils;
//粒子封装对象
public class Ball {
    private static Ball ball=new Ball();

    public Ball() {
    }
    public static Ball instance(){
        return ball;
    }

    public int color;//图片像素点颜色
    public float x;//图片像素点坐标
    public float y;//图片像素点坐标
    public float r;//图片像素点半径
    //速度
    public float vX;//粒子运动水平方向速度
    public float vY;//粒子运动垂直方向速度
    //加速度
    public float aX;//粒子运动水平方向加速度
    public float aY;//粒子运动垂直方向加速度

    public static Ball getBall() {
        return ball;
    }

    public static void setBall(Ball ball) {
        Ball.ball = ball;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getR() {
        return r;
    }

    public void setR(float r) {
        this.r = r;
    }

    public float getvX() {
        return vX;
    }

    public void setvX(float vX) {
        this.vX = vX;
    }

    public float getvY() {
        return vY;
    }

    public void setvY(float vY) {
        this.vY = vY;
    }

    public float getaX() {
        return aX;
    }

    public void setaX(float aX) {
        this.aX = aX;
    }

    public float getaY() {
        return aY;
    }

    public void setaY(float aY) {
        this.aY = aY;
    }

    @Override
    public String toString() {
        return "Ball{" +
                "color=" + color +
                ", x=" + x +
                ", y=" + y +
                ", r=" + r +
                ", vX=" + vX +
                ", vY=" + vY +
                ", aX=" + aX +
                ", aY=" + aY +
                '}';
    }
}
