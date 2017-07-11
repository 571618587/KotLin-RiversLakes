/**
 * @描述 :
 * *
 * @作�?? :Android - csx
 * *
 * @创建日期 :2016�?3�?12�? 上午11:18:12
 */
package com.samson.rivers_lakes.lower.utils

import android.content.res.Resources.NotFoundException
import android.os.Handler
import android.widget.Toast

/**
 * @描述 :Toast工具类
 * *
 * @作�?? :Android - samson
 * *
 * @创建日期 :2016�?3�?12�? 上午11:18:12
 */
object ToastUtil {

    private var mToast: Toast? = null
    private val mHandler = Handler()
    private val r = Runnable { mToast!!.cancel() }

    fun makeText(text: String) {
        try {
            mHandler.removeCallbacks(r)
            if (mToast != null)
                mToast!!.setText(text)
            else
                mToast = Toast.makeText(AppUtils.appContext, text, Toast.LENGTH_LONG)
            mHandler.postDelayed(r, 1000)

            mToast!!.show()
        } catch (e: Exception) {
        }

    }

    fun makeText(resId: Int) {
        try {
            makeText(AppUtils.appContext!!.resources.getString(resId))
        } catch (e: NotFoundException) {
        }

    }


    /**

     * @描述 :文字提示
     * *
     * @方法名称 :show----&gt;ToastUtil.java
     * *
     * @作�?? :Android - csx
     * *
     * @创建日期 :2016�?3�?12�? 上午11:25:12
     * *
     * @param txt
     */
    fun show(txt: String) {
        makeText(txt)
    }

    /**

     * @描述 :id提示
     * *
     * @方法名称 :show----&gt;ToastUtil.java
     * *
     * @作�?? :Android - csx
     * *
     * @创建日期 :2016�?3�?12�? 上午11:25:47
     * *
     * @param resId
     */
    fun show(resId: Int) {
        makeText(resId)
    }

}
