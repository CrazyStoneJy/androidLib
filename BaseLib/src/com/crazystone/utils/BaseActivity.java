package com.crazystone.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.crazystone.quickdev.ViewInjectUtils;

public class BaseActivity extends Activity implements OnClickListener {

//    /**
//     * findviewbyid
//     *
//     * @param id 资源地址
//     * @return
//     */
//    public <T extends View> T $(int id) {
//        return (T) (findViewById(id));
//    }


    /**
     * 给view设置监听事件
     *
     * @param views view数组
     */
    public void $(View... views) {
        for (View view : views) {
            view.setOnClickListener(this);
        }
    }


    @Override
    public void onClick(View view) {

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewInjectUtils.inject(this);
    }
}
