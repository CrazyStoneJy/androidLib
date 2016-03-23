package com.android.volley.utils;

import android.content.Context;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * 基于volley的网络请求框架
 * Created by crazystone on 2016/3/22.
 */
public class NetWorkUtils {

    private static NetWorkUtils mUtils;
    private static Context mContext;
    private static RequestQueue mQueue;
    public static String HOST = "";

    private NetWorkUtils() {
    }

    @Deprecated
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

    public static void init(Context context) {
        mContext = context;
        HOST = PropertiesUtils.getHost(context);
        mQueue = Volley.newRequestQueue(mContext);
    }

    public <T> void addRequest(Context context, Request<T> request) {
        if (mQueue == null) init(context);
        mQueue.add(request);
    }

}
