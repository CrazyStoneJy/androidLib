package com.crazystone.test.graphic.shader;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.View;
import com.crazystone.test.R;

/**
 * 测试shader的view
 * Created by crazystone on 2016/2/26.
 */
public class ShaderView extends View {

    private Paint mPaint;//画笔
    private ShaderType mType;//渐变类型
    private Shader mShader;//渐变
    final int RADIUS = 50;

    public ShaderView(Context context) {
        this(context, null, 0);
    }

    public ShaderView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ShaderView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initPaint();
    }

    private void initPaint() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(5);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();

        float left = width / 5;
        float top = height / 3;
        float right = width * 2 / 5;
        float bottom = height * 2 / 3;

//        if (mType == ShaderType.LINEAR)
        mShader = new LinearGradient(left, top, left, bottom, new int[]{0xff0000ff, 0xffffffff}, null, Shader.TileMode.MIRROR);
//        if (mType == ShaderType.SWEEP)
        mPaint.setShader(mShader);
        canvas.drawRect(left, top, right, bottom, mPaint);
        mPaint.clearShadowLayer();
        mShader = new SweepGradient(right + left / 2, (top + bottom) / 2, new int[]{0xff0000ff, 0xffffffff}, null);
        mPaint.setShader(mShader);
        canvas.drawCircle(right + left / 2, (top + bottom) / 2, RADIUS, mPaint);
        mPaint.clearShadowLayer();
        mShader = new RadialGradient(right + left * 3 / 2, (top + bottom) / 2, RADIUS, new int[]{0xff0000ff, 0xffffffff}, null, Shader.TileMode.CLAMP);
        mPaint.setShader(mShader);
        canvas.drawCircle(right + left * 3 / 2, (top + bottom) / 2, RADIUS, mPaint);
    }

    public void setType(ShaderType type) {
        this.mType = type;
    }
}
