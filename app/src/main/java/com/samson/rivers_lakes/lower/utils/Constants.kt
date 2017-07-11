package com.samson.rivers_lakes.lower.utils

import java.text.SimpleDateFormat

/**
 * 静态变量
 */
class Constants {
    object URL {
        const val BASE = "http://123.206.70.38:8088/"
        const val UPLOAD_IMG = BASE + "upload/"
        const val USER_LOGIN = "user/login.jhtml"
    }

    object Param {
        const val DATA = "data"
    }

    object Json {
        const val HEADER = "header"
        const val TIMESTAMP = "timestamp"
        const val CHANNEL = "channel"
        const val TOKEN = "token"
        const val SIGN = "sign"
        const val BODY = "body"
        const val USERID = "userId"
        const val ANDROID = "android"
    }

    object Sign {
        var APPKEY = "1"
        var SECRETKEY = "1"
    }


    object Tools {
        val sdf = SimpleDateFormat("yyyyMMddHHmmss")
        val s_d_f = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    }

    object Exp {
        const val PHONE = "^1(3|4|5|7|8|9)\\d{9}$"
        const val PASSWORD = "^[0-9a-zA-Z\\.@!_\\,]{6,20}$"
        const val CODE = "^[0-9]{4}$"
    }

    object Intent {
        const val USER_INFO_CHANGE = "com.samson.iframe.user_info_change"
    }
}
