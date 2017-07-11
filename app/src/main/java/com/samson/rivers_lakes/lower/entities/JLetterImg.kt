package com.samson.rivers_lakes.lower.entities


import com.ab.db.orm.annotation.Id

import javax.annotation.Generated

/**
 * 发帖图片

 * @author Administrator
 */
class JLetterImg {

    var id: Long? = null

    var imgId: Int? = null
    var letterId: String? = null//帖子id
    var imgPath: String? = null//图片路径
    var createTime: String? = null//创建时间
    var updateTime: String? = null//修改时间

    constructor(id: Long?, imgId: Int?, letterId: String, imgPath: String,
                createTime: String, updateTime: String) {
        this.id = id
        this.imgId = imgId
        this.letterId = letterId
        this.imgPath = imgPath
        this.createTime = createTime
        this.updateTime = updateTime
    }

    constructor() {}

}
