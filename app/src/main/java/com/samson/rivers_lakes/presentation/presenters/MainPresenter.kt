package com.samson.rivers_lakes.presentation.presenters

import com.samson.rivers_lakes.api.ApiManager
import com.samson.rivers_lakes.api.SimpleCallBack
import com.samson.rivers_lakes.lower.entities.AppUser
import com.samson.rivers_lakes.presentation.views.MainView

/**
 * 类描述：主页面中间者
 * 创建人：sam
 * 创建时间：2016/10/26 21:16
 * 邮箱：yhq1913@sina.com
 */
class MainPresenter(private val mainView: MainView, private val apiManager: ApiManager) {

    /**
     * 登陆

     * @作者 :	sam
     * *
     * @创建日期 :	2016/11/16 17:40
     */
    fun login(data: String) {
        apiManager.login(data, object : SimpleCallBack<AppUser> {
            override fun onStart() {
                mainView.toShowLoading("")
            }

            override fun onNext(appUser: AppUser) {
                mainView.onSuccess(appUser)
            }

            override fun onComplete() {
                mainView.toHideLoading()
            }
        })
    }

}
