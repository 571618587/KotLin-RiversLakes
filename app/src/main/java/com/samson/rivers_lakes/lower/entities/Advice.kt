package com.samson.rivers_lakes.lower.entities

/**
 * 投诉意见Bean
 * ClassName: Advice
 * @Description: TODO
 * *
 * @author: yangkexin
 * *
 * @date: 2016年9月7日
 */
class Advice {
    var adviceId: Int? = null//意见id

    /**
     * @return userId
     */
    /**
     * @param userId userId
     */
    var userId: String? = null//用户Id

    var title: String? = null
        set(title) {
            field = title?.trim { it <= ' ' }
        }//标题

    var content: String? = null
        set(content) {
            field = content?.trim { it <= ' ' }
        }//内容

    var phone: String? = null
        set(phone) {
            field = if ("" == phone) null else phone
        }//手机号码

    var createTime: String? = null
        set(createTime) {
            field = if ("" == createTime) null else createTime
        }//创建时间

    var updateTime: String? = null
        set(updateTime) {
            field = if ("" == updateTime) null else updateTime
        }//更新时间

    /**
     * @return userAccount
     */
    /**
     * @param userAccount userAccount
     */
    var userAccount: String? = null//用户账号
}