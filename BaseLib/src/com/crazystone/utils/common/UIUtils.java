package com.crazystone.utils.common;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by crazystone on 2016/3/8.
 */
public class UIUtils {

    public static final int SHORT_TIME = 3000, LONG_TIME = 5000;

    public static void shortToast(Context context, String msg) {
        toast(context, msg, SHORT_TIME);
    }

    public static void shortToast(Context context, int resId) {
        toast(context, context.getResources().getString(resId), SHORT_TIME);
    }

    public static void longToast(Context context, String msg) {
        toast(context, msg, LONG_TIME);
    }

    public static void longToast(Context context, int resId) {
        toast(context, context.getResources().getString(resId), LONG_TIME);
    }

    public static void toast(Context context, CharSequence msg, int duartion) {
        Toast.makeText(context, msg, duartion).show();
    }


}
