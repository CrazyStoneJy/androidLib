package com.crazystone.test.graphic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import com.crazystone.test.R;
import com.crazystone.utils.common.ScreenUtils;

/**
 * Created by crazystone on 2016/2/1.
 */
public class CompassView extends View {

    private Paint mPaint;
    private Path mPath;
    private int mScreenWidth;
    private int mScreenHeight;
    private Context mContext;
    private float mValue;//传感器感应的方向值
    private boolean mIsAnim;
    private static final float OFFSET_RAIUD = 5, ROUND = 360;

    public CompassView(Context context) {
        this(context, null, 0);
    }

    public CompassView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CompassView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mContext = context;
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStrokeWidth(2);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(getResources().getColor(R.color.black));

        mScreenHeight = ScreenUtils.getScreenHeight(mContext);
        mScreenWidth = ScreenUtils.getScreenWidth(mContext);

        mPath = new Path();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();

        drawMyCirle(canvas, width, height);

        mPaint.setStyle(Paint.Style.FILL);
        generateIndicator(canvas, width, height);

    }

    private void drawMyCirle(Canvas canvas, int width, int height) {

        canvas.drawCircle(width / 2, height / 2, width / 3, mPaint);
        int count = (int) (ROUND / OFFSET_RAIUD);
//        for (int i = 0; i < count; i++) {
//canvas.drawLine(width);
//
//        }

        canvas.save();
    }

    private void generateIndicator(Canvas canvas, int width, int height) {
        mPath.moveTo(width / 2, height / 2 - 50);
        mPath.lineTo(width / 2 + 20, height / 2 + 40);
        mPath.lineTo(width / 2, height / 2 + 10);
        mPath.lineTo(width / 2 - 20, height / 2 + 40);
        mPath.close();
        if (mValue != 0) {
            canvas.rotate(-mValue, width / 2, height / 2);
        }
        canvas.drawPath(mPath, mPaint);
    }


    public void setDirector(float value) {
        this.mValue = value;
    }


    @Override
    protected void onAttachedToWindow() {
        mIsAnim = true;
        super.onAttachedToWindow();
    }

    @Override
    protected void onDetachedFromWindow() {
        mIsAnim = false;
        super.onDetachedFromWindow();
    }
}
