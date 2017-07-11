package com.samson.rivers_lakes.lower.entities

class jLetterReview {
    var id: Int? =null;        //主键
    var imgPath: String? = null    //用户图片
    var nickName: String? = null//用户昵称

    private var pImgPath: String? = null    //父用户图片
    private var pNickName: String? = null//父用户昵称
    var content: String? = null
        set(content) {
            field = content?.trim { it <= ' ' }
        } //内容

    var letterId: String? = null
        set(letterId) {
            field = letterId?.trim { it <= ' ' }
        }//帖子id

    var parentid: Int? = null//父id

    var userId: String? = null
        set(userId) {
            field = userId?.trim { it <= ' ' }
        }//用户id

    var createTime: String? = null//创建时间

    private var tContent: String? = null//帖子内容

    private var tImgPath: String? = null//帖子图片

    var type: Int? = null//类型 评论为4


}