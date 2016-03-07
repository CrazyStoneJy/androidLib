package com.crazystone.test.http;

import android.os.Bundle;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.GsonRequest;
import com.android.volley.toolbox.Volley;
import com.android.volley.utils.NetWorkParams;
import com.crazystone.utils.BaseActivity;

/**
 * Created by crazystone on 2016/3/7.
 */
public class HttpTestActivity extends BaseActivity {

    public static final String url = "http://192.168.1.32/api/client/standerproductfund/showstanderproductfund?productId=924";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    public void getNetData() {
//        RequestQueue queue = Volley.newRequestQueue(this);
//        GsonRequest<ResponseModel> request = new GsonRequest<ResponseModel>(url, ResponseModel.class, new NetWorkParams().build(), new Response.Listener<ResponseModel>() {
//            @Override
//            public void onResponse(ResponseModel response) {
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        });
//        queue.add(request);


    }

}
