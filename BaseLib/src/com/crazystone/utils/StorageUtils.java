package com.crazystone.utils;

import android.content.Context;
import android.os.Environment;
import com.crazystone.utils.common.L;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * sdcrad存储的utils
 * Created by crazystone on 2016/3/8.
 */
public class StorageUtils {

    public static final String PATH = "photo";
    public static final int MEDIA_TYPE_IMAGE = 1,
            MEDIA_TYPE_VIDEO = 2;
//    public static String imgPath;

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

    @Deprecated
    public static File getExternalFile() {
        File file = null;
        if (isExternalStorageWritable()) {
            file = Environment.getExternalStorageDirectory();
        }
        return file;
    }

    @Deprecated
    public static File getExternalFile(String path) {
        File file = null;
        StringBuilder sb = new StringBuilder();
        if (isExternalStorageWritable()) {
            String originalPath = Environment.getExternalStorageDirectory().getAbsolutePath();
            L.d("Orignal path:" + originalPath);
            sb.append(originalPath).append("/").append(PATH).append("/").append(path);
            L.d("photo path:" + sb.toString());
            file = new File(sb.toString());
            if (!file.exists()) try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }


    public static File getExternalFile(Context context, int type) {
        if (isExternalStorageWritable()) {
//            File orignalFile = context.getExternalFilesDir("myphotos");
            File orignalFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "myPhotos");
            if (!orignalFile.exists()) {
                if (!orignalFile.mkdirs()) {
                    L.d("has not this img path");
                    return null;
                }
            }

            File externalFile = null;
            String temp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            StringBuilder sb = new StringBuilder();
            if (type == MEDIA_TYPE_IMAGE) {
                if (sb.length() > 0) sb.delete(0, sb.length());
                sb.append(orignalFile.getPath() + File.separator + "img_" + temp + ".jpg");
            } else if (type == MEDIA_TYPE_VIDEO) {
                sb.append(orignalFile.getPath() + File.separator + "div_" + temp + ".mp4");
            }
            L.d("my photos path:" + sb.toString());
            externalFile = new File(sb.toString());
            return externalFile;
        }
        return null;
    }


}
