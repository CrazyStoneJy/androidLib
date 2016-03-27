package com.crazystone.test.http;

import android.os.Bundle;
import android.widget.TextView;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.utils.NetWorkParams;
import com.crazystone.utils.quickdev.annotation.SetContentView;
import com.crazystone.utils.quickdev.annotation.ViewInject;
import com.crazystone.test.R;
import com.crazystone.utils.BaseActivity;
import com.crazystone.utils.common.UIUtils;

/**
 * Created by crazystone on 2016/3/7.
 */
@SetContentView(R.layout.activity_http)
public class HttpTestActivity extends BaseActivity {

    public static final String API_KEY = "b86c75622f3d61148099949ff0a97907";
    public static final String url = "apistore/idservice/id";

    @ViewInject(R.id.http_txt)
    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getNetData();
    }

    public void getNetData() {
        network(url, new NetWorkParams().put("id", "142731199206290012"), IDCardModl.class, new Response.Listener<IDCardModl>() {
            @Override
            public void onResponse(IDCardModl response) {
                txt.setText("addresss:" + response.getRetData().getAddress() + "\t" + "birthday:" + response.getRetData().getBirthday() + "\tsex:" + response.getRetData().getSex());
                UIUtils.longToast(HttpTestActivity.this, response.getRetData().getAddress());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
    }


}
