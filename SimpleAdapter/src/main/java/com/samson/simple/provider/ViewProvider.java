package com.samson.simple.provider;


import android.content.Context;

import com.samson.simple.bean.IItemBean;
import com.samson.simple.viewholder.ViewHolder;


/**
 * 类描述：
 * 创建人：sam
 * 创建时间：2016/11/4 19:45
 * 邮箱：yhq1913@sina.com
 */
public interface ViewProvider<T extends IItemBean> {
    /**
     * 子类覆写该方法来填充数据到视图中
     *
     * @param viewHolder 通用的ViewHolder, 里面会装载listview,
     *                   gridview等组件的每一项的视图，并且缓存其子view
     * @param item       数据源的第position项数据
     */
    public abstract void bindView(Context context, ViewHolder viewHolder, int position, T item);

    /**
     * 获取list item布局ID
     *
     * @return
     */
    public abstract int getLayoutId();

}
