package com.samson.rivers_lakes.lower.db.dao

import android.content.Context
import android.database.sqlite.SQLiteOpenHelper

import com.ab.db.orm.dao.AbDBDaoImpl
import com.samson.rivers_lakes.lower.db.DBHelper
import com.samson.rivers_lakes.lower.entities.AppUser
import com.samson.rivers_lakes.lower.utils.AppUtils

/**
 * 类描述：用户信息数据库
 * 创建人：sam
 * 创建时间：2016/11/16 17:16
 * 邮箱：yhq1913@sina.com
 */
class AppUserDao : AbDBDaoImpl<AppUser>(DBHelper(AppUtils.appContext), AppUser::class.java)
