package com.crazystone.test.animation.PropertyAnim.test1;

import android.animation.*;
import android.os.Bundle;
import android.view.View;
import android.view.animation.*;
import android.widget.Button;
import android.widget.ImageView;
import com.crazystone.quickdev.annotation.SetContentView;
import com.crazystone.quickdev.annotation.ViewInject;
import com.crazystone.test.R;
import com.crazystone.utils.BaseActivity;
import com.crazystone.utils.common.ScreenUtils;

/**
 * Created by crazystone on 2016/1/4.
 */
@SetContentView(R.layout.activity_test_anim3)
public class AnimationClone extends BaseActivity {

    @ViewInject(R.id.anim_img1)
    private ImageView img1;
    @ViewInject(R.id.anim_img2)
    private ImageView img2;
    @ViewInject(R.id.anim_img3)
    private ImageView img3;
    @ViewInject(R.id.anim_img4)
    private ImageView img4;
    @ViewInject(R.id.anim_btn)
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        img1.setImageResource(R.drawable.red_circle);
        img2.setImageResource(R.drawable.purple_graient_circle);
        img3.setImageResource(R.drawable.green_circle);
        img4.setImageResource(R.drawable.yellow_circle);
        $(btn);
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        if (view.getId() == R.id.anim_btn) {
//            loadAnim();
            AnimCloneTest();
        }
    }

    /**
     * 属性动画clone test
     */
    private void AnimCloneTest() {
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(img1, "y", 100f, ScreenUtils.getScreenHeight(this) - 300f).setDuration(2 * 1000);
        animator1.setRepeatCount(1);
        animator1.setRepeatMode(ValueAnimator.REVERSE);
        ObjectAnimator animator2 = animator1.clone().setDuration(2 * 1000);
        animator1.setInterpolator(new AccelerateInterpolator());
        animator2.setTarget(img2);
        animator2.setInterpolator(new AccelerateDecelerateInterpolator());
        ObjectAnimator animtor3 = ObjectAnimator.ofFloat(img3, "alpha", 1, 0f).setDuration(2 * 1000);
        animtor3.setInterpolator(new DecelerateInterpolator());
        ObjectAnimator animator4 = ObjectAnimator.ofFloat(img4, "alpha", 0, 1f).setDuration(2 * 1000);
        animator4.setInterpolator(new LinearInterpolator());
        AnimatorSet animSet = new AnimatorSet();
        animSet.playTogether(animator1, animator2, animtor3, animator4);
        animSet.start();
        animator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                img1.postInvalidate();
            }
        });

    }


    /***
     *
     */
    private void loadAnim() {

        ObjectAnimator animator1 = (ObjectAnimator) AnimatorInflater.loadAnimator(this, R.animator.animator1);
        animator1.setTarget(img1);

        ObjectAnimator animator2 = (ObjectAnimator) AnimatorInflater.loadAnimator(this, R.animator.animator2);
        animator2.setTarget(img2);
        AnimatorSet set = new AnimatorSet();
        set.playTogether(animator1, animator2);
        set.start();
    }


}
