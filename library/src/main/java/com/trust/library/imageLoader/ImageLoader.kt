package com.trust.library.imageLoader

import android.content.Context
import android.graphics.Bitmap
import android.widget.ImageView
import cn.jpush.android.imageloader.ImageLoader
import cn.jpush.android.imageloader.LoaderOptions
import cn.jpush.android.imageloader.listener.ImageListener
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import java.io.File

/**
 * Create by wangqingqing
 * On 2019/4/16 10:34
 * Copyright(c) 2018 极光
 * Description
 */
object ImageLoader {

    fun load(): LoaderOptions = ImageLoader.get().load()

    fun displayImage(context: Context, url: String, imageView: ImageView) {
        ImageLoader.get().load(url).context(context).into(imageView)
    }

    fun displayImage(context: Context, url: String, placeholder: Int, error: Int, imageView: ImageView) {
        ImageLoader.get().load(url).context(context).placeholder(placeholder).error(error).into(imageView)
    }

    fun displayImage(context: Context, url: String, placeholder: Int, imageView: ImageView) {
        ImageLoader.get()
                .load(url).context(context)
                .placeholder(placeholder).error(placeholder).dontAnimate().centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .into(imageView)
    }

    fun displayImage(context: Context, file: File, placeholder: Int, imageView: ImageView) {
        ImageLoader.get().load().context(context).setFile(file)
                .placeholder(placeholder).priority(Priority.HIGH).into(imageView)
    }

    fun downloadOnly(context: Context, url: String, listener: ImageListener<File>) {
        ImageLoader.get().downloadOnly(context, url, listener)
    }

    fun getBitmap(context: Context, url: String, listener: ImageListener<Bitmap>) {
        ImageLoader.get().getBitmap(context, url, listener)
    }

    fun trimMemory(context: Context, level: Int) {
        ImageLoader.get().trimMemory(context, level)
    }

    fun clearMemory(context: Context) {
        ImageLoader.get().clearMemory(context)
    }
}