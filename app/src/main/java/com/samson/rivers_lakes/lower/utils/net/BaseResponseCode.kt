package com.samson.rivers_lakes.lower.utils.net

/**
 * 类描述：返回结果码
 * 创建人：sam
 * 创建时间：2016/11/16 17:38
 * 邮箱：yhq1913@sina.com
 */
object BaseResponseCode {
    var SUCCESS = "00000"//成功
    var DATAERROR = "00001"//数据格式错误
    var SGINERROR = "00002"//签名错误
    var LOGINOVERTIME = "00003"//登录超时
    var JRJHERROR = "00004"//程序异常
    var USEREXISTENCE = "10000"//用户名已经存在
    var REGISTERFAIL = "10001"//注册失败
    var USERNOTEXISTENCE = "10002"//用户名不存在
    var PWDFAIL = "10003"//密码错误
    var THREELOGINFAIL = "10004"//第三方登录失败
    var UPDATEPWDFAIL = "10005"//密码修改失败
}
