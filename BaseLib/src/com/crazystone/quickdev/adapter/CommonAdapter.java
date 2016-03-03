package com.crazystone.quickdev.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by crazystone on 2015/12/20.
 */
public abstract class CommonAdapter<T> extends BaseAdapter {

    protected Context mContext;
    protected List<T> mDatas;
    protected int mLayoutId;

    public CommonAdapter(Context context, List<T> datas, int layoutId) {
        mContext = context;
        mDatas = datas;
        mLayoutId = layoutId;
    }


    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public T getItem(int i) {
        return mDatas.get(i);
    }

    @Override
    public long getItemId(int postion) {
        return postion;
    }

    @Override
    public View getView(int postion, View convertView, ViewGroup viewGroup) {
        final CommonViewHolder holder = getViewHolder(mContext, convertView, viewGroup, postion, mLayoutId);
        convert(holder, getItem(postion));
        return holder.getConvertView();
    }

    public abstract void convert(CommonViewHolder holder, T item);

    public CommonViewHolder getViewHolder(Context context, View convertView, ViewGroup parent, int postion, int layoutId) {
        CommonViewHolder holder = CommonViewHolder.getViewHolder(context, convertView, parent, postion, layoutId);
        return holder;
    }

}
