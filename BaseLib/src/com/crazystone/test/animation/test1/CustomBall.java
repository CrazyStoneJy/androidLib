package com.crazystone.test.animation.test1;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.test.AndroidTestCase;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.SlidingDrawer;
import com.crazystone.utils.common.ScreenUtils;

/**
 * Created by crazystone on 2016/1/4.
 */
public class CustomBall extends View {

    private OvalShape mOvalShape;
    private static final int BALL_SIAZE = 100;
    private Paint mPaint;
    public static final int TYPE1 = 0, TYPE2 = 1, TYPE3 = 2, TYPE4 = 3;
    private int type = 0;
    private Context mContext;

    public CustomBall(Context context) {
        super(context);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStrokeWidth(5f);
        mContext = context;
    }

    public CustomBall(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStrokeWidth(5f);
        mContext = context;
    }

    public CustomBall(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStrokeWidth(5f);
        mContext = context;
    }

    public void setAnimType(int type) {
        this.type = type;
        invalidate();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        mOvalShape = new OvalShape();
//        mOvalShape.resize(BALL_SIAZE, BALL_SIAZE);
//        ShapeDrawable drawable = new ShapeDrawable(mOvalShape);
//      Paint paint= drawable.getPaint();
//        int red = (int) (100 + Math.random() * 155);
//        int green = (int) (100 + Math.random() * 155);
//        int blue = (int) (100 + Math.random() * 155);
//        int color = 0xff000000 | red << 16 | green << 8 | blue;
//        int darkColor = 0xff000000 | red / 4 << 16 | green / 4 << 8 | blue / 4;
        int color = 0x668B475D;
        int darkColor = 0x77EE4000;
        RadialGradient gradient = new RadialGradient(37.5f, 12.5f, BALL_SIAZE, color, darkColor, Shader.TileMode.CLAMP);
        mPaint.setShader(gradient);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, BALL_SIAZE, mPaint);
        startAnim(type);
    }

    /**
     * 属性动画
     *
     * @param type
     */
    private void startAnim(int type) {
        switch (type) {
            case TYPE1:
                ObjectAnimator animtor = ObjectAnimator.ofFloat(this, "y", this.getHeight() / 2, this.getHeight() * 3);
                animtor.setInterpolator(new LinearInterpolator());
                animtor.setDuration(2 * 1000);
                animtor.setRepeatCount(1);
                animtor.setRepeatMode(ValueAnimator.REVERSE);
                animtor.start();
                break;
            case TYPE2:
                //设置属性动画的属性
//                PropertyValuesHolder tranlateHolder = PropertyValuesHolder.ofFloat("y", this.getHeight(), this.getHeight() * 3);
                PropertyValuesHolder alphaHolder = PropertyValuesHolder.ofFloat("alpha", 1f, 0f);
                ObjectAnimator animator2 = ObjectAnimator.ofPropertyValuesHolder(this, alphaHolder);
                animator2.setDuration(2 * 1000);
                animator2.start();
                break;
            case TYPE3:


                break;
            case TYPE4:


                break;
        }
    }

}
