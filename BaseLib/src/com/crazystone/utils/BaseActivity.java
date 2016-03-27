package com.crazystone.utils;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.GsonRequest;
import com.android.volley.utils.NetWorkParams;
import com.android.volley.utils.NetWorkUtils;
import com.crazystone.utils.quickdev.ViewInjectUtils;

import java.util.Map;

public class BaseActivity extends Activity implements OnClickListener {

//    /**
//     * findviewbyid
//     *
//     * @param id 资源地址
//     * @return
//     */
//    public <T extends View> T $(int id) {
//        return (T) (findViewById(id));
//    }


    /**
     * 给view设置监听事件
     *
     * @param views view数组
     */
    public void $(View... views) {
        for (View view : views) {
            view.setOnClickListener(this);
        }
    }


    @Override
    public void onClick(View view) {

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewInjectUtils.inject(this);
    }

    /**
     * 发送网络请求
     *
     * @param url
     * @param params
     * @param clazz
     * @param listener
     * @param errorListener
     * @param <T>
     * @return
     */
    protected <T> Request<T> network(String url, NetWorkParams params, Class<T> clazz,
                                     Response.Listener<T> listener, Response.ErrorListener errorListener) {
        NetWorkUtils utils = NetWorkUtils.getInstance();
        utils.init(this);
        GsonRequest<T> request = new GsonRequest<T>(url, params, clazz, listener, errorListener);
        utils.addRequest(this, request);
        return request;
    }


    /**
     * 发送网络请求
     * @param url
     * @param params
     * @param clazz
     * @param listener
     * @param errorListener
     * @param <T>
     * @return
     */
    protected <T> Request<T> network(String url, Map<String, Object> params, Class<T> clazz,
                                     Response.Listener<T> listener, Response.ErrorListener errorListener) {
        NetWorkUtils utils = NetWorkUtils.getInstance(this);
        utils.init(this);
        GsonRequest<T> request = new GsonRequest<T>(url, params, clazz, listener, errorListener);
        utils.addRequest(this, request);
        return request;
    }

    /**
     * 取消网络请求
     *
     * @param request
     * @param <T>
     */
    protected <T> void cancelRequest(Request<T> request) {
        if (!request.isCanceled()) request.cancel();
    }


}
