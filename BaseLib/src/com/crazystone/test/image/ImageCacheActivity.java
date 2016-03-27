package com.crazystone.test.image;

import android.os.Bundle;
import android.widget.ImageView;
import com.crazystone.utils.quickdev.annotation.SetContentView;
import com.crazystone.utils.quickdev.annotation.ViewInject;
import com.crazystone.test.R;
import com.crazystone.utils.BaseActivity;
import com.crazystone.utils.image.ImageLoaderUtils;

/**
 * Created by crazystone on 2016/3/11.
 */
@SetContentView(R.layout.activity_img)
public class ImageCacheActivity extends BaseActivity {

    @ViewInject(R.id.img)
    private ImageView img;

    private ImageLoaderUtils mUtils;

    private String url="http://img02.tooopen.com/images/20160216/tooopen_sy_156324542564.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUtils=ImageLoaderUtils.getInstance();
        mUtils.init(this);
        downLoadImg();
    }

    private void downLoadImg() {
        mUtils.setImageUrl(this,url,img);
    }
}
