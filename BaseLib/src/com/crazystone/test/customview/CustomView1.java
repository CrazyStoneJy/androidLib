package com.crazystone.test.customview;

import android.content.Context;
import android.graphics.*;
import android.graphics.Matrix;
import android.media.MediaPlayer;
import android.opengl.*;
import android.util.AttributeSet;
import android.view.View;
import com.crazystone.test.R;

/**
 * Created by crazystone on 2016/3/27.
 */
public class CustomView1 extends View {

    private Paint mPaint;
    private static final int PAINT_SIZE = 5;
    private Context mContext;
    /*  view的宽度*/
    private int mWidth = 0;
    /*  view的高度*/
    private int mHeight = 0;
    /*  大圆圈的半径*/
    private static final int BIG_CIRCLE_RADIUS = 200;
    /*小圆圈的半径*/
    private static final int SMALL_CIRCLE_RADIUS = 180;
    /*x轴的基准点*/
    private int mXpivot = 0;
    /*y轴的基准点*/
    private int mYpivot = 0;

    public CustomView1(Context context) {
        this(context, null, 0);
    }

    public CustomView1(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomView1(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mContext = context;
        initPaint();
    }

    private void initPaint() {
        if (mPaint == null) mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        mPaint.setStrokeWidth(PAINT_SIZE);
        mPaint.setColor(mContext.getResources().getColor(R.color.blue));
        mPaint.setStyle(Paint.Style.STROKE);

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mWidth = getWidth();
        mHeight = getHeight();
        mXpivot = mWidth / 2;
        mYpivot = mHeight / 2;

        //将画布的中心点平移到中间
        canvas.translate(mXpivot, mYpivot);

//        testScale(canvas);
//        testskew(canvas);
        testDrawBitmap(canvas);
    }


    /**
     * 测试画布的旋转
     *
     * @param canvas
     */
    private void testRotate(Canvas canvas) {
        canvas.drawCircle(0, 0, BIG_CIRCLE_RADIUS, mPaint);
        canvas.drawCircle(0, 0, SMALL_CIRCLE_RADIUS, mPaint);

        for (int i = 0; i <= 360; i += 10) {
            canvas.drawLine(0, SMALL_CIRCLE_RADIUS, 0, BIG_CIRCLE_RADIUS, mPaint);
            canvas.rotate(10, 0, 0);
        }
    }


    /* 测试画布的伸缩*/
    private void testScale(Canvas canvas) {

        RectF rect = new RectF(-BIG_CIRCLE_RADIUS, -BIG_CIRCLE_RADIUS, BIG_CIRCLE_RADIUS, BIG_CIRCLE_RADIUS);
        for (int i = 1; i <= 10; i++) {
            canvas.scale(0.9f, 0.9f, 0, 0);
            canvas.drawRect(rect, mPaint);
        }
    }

    /**
     * 测试画布斜切
     */
    private void testskew(Canvas canvas) {

        RectF rectf = new RectF(0, 0, BIG_CIRCLE_RADIUS, BIG_CIRCLE_RADIUS);
        //x轴倾斜45度
        canvas.skew(1, 0);
        canvas.drawRect(rectf, mPaint);
    }

    /**
     * 测试画bitmap
     */
    private void testDrawBitmap(Canvas canvas) {
        Bitmap bitmap = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.beauty);
//        Rect src = new Rect(-bitmap.getWidth() / 2, -bitmap.getHeight() / 2, bitmap.getWidth() / 2, bitmap.getHeight());
//        Rect dest = new Rect(-bitmap.getWidth() / 2, -bitmap.getHeight() / 2, bitmap.getWidth() / 2, bitmap.getHeight());
////        Rect dest=new Rect(-20,-20,20,20);
//        canvas.drawBitmap(bitmap, src, dest, mPaint);

        canvas.drawBitmap(bitmap,-mXpivot,-mYpivot,mPaint);
//        canvas.drawArc();
//        android.opengl.Matrix


    }

}
