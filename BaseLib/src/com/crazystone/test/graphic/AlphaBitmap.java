package com.crazystone.test.graphic;

import android.app.Activity;
import android.content.Context;
import android.graphics.*;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import com.crazystone.test.R;

/**
 * Created by crazystone on 2016/1/5.
 */
public class AlphaBitmap extends Activity {

    public static final float TEXT_SIZE = 60;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyBitmap(this));
    }

    class MyBitmap extends View {

        Bitmap bitmap1;
        Bitmap bitmap2;
        Bitmap bitmap3;
        Shader mShader;
        int xIndex = 50;
        int y = 50;
        Paint mPaint;

        public MyBitmap(Context context) {
            super(context);
            mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            mPaint.setColor(getResources().getColor(R.color.yellow));
            bitmap1 = BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_launcher);

            bitmap2 = bitmap1.extractAlpha();

            bitmap3 = Bitmap.createBitmap(200, 200, Bitmap.Config.ALPHA_8);
            drawInBitmap(bitmap3);
            mShader = new LinearGradient(0, 0, 100, 70, new int[]{
                    Color.RED, Color.GREEN, Color.BLUE},
                    null, Shader.TileMode.MIRROR);

        }


        public void drawInBitmap(Bitmap bitmap) {

            int y = bitmap.getHeight();
            int x = bitmap.getWidth();

            Canvas canvas = new Canvas(bitmap);
            Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

            paint.setAlpha(0x80);

            canvas.drawCircle(x / 2, y / 2, x / 2, paint);

            paint.setAlpha(0x30);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            Paint.FontMetrics metrics = paint.getFontMetrics();
            paint.setTextSize(TEXT_SIZE);
            paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText("alpha", x / 2, (y - metrics.ascent) / 2, paint);

        }


        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            canvas.drawBitmap(bitmap1, xIndex, y, mPaint);
            y += 100;
            mPaint.setShader(mShader);
            canvas.drawBitmap(bitmap2, xIndex, y, mPaint);
            y += 100;
            canvas.drawBitmap(bitmap3, xIndex, y, mPaint);
        }
    }

}
