package com.samson.rivers_lakes.lower.utils

import android.content.Context
import android.content.pm.PackageManager
import android.net.wifi.WifiInfo
import android.net.wifi.WifiManager
import android.os.Build
import android.util.DisplayMetrics
import android.view.Display
import android.view.WindowManager
import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.TypeReference

import java.net.Inet4Address
import java.net.InetAddress
import java.net.NetworkInterface
import java.util.Date
import java.util.Enumeration
import java.util.HashMap

import android.content.Context.WIFI_SERVICE

object AppUtils {

    // 全局上下文
    /**
     * @return
     * *
     * @描述: 全局上下文
     * *
     * @作者: Android - samson
     * *
     * @创建日期: 2016年6月18日 下午4:58:53
     */
    /**
     * @param context
     * *
     * @描述: 设置全局上下文
     * *
     * @作者: Android - samson
     * *
     * @创建日期: 2016年6月18日 下午5:00:38
     */
    var appContext: Context? = null

    /**
     * 判断应用是否赋予某个权限

     * @param permisstion
     */
    fun isCheckPermisstion(permisstion: String): Boolean {
        val pm = appContext!!.packageManager
        val isPermisstion = PackageManager.PERMISSION_GRANTED == pm.checkPermission(permisstion,
                appContext!!.packageName)
        if (isPermisstion) {
            return true
        } else {
            return false
        }
    }


    /**
     * 获取wifi的IP

     * @作者 :	sam
     * *
     * @创建日期 :	2016/11/16 16:13
     */
    // 获取32位整型IP地址
    //返回整型地址转换成“*.*.*.*”地址
    val wifiIpAddress: String
        get() {
            val wifiManager = appContext!!.getSystemService(WIFI_SERVICE) as WifiManager
            val wifiInfo = wifiManager.connectionInfo
            val ipAddress = wifiInfo.ipAddress
            return String.format("%d.%d.%d.%d",
                    ipAddress and 0xff, ipAddress shr 8 and 0xff,
                    ipAddress shr 16 and 0xff, ipAddress shr 24 and 0xff)
        }

    /**
     * 获取3G网络Ip

     * @作者 :	sam
     * *
     * @创建日期 :	2016/11/16 16:14
     */
    // if (!inetAddress.isLoopbackAddress() && inetAddress
    // instanceof Inet6Address) {
    val gprsIpAddress: String?
        get() {

            try {
                val en = NetworkInterface
                        .getNetworkInterfaces()
                while (en.hasMoreElements()) {
                    val intf = en.nextElement()
                    val enumIpAddr = intf
                            .inetAddresses
                    while (enumIpAddr.hasMoreElements()) {
                        val inetAddress = enumIpAddr.nextElement()
                        if (!inetAddress.isLoopbackAddress && inetAddress is Inet4Address) {
                            return inetAddress.getHostAddress().toString()
                        }
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }

            return null
        }

    /**
     * 获取json头

     * @param mapBody   body
     * *
     * @param token     token
     * *
     * @param userId    用户id
     * *
     * @return
     */
    fun getJson(paramSign: Map<String, Any>, mapBody: Any?, token: String?, userId: String?): String {
        val paramHeader = HashMap<String, String>()
        val date = Constants.Tools.sdf.format(Date())
        paramHeader.put(Constants.Json.SIGN, SignUtil.getSign(paramSign, date))
        val mapJSON = HashMap<String, Any>()
        paramHeader.put(Constants.Json.TIMESTAMP, date)
        if (token != null && token.length != 0) {
            paramHeader.put(Constants.Json.TOKEN, token)
        }
        if (userId != null && userId.length != 0) {
            paramHeader.put(Constants.Json.USERID, userId)
        }
        paramHeader.put(Constants.Json.CHANNEL, Constants.Json.ANDROID)
        mapJSON.put(Constants.Json.HEADER, paramHeader)
        mapJSON.put(Constants.Json.BODY, mapBody ?: "")
        return JSON.toJSONString(mapJSON)
    }

    /**
     * 检查当前是否是Wifi

     * @作者 :	sam
     * *
     * @创建日期 :	2016/11/16 16:15
     */
    //获取wifi服务
    //判断wifi是否开启
    val isWiFi: Boolean
        get() {
            val wifiManager = appContext!!.getSystemService(WIFI_SERVICE) as WifiManager
            return wifiManager.isWifiEnabled
        }

    /**
     * 获取Ip

     * @作者 :	sam
     * *
     * @创建日期 :	2016/11/16 16:15
     */
    val ip: String?
        get() {
            var ip: String? = null
            if (isWiFi) {
                ip = wifiIpAddress
            } else {
                ip = gprsIpAddress
            }
            return ip
        }

    /**
     * 对象转map

     * @作者 :	sam
     * *
     * @创建日期 :	2016/11/16 16:22
     */
    fun getJsonMap(obj: Any): Map<String, Any> {
        return JSON.parseObject(JSON.toJSONString(obj), object : TypeReference<Map<String, Any>>() {

        })
    }


    /**
     * map转对象

     * @作者 :	sam
     * *
     * @创建日期 :	2016/11/16 16:34
     */
    fun mapToBean(o: Any, mClass: Class<*>): Any {
        return JSON.parseObject<Any>(JSON.toJSONString(o), mClass)
    }


}
