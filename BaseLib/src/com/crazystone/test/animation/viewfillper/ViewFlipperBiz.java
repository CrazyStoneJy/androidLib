package com.crazystone.test.animation.viewfillper;

import android.content.Context;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import com.crazystone.test.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by crazystone on 2016/1/13.
 */
public class ViewFlipperBiz implements IViewFlipperBiz, AdapterView.OnItemSelectedListener {

    private Context mContext;
    private IViewFillperUI mUI;

    public ViewFlipperBiz(Context context, IViewFillperUI ui) {
        mContext = context;
        mUI = ui;
    }

    @Override
    public void setTextViewContent() {
        TextView[] textviews = mUI.getTextViews();
        String[] array = mContext.getResources().getStringArray(R.array.viewfilpper_content);
        if (textviews.length != array.length) new Exception("textview legth is not equal array length!");
        for (int i = 0; i < array.length; i++) {
            textviews[i].setText(array[i]);
        }
    }

    @Override
    public void setSpinnerData() {
        Spinner spinner = mUI.getSpinner();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(mContext, android.R.layout.simple_spinner_item, getSpinnerData());
        spinner.setAdapter(adapter);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void startFlipper() {
        mUI.getFlipper().startFlipping();
    }


    public List<String> getSpinnerData() {
        List<String> list = new ArrayList<String>();
        String[] titles = mContext.getResources().getStringArray(R.array.viewflipper_title);
        for (String title : titles) {
            list.add(title);
        }
        return list;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        switch (i) {
            case 0:
                mUI.getFlipper().setInAnimation(AnimationUtils.loadAnimation(mContext,R.anim.pull_up_in));
                mUI.getFlipper().setOutAnimation(AnimationUtils.loadAnimation(mContext,R.anim.pull_up_out));
                break;
            case 1:
                mUI.getFlipper().setInAnimation(AnimationUtils.loadAnimation(mContext,R.anim.left_in));
                mUI.getFlipper().setOutAnimation(AnimationUtils.loadAnimation(mContext,R.anim.left_out));
                break;
            case 2:
                mUI.getFlipper().setInAnimation(AnimationUtils.loadAnimation(mContext,R.anim.fade_in));
                mUI.getFlipper().setOutAnimation(AnimationUtils.loadAnimation(mContext,R.anim.fade_out));
                break;
            case 3:

                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
