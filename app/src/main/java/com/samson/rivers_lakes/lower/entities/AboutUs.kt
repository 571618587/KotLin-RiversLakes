package com.samson.rivers_lakes.lower.entities

/**
 * 关于我们Bean
 * ClassName: AboutUs
 * @Description: TODO
 * *
 * @author: yangkexin
 * *
 * @date: 2016年9月7日
 */
class AboutUs {
    var aboutUsId: Int? = null//id（关于我们）

    /**
     * @return title
     */
    /**
     * @param title title
     */
    var title: String? = null//标题

    var email: String? = null
        set(email) {
            field = email?.trim { it <= ' ' }
        }//联系方式

    var createTime: String? = null
        set(createTime) {
            field = if ("" == createTime) null else createTime
        }//创建时间

    var updateTime: String? = null
        set(updateTime) {
            field = if ("" == updateTime) null else updateTime
        }//更新时间

    var content: String? = null
        set(content) {
            field = content?.trim { it <= ' ' }
        }//内容
}