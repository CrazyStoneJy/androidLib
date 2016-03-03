package com.crazystone.quickdev;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.crazystone.quickdev.annotation.SetContentView;
import com.crazystone.quickdev.annotation.ViewInject;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by crazystone on 2015/12/31.
 */
public class ViewInjectUtils {

    public static final String SET_CONTENT_VIEW = "setContentView";
    public static final String FIND_VIEW_BY_ID = "findViewById";

    public static void inject(Activity aty) {
        injectContentView(aty);
        injectView(aty);
    }


    /**
     * 注入普通的view
     *
     * @param aty
     */
    public static void injectView(Activity aty) {
        Class<? extends Activity> cls = aty.getClass();
        //获取activity中申明的字段
        Field[] fields = cls.getDeclaredFields();
        Log.i("TAG", ">>>>>>>>>>>>>>fiels size:" + fields.length);
        for (Field field : fields) {
            //判断该field中是否有viewInject注解
            ViewInject anno = field.getAnnotation(ViewInject.class);
            if (anno != null) {
                int viewId = anno.value();
                if (viewId != -1) {
                    try {
                        Method method = cls.getMethod(FIND_VIEW_BY_ID, int.class);
                        Object view = method.invoke(aty, viewId);
                        field.setAccessible(true);
                        field.set(aty, view);
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * 注入setContentView()
     *
     * @param aty
     */
    public static void injectContentView(Activity aty) {

        Class<? extends Activity> cls = aty.getClass();
        if (cls.isAnnotationPresent(SetContentView.class)) {
            SetContentView anno = cls.getAnnotation(SetContentView.class);
            if (anno != null) {
                int layoutId = anno.value();
                try {
                    Method method = cls.getMethod(SET_CONTENT_VIEW, int.class);
                    method.setAccessible(true);
                    method.invoke(aty, layoutId);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
