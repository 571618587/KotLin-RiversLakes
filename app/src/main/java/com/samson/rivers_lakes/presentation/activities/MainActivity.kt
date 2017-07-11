package com.samson.rivers_lakes.presentation.activities

import android.content.Context
import android.content.Intent

import android.os.Build
import android.util.DisplayMetrics
import android.view.Display
import android.view.WindowManager
import com.alibaba.fastjson.JSON
import com.samson.rivers_lakes.AppApplication
import com.samson.rivers_lakes.R
import com.samson.rivers_lakes.lower.base.BaseActivity
import com.samson.rivers_lakes.lower.db.dao.AppUserDao
import com.samson.rivers_lakes.lower.entities.AppUser
import com.samson.rivers_lakes.lower.utils.*
import com.samson.rivers_lakes.presentation.presenters.MainPresenter
import com.samson.rivers_lakes.presentation.views.MainView
import com.squareup.leakcanary.RefWatcher
import kotlinx.android.synthetic.main.activity_main.*

import java.util.Date
import java.util.HashMap


class MainActivity : BaseActivity(), MainView {

    override fun onDestroy() {
        super.onDestroy()
        //在自己的应用初始Activity中加入如下两行代码
        val refWatcher = AppApplication.getRefWatcher(this)
        refWatcher!!.watch(this)
    }


    override fun initReceiver() {
        super.initReceiver()
    }


    override fun initView() {
        super.initView()
        main_text.text = "Hello KotLin"
    }

    override fun initOptions() {
        val appUserJson = PreferencesUtils.getString("AppUser", "")
        //将json转换为对象
        val appUser = JSON.parseObject(appUserJson, AppUser::class.java)
        if (appUser == null) {
            LoginActivity.start(this)
        }
        setTitle("项目框架")
    }


    override fun onLoadLayout(): Int {
        return R.layout.activity_main
    }

    override fun initData() {
        //        AppUser appUser = new AppUser();
        //        appUser.setUserAccount("17319311613");
        //        appUser.setUserPwd("E10ADC3949BA59ABBE56E057F20F883E");
        //        String json = AppUtils.getJson(AppUtils.getJsonMap(appUser), appUser, null, null);
        //        mainPresenter.login(json);

    }


    override fun onSuccess(appUser: AppUser) {
    }

    companion object {
        /**
         * 启动Activity
         * @param context
         */
        fun startActivity(context: Context) {
            val intent = Intent(context, MainActivity::class.java)
            //清除MainActivity之上的活动，相当于SingleTask
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            context.startActivity(intent)
        }
    }
}
