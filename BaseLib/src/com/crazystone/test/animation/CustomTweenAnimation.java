package com.crazystone.test.animation;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;

/**
 * Created by crazystone on 2016/1/3.
 */
public class CustomTweenAnimation extends Animation {

    private int mX;
    private int mY;
    private int mDuration;
    private Camera mCamera;


    public CustomTweenAnimation(int x, int y, int duration) {
        this.mX = x;
        this.mY = y;
        this.mDuration = duration;
    }

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);

        setFillAfter(true);
        setInterpolator(new LinearInterpolator());
        setDuration(mDuration);
        mCamera = new Camera();
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);
        mCamera.save();

//        mCamera.translate(100f - 100f * interpolatedTime, 100 - 100 * interpolatedTime, 100 - 100 * interpolatedTime);
        mCamera.translate(300 * interpolatedTime, 300 * interpolatedTime, 300 * interpolatedTime);
//        mCamera.rotateX(360f * interpolatedTime);
//        mCamera.rotateY(360f * interpolatedTime);
        mCamera.rotateZ(360f * interpolatedTime);
//        mCamera.rotateY();
        Matrix matrix = t.getMatrix();
        mCamera.getMatrix(matrix);
//        matrix.preTranslate(-mX, -mY);
//        matrix.postTranslate(mX, mY);
        mCamera.restore();

    }
}
