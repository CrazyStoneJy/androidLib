package com.crazystone.test.customview;

import android.os.Bundle;
import com.crazystone.utils.BaseActivity;

/**
 * Android画布练习
 * Created by crazystone on 2016/3/27.
 */
public class CanvasTest extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new CustomView1(this));

    }
}
