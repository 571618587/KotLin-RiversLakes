package com.samson.rivers_lakes.lower.entities

import java.util.Date

class JUserBean {
    var userId: String? = null
        set(userId) {
            field = userId?.trim { it <= ' ' }
        }

    var userAccount: String? = null
        set(userAccount) {
            field = userAccount?.trim { it <= ' ' }
        }

    var qqId: String? = null
        set(qqId) {
            field = qqId?.trim { it <= ' ' }
        }

    var wechatId: String? = null
        set(wechatId) {
            field = wechatId?.trim { it <= ' ' }
        }

    var userPwd: String? = null
        set(userPwd) {
            field = userPwd?.trim { it <= ' ' }
        }

    var token: String? = null
        set(token) {
            field = token?.trim { it <= ' ' }
        }

    var createTime: Date? = null

    var updateTime: Date? = null

    var loginTime: Date? = null

    var infoStatus: Byte? = null
}