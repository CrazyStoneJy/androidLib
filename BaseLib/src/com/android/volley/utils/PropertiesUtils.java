package com.android.volley.utils;

import android.content.Context;
import android.content.res.Resources;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by crazystone on 2016/3/23.
 */
public class PropertiesUtils {

    private static final String CONFOG_NAME = "config";

    public static String getHost(Context context) {
        String http = "";
        try {
            Properties properties = new Properties();
            Resources resources = context.getResources();
            int resId = resources.getIdentifier(CONFOG_NAME, "raw", context.getPackageName());
            InputStream is = resources.openRawResource(resId);
            properties.load(is);
            http = properties.getProperty("api.host");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return http;
    }

}
