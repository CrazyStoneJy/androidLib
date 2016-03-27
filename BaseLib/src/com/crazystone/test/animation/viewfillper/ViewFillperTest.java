package com.crazystone.test.animation.viewfillper;

import android.os.Bundle;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ViewFlipper;
import com.crazystone.utils.quickdev.annotation.SetContentView;
import com.crazystone.utils.quickdev.annotation.ViewInject;
import com.crazystone.test.R;
import com.crazystone.utils.BaseActivity;

/**
 * Created by crazystone on 2016/1/13.
 */
@SetContentView(R.layout.activity_anim_viewfillper)
public class ViewFillperTest extends BaseActivity implements IViewFillperUI {

    @ViewInject(R.id.view_flipper)
    private ViewFlipper mFlipper;
    @ViewInject(R.id.viewflipper_txt1)
    private TextView mTxt1;
    @ViewInject(R.id.viewflipper_txt2)
    private TextView mTxt2;
    @ViewInject(R.id.viewflipper_txt3)
    private TextView mTxt3;
    @ViewInject(R.id.viewflipper_txt4)
    private TextView mTxt4;
    @ViewInject(R.id.viewflipper_spiiner)
    private Spinner mSpinner;
    private TextView[] textViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        textViews = new TextView[4];
        textViews[0] = mTxt1;
        textViews[1] = mTxt2;
        textViews[2] = mTxt3;
        textViews[3] = mTxt4;
        ViewFlipperBiz presenter = new ViewFlipperBiz(this, this);
        presenter.setTextViewContent();
        presenter.startFlipper();
        presenter.setSpinnerData();
    }


    @Override
    public TextView[] getTextViews() {
        return textViews;
    }

    @Override
    public Spinner getSpinner() {
        return mSpinner;
    }

    @Override
    public ViewFlipper getFlipper() {
        return mFlipper;
    }
}
