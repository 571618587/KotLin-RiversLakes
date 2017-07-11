package com.samson.rivers_lakes.lower.db.dao

import android.database.sqlite.SQLiteOpenHelper

import com.ab.db.orm.dao.AbDBDao
import com.ab.db.orm.dao.AbDBDaoImpl
import com.samson.rivers_lakes.lower.db.DBHelper
import com.samson.rivers_lakes.lower.entities.JUserBean
import com.samson.rivers_lakes.lower.utils.AppUtils

/**
 * 类描述：JUserInfo实体的数据库操作
 * 创建人：sam
 * 创建时间：2016/11/17 11:47
 * 邮箱：yhq1913@sina.com
 */
class JUserInfoDao : AbDBDaoImpl<JUserBean>(DBHelper(AppUtils.appContext), JUserBean::class.java)
