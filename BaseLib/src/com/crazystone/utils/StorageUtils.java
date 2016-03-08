package com.crazystone.utils;

import android.content.Context;
import android.os.Environment;
import com.crazystone.utils.common.L;

import java.io.File;
import java.io.IOException;

/**
 * Created by crazystone on 2016/3/8.
 */
public class StorageUtils {

    public static final String PATH = "photo";
    public static String imgPath;

    /**
     * 判断sdcard是否可以写文件
     *
     * @return
     */
    public static boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED)) {
            return true;
        }
        return false;
    }

    /**
     * 判断sdcrad是否可以读文件
     *
     * @return
     */
    public static boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) || Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }


    public static File getExternalFile() {
        File file = null;
        if (isExternalStorageWritable()) {
            file = Environment.getExternalStorageDirectory();
        }
        return file;
    }

    public static File getExternalFile(String path) {
        File file = null;
        StringBuilder sb = new StringBuilder();
        if (isExternalStorageWritable()) {
            String originalPath = Environment.getExternalStorageDirectory().getAbsolutePath();
            L.d("Orignal path:" + originalPath);
            sb.append(originalPath).append("/").append(PATH).append("/").append(path);
            L.d("photo path:" + sb.toString());
            imgPath = sb.toString();
            file = new File(sb.toString());
            if (!file.exists()) try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }
}
