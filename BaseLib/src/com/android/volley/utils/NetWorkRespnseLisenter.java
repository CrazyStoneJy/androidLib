package com.android.volley.utils;

import android.os.Handler;
import android.os.Looper;
import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.VolleyError;

/**
 * Created by crazystone on 2016/3/7.
 */
//TODO
public abstract class NetWorkRespnseLisenter<T> implements Response.Listener<T>, Response.ErrorListener {

    private Handler mHandler;

    public NetWorkRespnseLisenter() {
        if (mHandler != null) mHandler = new Handler(Looper.myLooper());
    }


    @Override
    public void onErrorResponse(VolleyError error) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                onFail();
            }
        });
    }

    @Override
    public void onResponse(final T response) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                onResponse(response);
            }
        });
    }

    protected abstract void onSuccess(T response);

    protected abstract void onFail();
}
