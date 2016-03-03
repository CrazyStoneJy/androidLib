package com.crazystone.test.animation.PropertyAnim.test1;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import com.crazystone.quickdev.annotation.SetContentView;
import com.crazystone.quickdev.annotation.ViewInject;
import com.crazystone.test.R;
import com.crazystone.utils.BaseActivity;
import com.crazystone.utils.common.L;
import com.crazystone.utils.common.ScreenUtils;

/**
 * Created by crazystone on 2016/1/5.
 */
@SetContentView(R.layout.activity_test_anim4)
public class AnimtorTest2 extends BaseActivity {

    @ViewInject(R.id.anim4_test_img)
    private ImageView img;
    @ViewInject(R.id.anim4_test_btn)
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        img.setImageResource(R.drawable.yellow_circle);
        $(btn);
//        createAnim();
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        if (view.getId() == R.id.anim4_test_btn) {
            createAnim();
        }
    }

    private void createAnim() {

//        ObjectAnimator animator1 = ObjectAnimator.ofFloat(img, "x", 0, ScreenUtils.getScreenWidth(this) - img.getWidth());
//        ObjectAnimator animator2 = ObjectAnimator.ofFloat(img, "y", 0, ScreenUtils.getScreenHeight(this) - img.getHeight());
//
//        animator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//
//            }
//        });

        ValueAnimator animator = new ValueAnimator();
        animator.setDuration(2 * 1000);
        animator.setInterpolator(new LinearInterpolator());
        animator.setObjectValues(new PointF(0, 0));
        //设置动画的值
        animator.setEvaluator(new TypeEvaluator<PointF>() {
            @Override
            public PointF evaluate(float fraction, PointF startValue, PointF endValue) {
                L.d("fraction:" + fraction);
                PointF point = new PointF();
                point.x = 200 * fraction * 3;
                point.y = (float) (0.5 * 200 * (fraction * 3) * (fraction * 3));
                return point;
            }
        });
        animator.start();
        //手动设置view的animtor
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                PointF point = (PointF) animation.getAnimatedValue();
                img.setX(point.x);
                img.setY(point.y);
            }
        });
    }


}
