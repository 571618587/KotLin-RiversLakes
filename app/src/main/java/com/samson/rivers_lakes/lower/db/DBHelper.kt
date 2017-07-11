package com.samson.rivers_lakes.lower.db

import android.content.Context

import com.ab.db.orm.AbSDDBHelper
import com.samson.rivers_lakes.lower.entities.AppUser
import com.samson.rivers_lakes.lower.entities.JUserBean
import com.samson.rivers_lakes.lower.entities.JUserInfoBean

/**
 * 负责相关实体与表的操作

 * @author samson
 */
class DBHelper(context: Context?) : AbSDDBHelper(context, DBPATH, DBNAME, null, DBVERSION, clazz) {
    companion object {

        // 数据库名称
        private val DBNAME = "rivers_lakes.db"
        // 数据库 存放路径
        private val DBPATH = "/data/data/com.samson.rivers_lakes"
        // 当前数据库的版本
        private val DBVERSION = 2
        // 要初始化的表
        private val clazz = arrayOf<Class<*>>(AppUser::class.java, JUserInfoBean::class.java)
    }

}
