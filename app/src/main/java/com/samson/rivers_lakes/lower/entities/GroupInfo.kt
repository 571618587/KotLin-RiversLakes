package com.samson.rivers_lakes.lower.entities

/**
 * Created by CXP on 2016/10/9.
 * 群成员信息
 */

class GroupInfo {

    //群成员ID
    var member_Account: String? = null
    //群内身份
    var role: String? = null
    //入群时间
    var joinTime: Int? = null
    //该成员当前已读消息Seq
    var msgSeq: String? = null
    //消息接收选项
    var msgFlag: String? = null
    //最后发送消息的时间
    var lastSendMsgTime: Int? = null
    //群名片
    var nameCard: String? = null
}
