package com.samson.rivers_lakes.lower.base

import android.content.Context
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.samson.rivers_lakes.R
import com.samson.rivers_lakes.lower.utils.Colors

/**
 * 类描述：BaseActivity
 * 创建人：sam
 * 创建时间：2016/10/26 20:10
 * 邮箱：yhq1913@sina.com
 */
abstract class BaseActivity : FragmentActivity(), BaseView {


    // 当前上下文
    var context: Context? = null
    // 左边ImageView返回
    private val ivBack: ImageView? = null
    // title
    private var tvTitle: TextView? = null
    // 头部的布局
    var toolbar: Toolbar? = null
    // 布局加载view
    private var loadingView: View? = null
    // 显示给用户看得布局
    private var showView: View? = null
    var isLoading: Boolean = false
    //当前是否是沉浸式标题栏
    protected var isImmersiveToolBar: Boolean = false
    // 整体跟布局
    var layout: LinearLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        super.onCreate(savedInstanceState)
        if (layout == null)
            layout = LinearLayout(this)
        // 布局竖向排列
        layout?.orientation = LinearLayout.VERTICAL
        // 初始化头部
        initHeaderView()
        // 初始化内容布局
        initContentView()
        // 设置布局
        setContentView(layout!!)
        // 初始化设置
        initOptions()
        // 初始化视图
        initView()
        //初始化Menu
        initMenu()
        //初始化广播
        initReceiver()
        // 设置监听
        setEvent()
        // 初始化数据
        initData()
        // 初始化适配器
        initAdapter()
        // 设置默认操作
        initDefault()
    }

    override fun toShowLoading(msg: String) {
        showLoading("msg")
    }

    override fun toHideLoading() {
        hindLoading()
    }

    /**
     * 初始化广播
     */
    open fun initReceiver() {

    }

    /**
     * 初始化Menu

     * @作者 :	sam
     * *
     * @创建日期 :	2016/11/6 17:00
     */
    fun initMenu() {

    }

    override fun setContentView(view: View) {
        super.setContentView(view)
        context = this@BaseActivity
    }

    /**
     * @描述: 初始化内容布局
     * *
     * @作者: Android - samson
     * *
     * @创建日期: 2016年7月4日 下午4:02:13
     */
    private fun initContentView() {
        val layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        val frameLayout = FrameLayout(this)
        frameLayout.layoutParams = layoutParams
        // 初始化主显示布局
        showView = layoutInflater.inflate(onLoadLayout(), null)
        showView!!.layoutParams = layoutParams
        frameLayout.addView(showView)
        // 初始化Loading布局
        loadingView = LayoutInflater.from(this).inflate(R.layout.layout_loading, null)
        loadingView!!.layoutParams = layoutParams
        // 初始化为隐藏
        loadingView!!.visibility = View.GONE
        frameLayout.addView(loadingView)
        //如果是沉浸式标题栏
        if (isImmersiveToolBar)
            frameLayout.addView(toolbar)
        layout!!.addView(frameLayout)
    }

    /**
     * @描述: 初始化头部
     * *
     * @作者: Android - samson
     * *
     * @创建日期: 2016年7月4日 下午4:01:07
     */
    private fun initHeaderView() {
        val layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        toolbar = layoutInflater.inflate(R.layout.layout_header_title, null) as Toolbar
        tvTitle = toolbar!!.findViewById(R.id.header_title) as TextView
        //        int height = getResources().getDimensionPixelSize(R.dimen.title_height);
        //        titleView.setLayoutParams(new ViewGroup.LayoutParams(android.view.ViewGroup.LayoutParams.MATCH_PARENT, height));
        toolbar!!.setNavigationIcon(R.mipmap.back)
        toolbar!!.setNavigationOnClickListener { v -> finish() }
        toolbar!!.layoutParams = layoutParams
        if (!isImmersiveToolBar)
            layout!!.addView(toolbar)
    }


    /**
     * 隐藏左边按钮

     * @作者 :	sam
     * *
     * @创建日期 :	2016/11/14 14:37
     */
    fun hindLeftIcon() {
        toolbar!!.navigationIcon = null
    }

    /**
     * @描述: 设置默认操作
     * *
     * @作者: Android - samson
     * *
     * @创建日期: 2016年6月2日 上午10:34:32
     */
    fun initDefault() {}

    /**
     * 隐藏头部
     */
    fun setHeaderHide() {
        toolbar!!.visibility = View.GONE
    }


    fun hindLoading() {
        loadingView!!.visibility = View.GONE
        isLoading = false
    }

    /**
     * @param text 显示的文字
     * *
     * @描述: 显示默认的加载
     * *
     * @作者: Android - samson
     * *
     * @创建日期: 2016年7月4日 下午4:09:54
     */
    fun showLoading(text: String) {
        loadingView!!.visibility = View.VISIBLE
        isLoading = true
    }

    /**
     * @param text 显示的文字
     * *
     * @描述: 显示背景透明的加载
     * *
     * @作者: Android - samson
     * *
     * @创建日期: 2016年7月4日 下午4:10:02
     */
    fun showTransparentLoading(text: String) {
        loadingView!!.setBackgroundColor(Colors.TRANSPARENT)
        showLoading(text)
    }

    /**
     * 设置左侧标题
     */
    fun setTitle(txt: String) {
        tvTitle!!.text = txt
    }

    /**
     * @return
     * *
     * @描述:返回布局Id
     * *
     * @作者: Android - samson
     * *
     * @创建日期: 2016年7月6日 上午10:54:34
     */
    abstract fun onLoadLayout(): Int


    /**
     * @描述: 初始化设置
     * *
     * @作者: Android - samson
     * *
     * @创建日期: 2016年6月2日 上午10:22:24
     */
    open fun initOptions() {

    }

    /**
     * @描述: 初始化视图
     * *
     * @作者: Android - samson
     * *
     * @创建日期: 2016年6月2日 上午10:22:44
     */
    open fun initView() {

    }

    /**
     * @描述: 设置监听
     * *
     * @作者: Android - samson
     * *
     * @创建日期: 2016年6月2日 上午10:23:09
     */
    open fun setEvent() {

    }

    /**
     * @描述: 初始化数据
     * *
     * @作者: Android - samson
     * *
     * @创建日期: 2016年6月2日 上午10:24:18
     */
    open fun initData() {

    }

    /**
     * @描述: 初始化Adapter
     * *
     * @作者: Android - samson
     * *
     * @创建日期: 2016年6月2日 上午10:23:36
     */
    open fun initAdapter() {

    }


}
