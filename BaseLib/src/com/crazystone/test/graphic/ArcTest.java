package com.crazystone.test.graphic;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.crazystone.quickdev.annotation.SetContentView;
import com.crazystone.quickdev.annotation.ViewInject;
import com.crazystone.test.R;
import com.crazystone.test.graphic.MyArc;
import com.crazystone.utils.BaseActivity;

/**
 * Created by crazystone on 2016/1/25.
 */
//@SetContentView(R.layout.activity_myarc)
public class ArcTest extends BaseActivity {

//    @ViewInject(R.id.arc_btn)
    private Button mBtn;

//    @ViewInject(R.id.myArc)
    private MyArc mArc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myarc);
        mBtn = (Button) findViewById(R.id.arc_btn);
        mArc = (MyArc) findViewById(R.id.myArc);
        mBtn.setText("start now");
        mBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        if (view.getId() == R.id.arc_btn) {
            mArc.invalidate();
        }
    }
}
