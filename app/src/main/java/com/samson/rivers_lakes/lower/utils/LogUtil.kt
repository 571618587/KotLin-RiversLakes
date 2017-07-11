package com.samson.rivers_lakes.lower.utils

import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream
import java.io.PrintStream
import java.util.ArrayList

import android.util.Log

/**

 * @描述: 日志工具打印类
 * *
 * @作者: Android - samson
 * *
 * @创建日期: 2016年6月20日 下午4:48:19
 */
object LogUtil {

    private val isPrint = true
    private var isDebug = false

    val TAG = "samson"
    val MSG = "log msg is null."

    private var logList: MutableList<String>? = null

    init {
        // isPrint = ECApplication.getInstance().getLoggingSwitch();
    }

    fun v(tag: String, msg: String) {
        print(Log.VERBOSE, tag, msg)
    }

    fun v(msg: String) {
        v(TAG, msg)
    }

    fun d(tag: String, msg: String) {
        print(Log.DEBUG, tag, msg)
        print(isDebug, msg)
    }

    fun d(msg: String) {
        d(TAG, msg)
    }

    fun i(tag: String, msg: String) {
        print(Log.INFO, tag, msg)
    }

    fun i(msg: String) {
        i(TAG, msg)
    }

    fun w(tag: String, msg: String) {
        print(Log.WARN, tag, msg)
    }

    fun w(msg: String) {
        w(TAG, msg)
    }

    fun e(tag: String, msg: String) {
        print(Log.ERROR, tag, msg)
    }

    fun e(msg: String) {
        e(TAG, msg)
    }

    private fun print(mode: Int, tag: String, msg: String?) {
        if (!isPrint) {
            return
        }
        if (msg == null) {
            Log.e(tag, MSG)
            return
        }
        when (mode) {
            Log.VERBOSE -> Log.v(tag, msg)
            Log.DEBUG -> Log.d(tag, msg)
            Log.INFO -> Log.i(tag, msg)
            Log.WARN -> Log.w(tag, msg)
            Log.ERROR -> Log.e(tag, msg)
            else -> Log.d(tag, msg)
        }
    }

    private fun print(flag: Boolean, msg: String) {
        if (flag && logList != null) {
            logList!!.add(msg)
        }
    }

    fun setState(flag: Boolean) {
        if (flag) {
            if (logList == null) {
                logList = ArrayList<String>()
            } else {
                logList!!.clear()
            }
        } else {
            if (logList != null) {
                logList!!.clear()
                logList = null
            }
        }

        isDebug = flag
    }



    fun printErrorStackTrace(ex: Exception) {
        val f = File("/sdcard/Hisun/error.log")
        try {
            if (!f.exists()) {
                f.createNewFile()
            }
            ex.printStackTrace(PrintStream(f))
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    fun getLogUtilsTag(clazz: Class<out Any>): String {
        return LogUtil.TAG + "." + clazz.simpleName
    }
}
