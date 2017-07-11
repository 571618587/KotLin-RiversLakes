package com.samson.rivers_lakes.presentation.views

import com.samson.rivers_lakes.lower.base.BaseView
import com.samson.rivers_lakes.lower.entities.AppUser

/**
 * 类描述：主页面view接口
 * 创建人：sam
 * 创建时间：2016/10/26 20:40
 * 邮箱：yhq1913@sina.com
 */
interface MainView : BaseView {
    fun onSuccess(appUser: AppUser)
}
