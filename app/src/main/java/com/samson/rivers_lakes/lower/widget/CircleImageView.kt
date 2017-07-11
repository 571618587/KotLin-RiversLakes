package com.samson.rivers_lakes.lower.widget

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PorterDuff
import android.graphics.PorterDuffXfermode
import android.graphics.Rect
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.widget.ImageView

/**
 * Created by zz on 2016/7/18.
 */
class CircleImageView : ImageView {
    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun onDraw(canvas: Canvas) {
        val drawable = drawable
        if (drawable is BitmapDrawable) {
            val bmp = drawable.bitmap
            if (bmp != null) {
                canvas.drawBitmap(createCircle(bmp), 0f, 0f, null)
            } else {
                super.onDraw(canvas)
            }
        } else {
            super.onDraw(canvas)
        }
    }

    private fun createCircle(src: Bitmap): Bitmap {
        val size = if (width > height) height else width
        val bmp = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bmp)
        val paint = Paint()
        paint.isAntiAlias = true
        paint.style = Paint.Style.FILL
        paint.color = Color.WHITE
        canvas.drawARGB(0, 0, 0, 0)
        canvas.drawCircle(size / 2f, size / 2f, size / 2f, paint)
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
        val srcRect = Rect(0, 0, src.width, src.height)
        val dstRect = Rect(0, 0, size, size)
        canvas.drawBitmap(src, srcRect, dstRect, paint)
        return bmp
    }
}
