package com.samson.rivers_lakes.lower.entities

/**
 * 公告bean
 * ClassName: Notice
 * @Description: TODO
 * *
 * @author: yangkexin
 * *
 * @date: 2016年9月7日
 */
class Notice {
    private var jNoticeId: Int? = null//公告Id

    var title: String? = null
        set(title) {
            field = title?.trim { it <= ' ' }
        }//标题

    var imgPath: String? = null
        set(imgPath) {
            field = imgPath?.trim { it <= ' ' }
        }//banner图片地址

    var type: Int? = null//1banner  2公告

    var status: Int? = null//1关闭 2开启

    var createTime: String? = null
        set(createTime) {
            field = if ("" == createTime) null else createTime
        }//创建时间

    var updateTime: String? = null
        set(updateTime) {
            field = if ("" == updateTime) null else updateTime
        }//修改时间

    var content: String? = null
        set(content) {
            field = content?.trim { it <= ' ' }
        }//内容

    fun getjNoticeId(): Int? {
        return jNoticeId
    }

    fun setjNoticeId(jNoticeId: Int?) {
        this.jNoticeId = jNoticeId
    }
}