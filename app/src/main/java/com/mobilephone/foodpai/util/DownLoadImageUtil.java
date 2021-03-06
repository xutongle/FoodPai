package com.mobilephone.foodpai.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.mobilephone.foodpai.R;


/**
 * Gilde网络下载图片和动图（带自动缓存）
 * Created by qf on 2016/10/25.
 */
public class DownLoadImageUtil {

    /**
     * 下载图片
     *
     * @param context     上下文，with中可以放context、activity、fragment。。；当放activity、fragment时glide会根据生命周期来加载图片
     * @param url         图片地址
     * @param placeholder 占位符
     * @param error       失败图片
     * @param view        显示的控件
     */
    public static void load(Context context, String url, @Nullable int placeholder, @Nullable int error, ImageView view) {
        Glide.with(context)
                .load(url)
                .centerCrop()
                .placeholder(placeholder)
                .error(error)
                .skipMemoryCache(true)
                .into(view);
    }

    /**
     *
     * @param context 上下文with中可以放context、activity、fragment。。；当放activity、fragment时glide会根据生命周期来加载图片
     * @param url 图片地址
     * @param error 失败图片
     * @param view 显示的控件
     */
    public static void noCacheLoad(Context context,String url,int error,ImageView view){
        Glide.with(context)
                .load(url)
                .centerCrop()
                .error(error)
                .skipMemoryCache(true)
                .into(view);

}

    /**
     * 下载图片二，效果与上一方法一致，只修改了显示图片的方式.fitCenter()
     * @param context
     * @param url
     * @param placeholder
     * @param error
     * @param view
     */
    public static void loadImg(Context context, String url, @Nullable int placeholder,@Nullable int error, ImageView view){
        Glide.with(context)
                .load(url)
                .fitCenter()
                .placeholder(placeholder)
                .error(error)
                .skipMemoryCache(true)
                .into(view);
    }

    /**
     * 下载、显示GIF动图
     *
     * @param context
     * @param url
     * @param Placeholder
     * @param view
     */
    public static void load(Context context, String url, int Placeholder, ImageView view) {
        if (url.endsWith(".gif")) {
            Glide.with(context)
                    .load(url)
                    .asGif()
                    .placeholder(R.mipmap.ic_launcher)
                    .skipMemoryCache(true)
                    .into(view);
        } else {
            Glide.with(context)
                    .load(url)
                    .placeholder(Placeholder)
                    .skipMemoryCache(true)
                    .into(view);
        }

    }

    /**
     * 获取Bitmap资源
     *
     * @param context
     * @param url
     * @param placeholder
     * @param error
     * @param target      用来回调  获取Bitmap资源
     */
    public static void load(Context context, String url, @Nullable Drawable placeholder, @Nullable Drawable error, SimpleTarget<Bitmap> target) {
        Glide.with(context)
                .load(url)
                .asBitmap()
                .placeholder(placeholder)
                .error(error)
                .skipMemoryCache(true)
                .into(target);
    }
}
