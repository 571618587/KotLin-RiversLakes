package com.samson.rivers_lakes.lower.entities

/**
 * 帖子点赞，评论等信息
 * @author Administrator
 */
class jLetterService {
    private var lServiceId: Int? = null//主键

    var userId: String? = null
        set(userId) {
            field = userId?.trim { it <= ' ' }
        }//用户id
    var imgPath: String? = null    //用户图片
    var nickName: String? = null//用户昵称
    var letterId: String? = null
        set(letterId) {
            field = letterId?.trim { it <= ' ' }
        }//帖子id

    var type: Byte? = null//类型

    var createTime: String? = null//创建时间

    fun getlServiceId(): Int? {
        return lServiceId
    }

    fun setlServiceId(lServiceId: Int?) {
        this.lServiceId = lServiceId
    }
}