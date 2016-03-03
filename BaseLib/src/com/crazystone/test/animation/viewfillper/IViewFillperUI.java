package com.crazystone.test.animation.viewfillper;

import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ViewFlipper;

/**
 * Created by crazystone on 2016/1/13.
 */
public interface IViewFillperUI {


    TextView[] getTextViews();

    Spinner getSpinner();

    ViewFlipper getFlipper();
}
