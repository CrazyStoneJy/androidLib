package com.crazystone.test.datastructure;

import android.os.Bundle;
import com.crazystone.test.datastructure.view.MyTreeView;
import com.crazystone.utils.BaseActivity;

/**
 * Created by crazystone on 2016/4/5.
 */
public class TreeTestActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyTreeView(this));
    }
}
