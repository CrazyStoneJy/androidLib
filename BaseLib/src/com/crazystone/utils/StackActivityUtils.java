package com.crazystone.utils;

import java.util.Stack;

import android.app.Activity;

/**
 * 这是一个控制activity finish的一个工具类(用stack控制)
 *
 * @author crazystone
 *         <p/>
 *         2015-12-11
 */
public class StackActivityUtils {

    public static Stack<Activity> stack;

    /**
     * push activity
     *
     * @param aty
     */
    public static void pushActivity(Activity aty) {
        if (stack == null) {
            stack = new Stack<Activity>();
        }
        if (stack != null) {
            stack.push(aty);
        }
    }

    /**
     * finish stack顶端的activity
     * pop activity
     *
     * @return
     */
    public static void popActivity() {
        Activity aty = null;
        if (stack != null && !stack.isEmpty()) {
            aty = stack.pop();
            if (aty != null) {
                try {
                    aty.finish();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 清空stack中的所有activity
     */
    public static void clearAllActivity() {
        if (stack != null) {
            while (!stack.isEmpty()) {
                Activity aty = stack.pop();
                if (aty != null) {
                    try {
                        aty.finish();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            stack = null;
        }
    }

}
