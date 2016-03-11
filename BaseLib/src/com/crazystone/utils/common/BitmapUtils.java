package com.crazystone.utils.common;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;

import java.io.File;
import java.io.IOException;

/**
 * Created by crazystone on 2016/3/9.
 */
public class BitmapUtils {

    public static Bitmap getBitmapFromFile(String filePath) {
        Bitmap bitmap = null;
//        // 获取图片的宽和高
//        BitmapFactory.Options options = new BitmapFactory.Options();
//        options.inJustDecodeBounds = true;
//        BitmapFactory.decodeFile(filePath, options);
//
//        // 压缩图片
//        options.inSampleSize = Math.max(1, (int) (Math.max(
//                (double) options.outWidth,
//                (double) options.outHeight)));
//        options.inJustDecodeBounds = false;

        bitmap = BitmapFactory.decodeFile(filePath);

        return bitmap;
    }


    /**
     * 压缩图
     */
    public static Bitmap getBitmapConsiderExif(String imagePath) {

        // 获取照相后的bitmap
        //Bitmap tmpBitmap = BitmapFactory.decodeFile(imagePath);
        Bitmap tmpBitmap = getBitMap(imagePath, 800);
        if (tmpBitmap == null)
            return null;
        Matrix matrix = new Matrix();
        matrix.postRotate(readPictureDegree(imagePath));
        tmpBitmap = Bitmap.createBitmap(tmpBitmap, 0, 0, tmpBitmap.getWidth(),
                tmpBitmap.getHeight(), matrix, true);
        tmpBitmap = tmpBitmap.copy(Bitmap.Config.ARGB_8888, true);

        int hight = tmpBitmap.getHeight() > tmpBitmap.getWidth() ? tmpBitmap
                .getHeight() : tmpBitmap.getWidth();

        float scale = hight / 800.0f;

        if (scale > 1) {
            tmpBitmap = Bitmap.createScaledBitmap(tmpBitmap,
                    (int) (tmpBitmap.getWidth() / scale),
                    (int) (tmpBitmap.getHeight() / scale), false);
        }
        return tmpBitmap;
    }


    private static Bitmap getBitMap(String fileSrc, int dstWidth) {
        if (dstWidth == -1) {
            return BitmapFactory.decodeFile(fileSrc);
        }
        // 获取图片的宽和高
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(fileSrc, options);

        // 压缩图片
        options.inSampleSize = Math.max(1, (int) (Math.max(
                (double) options.outWidth / dstWidth,
                (double) options.outHeight / dstWidth)));
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(fileSrc, options);
    }


    /**
     * 读取图片属性：旋转的角度
     *
     * @param path
     *            图片绝对路径
     * @return degree旋转的角度
     */
    public static int readPictureDegree(String path) {
        int degree = 0;
        try {
            ExifInterface exifInterface = new ExifInterface(path);
            int orientation = exifInterface.getAttributeInt(
                    ExifInterface.TAG_ORIENTATION,
                    ExifInterface.ORIENTATION_NORMAL);
            switch (orientation) {
                case ExifInterface.ORIENTATION_ROTATE_90:
                    degree = 90;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_180:
                    degree = 180;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_270:
                    degree = 270;
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return degree;
    }
}
