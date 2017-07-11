package com.samson.rivers_lakes.lower.utils

import java.math.BigDecimal
import java.util.ArrayList
import java.util.Collections


/**
 * 签名工具类
 */
object SignUtil {
    /**
     * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串

     * @param params 需要排序并参与字符拼接的参数组
     * *
     * @return 拼接后字符串
     */
    fun createLinkString(params: Map<String, Any>): String {

        val keys = ArrayList(params.keys)
        Collections.sort(keys)

        var prestr = ""

        for (i in keys.indices) {
            val key = keys[i]
            var value: Any?
            if (params[key] == "null") {
                continue
            } else {
                value = params[key]
            }
            if (params[key] is String || params[key] is Int
                    || params[key] is BigDecimal || params[key] is Double
                    || params[key] is Long) {
                if (i == keys.size - 1) {//拼接时，不包括最后一个&字符
                    prestr = prestr + key + "=" + value
                } else {
                    prestr = "$prestr$key=$value&"
                }
            }
        }
        println("签名串：" + prestr)
        return prestr
    }

    /**
     * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
     *
     *
     * 需要排序并参与字符拼接的参数组

     * @return 拼接后字符串
     */
    fun createLinkString(data: List<Map<String, Any>>): String {

        var prestr = ""
        for (i in data.indices) {
            val keys = ArrayList(data[i].keys)
            Collections.sort(keys)
            for (j in keys.indices) {
                val key = keys[j]
                val value = data[i][key].toString()
                if (i == data.size - 1 && j == keys.size - 1) {// 拼接时，不包括最后一个&字符
                    prestr = prestr + key + "=" + value
                } else {
                    prestr = "$prestr$key=$value&"
                }
            }
        }
        println("List签名串：" + prestr)
        return prestr
    }

    /**
     * 获取验证签名

     * @param params
     * *
     * @return
     */
    fun getSign(params: Map<String, Any>, timeStamp: String): String {
        val sign = Md5Encrypt.md5(timeStamp + Md5Encrypt.md5(createLinkString(params) + Constants.Sign.APPKEY, "utf-8") + Constants.Sign.SECRETKEY, "utf-8")
        return sign
    }

    /**
     * 获取验证签名

     * @param params
     * *
     * @return
     */
    fun getSign(params: List<Map<String, Any>>, timeStamp: String): String {
        val sign = Md5Encrypt.md5(timeStamp + Md5Encrypt.md5(createLinkString(params) + Constants.Sign.APPKEY, "utf-8") + Constants.Sign.SECRETKEY, "utf-8")
        return sign
    }


}