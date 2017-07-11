package com.samson.rivers_lakes.lower.entities

/**
 * Created by CXP on 2016/10/9.
 * 群组资料 （门派资料）
 */

class Group {

    //群组的唯一标识
    var groupId: String? = null
    //群组形态
    var type: String? = null
    //群组名称
    var name: String? = null
    //群组简介  门派宗旨
    var introduction: String? = null
    //群组公告
    var notification: String? = null
    //门派派规
    var groupRule: String? = null
    //群组头像URL
    var faceUrl: String? = null
    //群主ID
    var owner_Account: String? = null
    //群组的创建时间
    var createTime: Int? = null
    //群资料的每次变都会增加该值
    var infoSeq: Int? = null
    //群组最后一次信息变更时间
    var lastInfoTime: Int? = null
    //群组内最后发消息的时间
    var lastMsgTime: Int? = null
    //群内下一条消息的Seq
    var nextMsgSeq: Int? = null
    //当前成员数量
    var memberNum: Int? = null
    //最大成员数量
    var maxMemberNum: Int? = null
    //申请加群选项
    var applyJoinOption: String? = null
}
