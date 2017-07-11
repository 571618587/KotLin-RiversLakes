package com.samson.rivers_lakes.lower.utils.net

import rx.Observable
import rx.functions.Func1

/**
 * 类描述：判断访问返回结果是否正确
 * 创建人：sam
 * 创建时间：2016/10/26 19:48
 * 邮箱：yhq1913@sina.com
 */
class BaseResponseFunc<T> : Func1<BaseResponse<T>, Observable<T>> {
    override fun call(tBaseResponse: BaseResponse<T>): Observable<T> {
        //遇到非200错误统一处理,将BaseResponse转换成您想要的对象
        if (tBaseResponse.ret != BaseResponseCode.SUCCESS) {
            return Observable.error<T>(Throwable(tBaseResponse.desc))
        } else {
            return Observable.just(tBaseResponse.result)
        }
    }
}
