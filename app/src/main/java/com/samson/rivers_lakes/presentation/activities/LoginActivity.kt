package com.samson.rivers_lakes.presentation.activities

import android.content.Context
import android.content.Intent
import android.view.View
import com.alibaba.fastjson.JSON
import com.samson.rivers_lakes.R
import com.samson.rivers_lakes.lower.base.BaseActivity
import com.samson.rivers_lakes.lower.entities.AppUser
import com.samson.rivers_lakes.lower.utils.PreferencesUtils
import com.samson.rivers_lakes.lower.utils.ToastUtil
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity(), View.OnClickListener {
    override fun onClick(view: View?) {
        when (view?.id) {
            btn_login.id -> login()
            btn_register.id -> {
                RegisterActivity.start(this)
            }
            img_qq.id -> ToastUtil.show("QQ")
            img_wechat.id -> ToastUtil.show("Wechat")
            show_forget_password.id -> ToastUtil.show("忘记密码")
        }
    }

    /**
     * 登录
     */
    fun login() {
        //获取用户名和密码
        val phone = edit_phone.text.toString()
        val password = edit_password.text.toString()
        if (phone.equals("13001104913") && password.equals("123456")) {
            ToastUtil.show("登录成功")
            var appUser = AppUser()
            appUser.userAccount = phone
            appUser.userId = phone
            PreferencesUtils.putString("AppUser", JSON.toJSONString(appUser))
            MainActivity.startActivity(this)
        } else {
            ToastUtil.show("登录失败，用户名或密码错误")
        }
    }

    override fun onLoadLayout(): Int {
        return R.layout.activity_login
    }

    override fun initOptions() {
        super.initOptions()
        setHeaderHide()
    }

    override fun setEvent() {
        super.setEvent()
        btn_login.setOnClickListener(this)
        btn_register.setOnClickListener(this)
        img_qq.setOnClickListener(this)
        img_wechat.setOnClickListener(this)
        show_forget_password.setOnClickListener(this)
    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, LoginActivity::class.java)
            context.startActivity(intent)
        }
    }
}
