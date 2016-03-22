package com.android.volley.utils;

import android.content.Context;
import com.android.volley.toolbox.Volley;

/**
 * 基于volley的网络请求框架
 * Created by crazystone on 2016/3/22.
 */
public class NetWorkUtils {

    private static NetWorkUtils mUtils;
    private Context mContext;

    private NetWorkUtils() {
    }

    public static NetWorkUtils getInstance() {
        if (mUtils == null) {
            synchronized (NetWorkUtils.class) {
                if (mUtils == null) {
                    mUtils = new NetWorkUtils();
                }
            }
        }
        return mUtils;
    }

    public static NetWorkUtils getInstance(Context context) {
        return getInstance();
    }

    public void init(Context context) {
        this.mContext = context;
        Volley.newRequestQueue(mContext);
    }


}
