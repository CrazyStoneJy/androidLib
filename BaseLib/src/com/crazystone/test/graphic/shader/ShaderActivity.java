package com.crazystone.test.graphic.shader;

import android.os.Bundle;
import com.crazystone.utils.quickdev.annotation.SetContentView;
import com.crazystone.test.R;
import com.crazystone.utils.BaseActivity;

/**
 * Created by crazystone on 2016/2/26.
 */
@SetContentView(R.layout.activity_shader_view)
public class ShaderActivity extends BaseActivity {

    ShaderView shaderView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        shaderView = new ShaderView(this);
        shaderView.invalidate();
    }


}
