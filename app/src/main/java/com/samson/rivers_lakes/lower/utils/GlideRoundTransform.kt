package com.samson.rivers_lakes.lower.utils

import android.content.Context
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapShader
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation

/**
 * 类描述：
 * 创建人：sam
 * 创建时间：2016/11/16 11:02
 * 邮箱：yhq1913@sina.com
 */
class GlideRoundTransform @JvmOverloads constructor(context: Context?, dp: Int = 100) : BitmapTransformation(context) {
    private val radius = 0f

    init {
//        this.radius = Resources.getSystem().displayMetrics.density * dp
    }

    override fun transform(pool: BitmapPool, toTransform: Bitmap, outWidth: Int, outHeight: Int): Bitmap? {
        return roundCrop(pool, toTransform)
    }

    private fun roundCrop(pool: BitmapPool, source: Bitmap?): Bitmap? {
        if (source == null) return null

        var result: Bitmap? = pool.get(source.width, source.height, Bitmap.Config.ARGB_8888)
        if (result == null) {
            result = Bitmap.createBitmap(source.width, source.height, Bitmap.Config.ARGB_8888)
        }
        val canvas = Canvas(result)
        val paint = Paint()
//        paint.shader = BitmapShader(source, BitmapShader!!.TileMode.CLAMP, BitmapShader.TileMode.CLAMP)
        paint.isAntiAlias = true
        val rectF = RectF(0f, 0f, source.width.toFloat(), source.height.toFloat())
        canvas.drawRoundRect(rectF, radius, radius, paint)
        return result
    }

    override fun getId(): String {
        return javaClass.name + Math.round(radius)
    }
}
