package com.samson.rivers_lakes.lower.utils.net

import com.alibaba.fastjson.TypeReference

/**
 * 类描述：公用返回结果封装
 * 创建人：sam
 * 创建时间：2016/10/26 19:47
 * 邮箱：yhq1913@sina.com
 */
class BaseResponse<T> {
    //状态码
    var ret: String? = null
    //状态信息
    var desc: String? = null
    //返回参数
    var result: T? = null


}
