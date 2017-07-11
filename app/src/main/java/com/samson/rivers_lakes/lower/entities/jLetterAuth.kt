package com.samson.rivers_lakes.lower.entities

/**
 * 帖子权限
 * @author Administrator
 */
class jLetterAuth(var userId: String?//用户id
) {
    var authId: Int? = null//主键
    var letterId: String? = null//帖子id
    var createTime: String? = null//创建时间
}
