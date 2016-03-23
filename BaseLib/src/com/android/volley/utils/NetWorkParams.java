package com.android.volley.utils;

import android.content.Context;
import android.content.res.Resources;
import com.android.volley.NetworkResponse;
import com.crazystone.utils.common.L;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

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

    /**
     * 通过URL和参数来生成新的带参数的URL
     *
     * @param url URL不带参数
     * @param map URL需传的参数
     * @return 生成后的URL
     */
    public static String generateUrl(String url, Map<String, Object> map) {
        StringBuffer sb = new StringBuffer();
        sb.append(NetWorkUtils.HOST).append(url).append("?");
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            sb.append(entry.getKey()).
                    append("=").
                    append(entry.getValue().toString()).
                    append("&");
        }
        sb.append("t").append("=").append(new Date().getTime());
        L.d("network url:" + sb.toString());
        return sb.toString();
    }


}
