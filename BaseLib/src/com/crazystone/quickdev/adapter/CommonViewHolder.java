package com.crazystone.quickdev.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by crazystone on 2015/12/19.
 */
public class CommonViewHolder {

    //SparesArray 是稀疏数组（功能和hashmap差不多）
    private SparseArray<View> mView;
    private View mConvertView;

    public CommonViewHolder(Context context, ViewGroup parent, int postion, int layoutId) {

        this.mView = new SparseArray<View>();
        mConvertView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        mConvertView.setTag(this);
    }


    /***
     * 获取一个viewholder
     *
     * @param context
     * @param convertView
     * @param parent
     * @param postion
     * @param layoutId
     * @return
     */
    public static CommonViewHolder getViewHolder(Context context, View convertView, ViewGroup parent, int postion, int layoutId) {

        CommonViewHolder holder = null;
        if (convertView == null) {
            holder = new CommonViewHolder(context, parent, postion, layoutId);
        } else {
            holder = (CommonViewHolder) convertView.getTag();
        }
        return holder;
    }


    public View getConvertView() {
        return mConvertView;
    }

    /**
     * 返回convertView的中的View
     *
     * @param viewId
     * @param <T>
     * @return
     */
    public <T extends View> T getView(int viewId) {
        View view = mView.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mView.put(viewId, view);
        }

        return (T) view;
    }

}
