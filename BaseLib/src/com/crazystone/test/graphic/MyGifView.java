package com.crazystone.test.graphic;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.crazystone.test.R;

import java.io.InputStream;

/**
 * Created by crazystone on 2016/1/26.
 */
public class MyGifView extends ImageView {

    private Context mContext;
    private int mResId = 0;
    private Movie mMovie;
    private long startTime = 0;

    public MyGifView(Context context) {
        this(context, null, 0);
    }

    public MyGifView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyGifView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mContext = context;
        TypedArray a = mContext.obtainStyledAttributes(attrs, R.styleable.MyGifView, defStyle, 0);

        int count = a.getIndexCount();

        for (int i = 0; i < count; i++) {
            int attr = a.getIndex(i);
            switch (attr) {
                case R.styleable.MyGifView_gif:
                    mResId = a.getResourceId(attr, 0);
                    break;
            }
        }

        if (mResId > 0) {
            InputStream is = mContext.getResources().openRawResource(mResId);
            mMovie = Movie.decodeStream(is);
        }

        //释放资源
        a.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        long now = SystemClock.uptimeMillis();

        if (startTime == 0) {
            startTime = now;
        }

        if (mMovie != null) {
            int dur = mMovie.duration();
            if (dur == 0) {
                dur = 1000;
            }

            //算出第几帧
            int fps = (int) ((now - startTime) % dur);

            mMovie.setTime(fps);
            mMovie.draw(canvas, 0, 0);
            invalidate();

        }
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);


    }
}
