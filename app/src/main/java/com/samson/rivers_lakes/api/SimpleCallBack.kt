package com.samson.rivers_lakes.api

/**
 * 类描述：回调
 * 创建人：sam
 * 创建时间：2016/10/26 17:55
 * 邮箱：yhq1913@sina.com
 */
interface SimpleCallBack<T> {
    fun onStart()
    fun onNext(t: T)
    fun onComplete()

}
