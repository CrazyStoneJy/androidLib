package com.android.volley.utils;

import com.android.volley.NetworkResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * 网络参数
 * Created by crazystone on 2016/3/7.
 */
public class NetWorkParams {

    private Map<String, Object> params;

    public NetWorkParams() {
        if (params == null) params = new HashMap<String, Object>();
    }

    public NetWorkParams put(String key, Object value) {
        params.put(key, value);
        return this;
    }

    public Map<String, Object> build() {
        return params;
    }
}
