package com.samson.rivers_lakes.lower.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.samson.rivers_lakes.R
import com.samson.rivers_lakes.lower.utils.Colors
import com.samson.rivers_lakes.lower.utils.ToastUtil


/**
 * 类描述：base碎片
 * 创建人：sam
 * 创建时间：2016/11/10 14:35
 * 邮箱：yhq1913@sina.com
 */
abstract class BaseFragment : Fragment() {


    // 左边ImageView返回
    private val ivBack: ImageView? = null
    // title
    private var tvTitle: TextView? = null
    // 头部的布局
    private var toolbar: Toolbar? = null
    // 布局加载view
    private var loadingView: View? = null
    // 显示给用户看得布局
    private var showView: View? = null
    // 整体跟布局
    private var layout: LinearLayout? = null
    var isLoading: Boolean = false
        private set
    protected var inflater: LayoutInflater? = null;

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        this.inflater = inflater
        if (layout == null) {
            layout = LinearLayout(getContext())
            // 布局竖向排列
            layout!!.orientation = LinearLayout.VERTICAL
            // 初始化头部
            initHeaderView()
            // 初始化内容布局
            initContentView()
        }
        //初始化依赖注入
        setupActivityComponent()
        // 初始化设置
        initOptions()
        // 初始化视图
        initView()
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
        return layout
    }


    /**
     * 初始化广播

     * @作者 :	sam
     * *
     * @创建日期 :	2016/11/14 15:38
     */
    fun initReceiver() {

    }

    override fun onDestroyView() {
        super.onDestroyView()
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
        val frameLayout = FrameLayout(getContext())
        frameLayout.layoutParams = layoutParams
        // 初始化主显示布局
        showView = inflater!!.inflate(onLoadLayout(), null)
        showView!!.layoutParams = layoutParams
        frameLayout.addView(showView)
        // 初始化Loading布局
        loadingView = inflater!!.inflate(R.layout.layout_loading, null)
        loadingView!!.layoutParams = layoutParams
        // 初始化为隐藏
        loadingView!!.visibility = View.GONE
        frameLayout.addView(loadingView)
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
        toolbar = inflater!!.inflate(R.layout.layout_header_title, null) as Toolbar
        tvTitle = toolbar!!.findViewById(R.id.header_title) as TextView
        toolbar!!.setNavigationIcon(R.mipmap.menu_bt)
        toolbar!!.setNavigationOnClickListener { v -> ToastUtil.show("点击了") }
        layout!!.addView(toolbar)
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
     * @描述: 初始化设置
     * *
     * @作者: Android - samson
     * *
     * @创建日期: 2016年6月2日 上午10:22:24
     */
    fun initOptions() {

    }

    /**
     * @描述: 初始化视图
     * *
     * @作者: Android - samson
     * *
     * @创建日期: 2016年6月2日 上午10:22:44
     */
    fun initView() {

    }

    /**
     * @描述: 设置监听
     * *
     * @作者: Android - samson
     * *
     * @创建日期: 2016年6月2日 上午10:23:09
     */
    fun setEvent() {

    }

    /**
     * @描述: 初始化数据
     * *
     * @作者: Android - samson
     * *
     * @创建日期: 2016年6月2日 上午10:24:18
     */
    fun initData() {

    }

    /**
     * @描述: 初始化Adapter
     * *
     * @作者: Android - samson
     * *
     * @创建日期: 2016年6月2日 上午10:23:36
     */
    fun initAdapter() {

    }

    abstract fun onLoadLayout(): Int

    abstract fun setupActivityComponent()


}
