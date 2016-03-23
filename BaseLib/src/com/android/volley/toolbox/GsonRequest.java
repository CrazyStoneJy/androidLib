package com.android.volley.toolbox;

import com.android.volley.*;
import com.android.volley.utils.NetWorkParams;
import com.crazystone.test.http.HttpTestActivity;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by crazystone on 2016/3/7.
 */
public class GsonRequest<T> extends Request<T> {

    private final Gson gson = new Gson();
    private final Class<T> clazz;
    private final Map<String, String> headers;
    private final Response.Listener<T> listener;

    /**
     * Make a GET request and return a parsed object from JSON.
     *
     * @param url     URL of the request to make
     * @param clazz   Relevant class object, for Gson's reflection
     * @param headers Map of request headers
     */
    public GsonRequest(String url, Class<T> clazz, Map<String, String> headers,
                       Response.Listener<T> listener, Response.ErrorListener errorListener) {
        super(Method.GET, url, errorListener);
        this.clazz = clazz;
        this.headers = headers;
        this.listener = listener;
    }

    public GsonRequest(String url, Class<T> clazz,
                       Response.Listener<T> listener, Response.ErrorListener errorListener) {

        this(url, clazz, null, listener, errorListener);
    }

    public GsonRequest(String url, Map<String, Object> params, Class<T> clazz,
                       Response.Listener<T> listener, Response.ErrorListener errorListener) {

        this(NetWorkParams.generateUrl(url, params), clazz, null, listener, errorListener);
    }

    public GsonRequest(String url, NetWorkParams params, Class<T> clazz,
                       Response.Listener<T> listener, Response.ErrorListener errorListener) {

        this(NetWorkParams.generateUrl(url, params.build()), clazz, null, listener, errorListener);
    }


    public GsonRequest(String url, NetWorkParams params,
                       Response.Listener<T> listener, Response.ErrorListener errorListener) {
        super(Method.GET, url, errorListener);
        this.clazz = null;
        this.headers = null;
        this.listener = listener;
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        Map<String, String> headers = new HashMap<String, String>();
        //fixme 用于测试百度API store的接口
        headers.put("apikey", HttpTestActivity.API_KEY);
        return headers != null ? headers : super.getHeaders();
    }

    @Override
    protected void deliverResponse(T response) {
        listener.onResponse(response);
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        try {
            String json = new String(
                    response.data,
                    HttpHeaderParser.parseCharset(response.headers));
            if (clazz != null) {
                if (clazz.isAssignableFrom(String.class)) {
                    return (Response<T>) Response.success(json, HttpHeaderParser.parseCacheHeaders(response));
                } else {
                    return Response.success(
                            gson.fromJson(json, clazz),
                            HttpHeaderParser.parseCacheHeaders(response));
                }
            } else {
                return (Response<T>) Response.success(json, HttpHeaderParser.parseCacheHeaders(response));
            }
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        } catch (JsonSyntaxException e) {
            return Response.error(new ParseError(e));
        }
    }


}
