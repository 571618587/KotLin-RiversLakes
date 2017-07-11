package com.samson.rivers_lakes.api

import android.app.Application
import android.widget.Toast

import java.net.ConnectException
import java.net.SocketTimeoutException

import rx.Subscriber

/**
 * 类描述：错误统一处理
 * 创建人：sam
 * 创建时间：2016/10/26 17:56
 * 邮箱：yhq1913@sina.com
 */
class ExceptionSubscriber<T>(private val simpleCallBack: SimpleCallBack<T>?, private val application: Application) : Subscriber<T>() {

    override fun onCompleted() {
        simpleCallBack?.onComplete()
    }

    override fun onError(e: Throwable) {
        e.printStackTrace()
        if (e is SocketTimeoutException) {
            Toast.makeText(application, "网络中断，请检查您的网络状态", Toast.LENGTH_SHORT).show()
        } else if (e is ConnectException) {
            Toast.makeText(application, "网络中断，请检查您的网络状态", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(application, e.message, Toast.LENGTH_SHORT).show()
        }
        simpleCallBack?.onComplete()
    }

    override fun onStart() {
        super.onStart()
        simpleCallBack?.onStart()
    }

    override fun onNext(t: T) {
        simpleCallBack?.onNext(t)
    }
}
