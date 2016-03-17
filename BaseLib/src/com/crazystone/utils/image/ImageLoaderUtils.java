package com.crazystone.utils.image;

import android.content.Context;
import android.os.StrictMode;
import android.widget.ImageView;
import com.crazystone.annotation.ResId;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.UsingFreqLimitedMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.decode.BaseImageDecoder;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.utils.StorageUtils;

import java.io.File;

/**
 * 使用前先调用单例模式，
 * 再调用init(Context context)
 *
 * @see #init(Context)
 * 最后在显示图片setImageUrl()
 * Created by crazystone on 2016/3/11.
 */
public class ImageLoaderUtils {

    private static ImageLoaderUtils mUtils = null;
    /*  线程池中最大的线程数  **/
    public static final int MAX_THRED = Runtime.getRuntime().availableProcessors() * 2;
    /*   图片的最大高度     **/
    public static final int MAX_BITMAP_HEIGHT = 800;
    /*   图片的最大宽度   **/
    public static final int MAX_BITMAP_WIDTH = 400;
    /*   缓存在内存中的size **/
    public static final int MAX_MEMORY_CACHE_SIZE = 2 * 1024 * 1024;
    /*   缓存在sdcrad中的最大值   **/
    public static final int MAX_DISK_CACHE_SIZE = 50 * 1024 * 1024;
    /*   sdcrad图片缓存的路径   **/
    public static final String DISK_CACHE_PATH = "image/cache";
    /*  下载器的最大连接时长  **/
    public static final int DOWNLOADER_CONNECT_TIMEOUT = 5 * 1000;
    /*   下载器的最小连接时长  **/
    public static final int DOWNLOADER_READ_TIMEOUT = 5 * 1000;

    public static ImageLoader mImageLoader = null;

    private ImageLoaderUtils() {
    }

    public static ImageLoaderUtils getInstance() {
        if (mUtils == null) {
            synchronized (ImageLoaderUtils.class) {
                if (mUtils == null) {
                    mUtils = new ImageLoaderUtils();
                }
            }
        }
        return mUtils;
    }

    /***
     * 初始化imageloader的配置
     *
     * @param context
     */
    public void init(Context context) {
        mImageLoader = ImageLoader.getInstance();
        File cachePath = StorageUtils.getOwnCacheDirectory(context, DISK_CACHE_PATH);
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context).
                threadPriority(Thread.MIN_PRIORITY).  //设置线程优先级
                imageDownloader(new BaseImageDownloader(context, DOWNLOADER_CONNECT_TIMEOUT, DOWNLOADER_READ_TIMEOUT)). //设置下载器的连接，读取时长
                imageDecoder(new BaseImageDecoder(true)).  //bool变量是是否开启logcat
                threadPoolSize(MAX_THRED).   //线程池的最大线程数
                tasksProcessingOrder(QueueProcessingType.FIFO).
                memoryCacheExtraOptions(MAX_BITMAP_WIDTH, MAX_BITMAP_HEIGHT).   //存储图片的最大长度，宽度
                denyCacheImageMultipleSizesInMemory().   //
                memoryCache(new UsingFreqLimitedMemoryCache(MAX_MEMORY_CACHE_SIZE)).  //内存缓存的方式
                memoryCacheSize(MAX_MEMORY_CACHE_SIZE).    //内存缓存的最大值
                diskCache(new UnlimitedDiskCache(cachePath)).  //sdcard缓存的方式和路径
                diskCacheSize(MAX_DISK_CACHE_SIZE).   //sdcard缓存大小
                diskCacheFileNameGenerator(new Md5FileNameGenerator()).build();    //sdcard缓存的文件名用MD5加密

        mImageLoader.init(config);
    }


    public <E extends ImageView> void setImageUrl(Context context, String url, E imageview) {
        setImageUrl(context, url, imageview, 0, 0, 0);
    }


    public <E extends ImageView> void setImageUrl(Context context, String url, E imageView, int onLoadingResId, int onFailResId, int onEmptyResId) {
        if (mImageLoader == null) init(context);
        if (imageView instanceof ImageView) {
            mImageLoader.displayImage(url, imageView, configDisplayOptions(DisplayType.DEFALUT,onLoadingResId, onFailResId, onEmptyResId));
        } else {
            throw new ClassCastException("you view can not be casted ImageView");
        }
    }


    /***
     * 配置imageloader的显示选项
     *
     * @return DisplayImageOptions
     */
    private static DisplayImageOptions configDisplayOptions(DisplayType type, int onladingResId, int onFailResId, int onEmptyResId) {

        DisplayImageOptions options = new DisplayImageOptions.Builder().
                showImageOnLoading(onladingResId).
                showImageOnFail(onFailResId).
                displayer(new SimpleBitmapDisplayer()).  //可修改多种显示类型（圆，圆角矩形，默认）
                showImageForEmptyUri(onEmptyResId).
                cacheInMemory(true).   //true支持缓存在内存
                cacheOnDisk(true).   //true支持缓存在sdcard
                build();
        return options;
    }

}
