package com.samson.rivers_lakes.lower.entities

/**
 * 发帖管理Bean ClassName: Letter

 * @Description: TODO
 * *
 * @author: yangkexin
 * *
 * @date: 2016年9月3日
 */

class JLetter {

    var id: Long? = null

    var letterId: String? = null// 帖子Id

    var userId: String? = null// 创建人Id

    var letterType: Byte? = null// 1,求助 2，项目业务类 3,交易业务类 4,交流分享 5,求职招聘

    var title: String? = null// 名称，标题

    var address: String? = null// 地址信息

    var seeNum: Int? = null// 查看次数

    var fxNum: Int? = null// 分享次数

    var zNum: Int? = null// 点赞次数

    var plNum: Int? = null// 评论次数

    var jLetterAuth: Byte? = null// 0 不设置权限 1，允许谁看 2，不允许谁看

    var createTime: String? = null// 创建时间

    var updateTime: String? = null// 修改时间

    var isdel: Int? = null// 删除标识 0未删除 1已删除

    var content: String? = null// 帖子内容

    var letterPosition: Int? = null // 发帖位置

    var mpId: String? = null // 门派id

    var labelOne: String? = null //一级标签

    var labelTwo: String? = null //二级标签

    var imgs: List<JLetterImg>? = null

    /************************************
     * 业务数据
     */

    var mpName: String? = null // 门派名称

    var userAccount: String? = null // 用户账号

    var labelName: String? = null // 标签名称

    var labelNameOne: String? = null // 一级标签名称

    var labelNameTwo: String? = null // 二级标签名称

    var labelType: Int? = null // 标签类型

    var imgPath: String? = null // 图片路径

    var nickName: String? = null // 用户昵称

    var userName: String? = null // 用户昵称

    var parentAccount: String? = null // 上一级评论用户账号
    var sc: String? = null
    private val reviews: List<jLetterReview>? = null//评论信息
    private val services: List<jLetterService>? = null//操作相关

    constructor(id: Long?, letterId: String, userId: String, letterType: Byte?,
                title: String, address: String, seeNum: Int?, fxNum: Int?, zNum: Int?,
                plNum: Int?, jLetterAuth: Byte?, createTime: String, updateTime: String,
                isdel: Int?, content: String, letterPosition: Int?, mpId: String,
                labelOne: String, labelTwo: String, mpName: String, userAccount: String,
                labelName: String, labelNameOne: String, labelNameTwo: String,
                labelType: Int?, imgPath: String, nickName: String, userName: String,
                parentAccount: String, sc: String) {
        this.id = id
        this.letterId = letterId
        this.userId = userId
        this.letterType = letterType
        this.title = title
        this.address = address
        this.seeNum = seeNum
        this.fxNum = fxNum
        this.zNum = zNum
        this.plNum = plNum
        this.jLetterAuth = jLetterAuth
        this.createTime = createTime
        this.updateTime = updateTime
        this.isdel = isdel
        this.content = content
        this.letterPosition = letterPosition
        this.mpId = mpId
        this.labelOne = labelOne
        this.labelTwo = labelTwo
        this.mpName = mpName
        this.userAccount = userAccount
        this.labelName = labelName
        this.labelNameOne = labelNameOne
        this.labelNameTwo = labelNameTwo
        this.labelType = labelType
        this.imgPath = imgPath
        this.nickName = nickName
        this.userName = userName
        this.parentAccount = parentAccount
        this.sc = sc
    }

    constructor() {}
}