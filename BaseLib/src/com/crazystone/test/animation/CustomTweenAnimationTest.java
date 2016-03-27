package com.crazystone.test.animation;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.crazystone.utils.quickdev.annotation.SetContentView;
import com.crazystone.utils.quickdev.annotation.ViewInject;
import com.crazystone.test.R;
import com.crazystone.utils.BaseActivity;
import com.crazystone.utils.common.L;
import com.crazystone.utils.common.ScreenUtils;

/**
 * 自定义tween动画test
 * Created by crazystone on 2016/1/3.
 */
@SetContentView(R.layout.activity_test_anim1)
public class CustomTweenAnimationTest extends BaseActivity {

    @ViewInject(R.id.test_anim_txt1)
    private TextView txt;
    @ViewInject(R.id.text_anim_btn1)
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        $(btn);
//        txt.setAnimation(new CustomTweenAnimation(ScreenUtils.getScreenWidth(this), ScreenUtils.getScreenHeight(this), 2 * 1000));

    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        if (view.getId() == R.id.text_anim_btn1) {
            L.d(">>>>>>>>>>>>");
            txt.startAnimation(new CustomTweenAnimation(ScreenUtils.getScreenWidth(this), ScreenUtils.getScreenHeight(this), 2 * 1000));
        }
    }
}
