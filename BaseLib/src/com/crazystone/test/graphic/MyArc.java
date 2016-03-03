package com.crazystone.test.graphic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;
import com.crazystone.test.R;

import java.util.GregorianCalendar;

/**
 * Created by crazystone on 2016/1/25.
 */
public class MyArc extends View {

    private RectF[] mOvals;  //扇形
    private RectF mBigRect;
    private Paint[] mPaint;  //画扇形的画笔
    private Paint mFramePaint;   //画矩形框的画笔
    private Boolean[] mUseCenter;
    private static final int START_ANGLE = 15, SWEEP_ANGLE = 2;
    private Context mContext;
    private int index;
    private int start = 0, sweep = 0;
    private int width = 0;
    private int height = 0;
    private static final int BIG_SIZE = 200, SMALL_SIZE = 90, PAINT_WIDTH = 20;

    public MyArc(Context context) {
        this(context, null, 0);
        init();
        this.mContext = context;
    }

    public MyArc(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        init();
        this.mContext = context;
    }

    public MyArc(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
        this.mContext = context;
    }

    private void init() {

        mPaint = new Paint[4];
        mOvals = new RectF[4];
        mUseCenter = new Boolean[4];

        this.width = getWidth();
        this.height = getHeight();
        mPaint[0] = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint[0].setStrokeJoin(Paint.Join.ROUND);
        mPaint[0].setStrokeCap(Paint.Cap.ROUND);
        mPaint[0].setAlpha(0x50);
//        mPaint[0].setStrokeWidth(PAINT_WIDTH);
        mPaint[0].setStyle(Paint.Style.FILL);
        mPaint[0].setColor(getResources().getColor(R.color.red));
        mUseCenter[0] = false;

        mPaint[1] = new Paint(mPaint[0]);
        mPaint[1].setColor(getResources().getColor(R.color.green));
        mUseCenter[1] = true;

        mPaint[2] = new Paint(mPaint[1]);
        mPaint[2].setColor(getResources().getColor(R.color.drak_purple));
        mPaint[2].setStyle(Paint.Style.STROKE);
        mUseCenter[2] = false;

        mPaint[3] = new Paint(mPaint[2]);
        mUseCenter[3] = true;

        mFramePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mFramePaint.setColor(getResources().getColor(R.color.black));
        mFramePaint.setStyle(Paint.Style.STROKE);

        mBigRect = new RectF(40, 10, 280, 250);

        mOvals[0] = new RectF(10, 270, 70, 330);
        mOvals[1] = new RectF(90, 270, 150, 330);
        mOvals[2] = new RectF(170, 270, 230, 330);
        mOvals[3] = new RectF(250, 270, 310, 330);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(getResources().getColor(R.color.light_gray));
        drawArcRect(canvas, mBigRect, mUseCenter[index], mPaint[index]);

        for (int i = 0; i < 4; i++) {
            drawArcRect(canvas, mOvals[i], mUseCenter[i], mPaint[i]);
        }

        sweep += SWEEP_ANGLE;

        if (sweep > 360) {
            sweep -= 360;

            start += START_ANGLE;
            if (start > 360) {
                start -= 360;
            }
            index = (index + 1) % mUseCenter.length;
        }
        invalidate();

    }

    private void drawArcRect(Canvas canvas, RectF oval, boolean useCenter, Paint paint) {
        canvas.drawRect(oval, mFramePaint);
        canvas.drawArc(oval, start, sweep, useCenter, paint);
    }


//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        int width = 400;
//        int height = 500;
//        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
//        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
//        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
//        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
//
//        if (widthMode == MeasureSpec.EXACTLY) {
//            measure(widthSize, height);
//        } else if (widthMode == MeasureSpec.AT_MOST) {
//            measure(width, height);
//        }
//    }

}
