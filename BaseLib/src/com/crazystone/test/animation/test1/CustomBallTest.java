package com.crazystone.test.animation.test1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.crazystone.quickdev.annotation.SetContentView;
import com.crazystone.quickdev.annotation.ViewInject;
import com.crazystone.test.R;
import com.crazystone.utils.BaseActivity;

/**
 * Created by crazystone on 2016/1/4.
 */
@SetContentView(R.layout.activity_test_anim2)
public class CustomBallTest extends BaseActivity {

    @ViewInject(R.id.btn_test1)
    private Button btn1;
    @ViewInject(R.id.btn_test2)
    private Button btn2;
    @ViewInject(R.id.btn_test3)
    private Button btn3;
    @ViewInject(R.id.btn_test4)
    private Button btn4;
    @ViewInject(R.id.customball)
    private CustomBall ball;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(new CustomBall(this));
        $(btn1, btn2, btn3, btn4);

    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {
            case R.id.text_anim_btn1:
                ball.setAnimType(CustomBall.TYPE1);
                break;
            case R.id.btn_test2:
                ball.setAnimType(CustomBall.TYPE2);

                break;
            case R.id.btn_test3:


                break;
            case R.id.btn_test4:


                break;
        }
    }
}
