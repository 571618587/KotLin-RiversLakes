package com.samson.rivers_lakes.presentation.activities

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.view.Gravity
import com.samson.rivers_lakes.R
import com.samson.rivers_lakes.lower.base.BaseActivity
import com.samson.rivers_lakes.lower.utils.LogUtil
import kotlinx.android.synthetic.main.activity_register.*
import rx.Observable
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers


class RegisterActivity : BaseActivity() {
    var dialog: AlertDialog? = null
    override fun onLoadLayout(): Int {
        return R.layout.activity_register
    }

    override fun initOptions() {
        super.initOptions()
        setTitle("注册")
    }

    override fun initView() {
        Observable.create(object : Observable.OnSubscribe<String> {
            override fun call(subscriber: Subscriber<in String>) {
                LogUtil.e("----flatMap---" + Thread.currentThread().name)
                Thread.sleep(500)
                subscriber.onNext("")
                subscriber.onCompleted()
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    //                    ToastUtil.show("---test--")
                    LogUtil.e("---subscribe--s--" + Thread.currentThread().name)
//                    rulesPw = RulesPopupWindow(this, View.OnClickListener {
//                        checkbox_rules.isChecked = true
//                    })
//                    rulesPw?.showAtLocation(findViewById(R.id.activity_register), Gravity.CENTER, 0, 0)
                    dialog = AlertDialog.Builder(RegisterActivity@ this).create()
                    dialog?.show()
                    dialog?.setCancelable(false)
                    val window = dialog?.window
                    window?.setGravity(Gravity.CENTER_VERTICAL or Gravity.CENTER_HORIZONTAL)
                    window?.setContentView(R.layout.layout_regiest_dialog)
                    var btnAgreeRules = window?.findViewById(R.id.btn_agree_rules)
                    btnAgreeRules?.setOnClickListener { view ->
                        checkbox_rules.isChecked = true
                        //关闭
                        dialog?.dismiss()
                    }
                })
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onBackPressed() {
        if (dialog != null && dialog!!.isShowing)
            return
        super.onBackPressed()
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
    }


    override fun setEvent() {
        btn_register.setOnClickListener { view ->
            LoginActivity.start(this)
            finish()
        }
    }

    companion object {
        fun start(content: Context) {
            val intent = Intent(content, RegisterActivity::class.java)
            content.startActivity(intent)
        }
    }


}
