package com.samson.rivers_lakes.api

import android.app.Application

import com.samson.rivers_lakes.lower.entities.AppUser
import com.samson.rivers_lakes.lower.utils.net.BaseResponseFunc

import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * 类描述：网络访问
 * 创建人：sam
 * 创建时间：2016/10/26 18:09
 * 邮箱：yhq1913@sina.com
 */
class ApiManager(private val apiService: ApiService, private val application: Application) {

    //样例
    //    public void login(String username, String password,SimpleCallback<User> simpleCallback){
    //        apiService.login(username,password)
    //                .flatMap(new BaseResponseFunc<User>())
    //                .subscribeOn(Schedulers.io())
    //                .observeOn(AndroidSchedulers.mainThread())
    //                .subscribe(new ExceptionSubscriber<User>(simpleCallback,application));
    //    }

    //登陆
    fun login(data: String, simpleCallBack: SimpleCallBack<AppUser>) {
        apiService.login(data)
                .flatMap(BaseResponseFunc<AppUser>())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(ExceptionSubscriber(simpleCallBack, application))
    }

}
