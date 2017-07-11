package com.samson.rivers_lakes.lower.utils

import android.widget.ImageView

import com.bumptech.glide.Glide
import com.samson.rivers_lakes.R

/**
 * 类描述：Glide图片加载
 * 创建人：sam
 * 创建时间：2016/11/16 10:22
 * 邮箱：yhq1913@sina.com
 */
object GlideUtil {

    /**
     * 图片加载（网络路径

     * @作者 :	sam
     * *
     * @创建日期 :	2016/11/16 10:25
     */
    fun load(url: String, imageView: ImageView) {
        Glide.with(AppUtils.appContext)
                .load(url)
                .centerCrop()//占位符
                .thumbnail(.1f)//缩略图
                .bitmapTransform(GlideRoundTransform(AppUtils.appContext, 5))
                .placeholder(R.mipmap.post_image_loding)
                .error(R.mipmap.post_image_loading_failed)
                .into(imageView)
    }

    /**
     * 图片加载（资源图片

     * @作者 :	sam
     * *
     * @创建日期 :	2016/11/16 10:25
     */
    fun load(resId: Int, imageView: ImageView) {
        Glide.with(AppUtils.appContext)
                .load(resId)
                .centerCrop()//占位符
                .thumbnail(0.1f)//缩略图
                .bitmapTransform(GlideRoundTransform(AppUtils.appContext, 5))
                .placeholder(R.mipmap.post_image_loding)
                .error(R.mipmap.post_image_loading_failed)
                .into(imageView)
    }
}
