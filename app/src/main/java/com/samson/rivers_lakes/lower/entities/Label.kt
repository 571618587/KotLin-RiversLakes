package com.samson.rivers_lakes.lower.entities

class Label {
    var id: Int? = null

    var userId: String? = null
        set(userId) {
            field = userId?.trim { it <= ' ' }
        }

    var labelName: String? = null
        set(labelName) {
            field = labelName?.trim { it <= ' ' }
        }

    var labelType: Int? = null

    var labelParent: String? = null

    var isdel: Int? = null

    var creatTime: String? = null
        set(creatTime) {
            field = if ("" == creatTime) null else creatTime
        }

    var creatPerson: String? = null
        set(creatPerson) {
            field = creatPerson?.trim { it <= ' ' }
        }

    var updateTime: String? = null
        set(updateTime) {
            field = if ("" == updateTime) null else updateTime
        }

    var updatePerson: String? = null
        set(updatePerson) {
            field = updatePerson?.trim { it <= ' ' }
        }

    var parentName: String? = null // 上一级标签名称

    var labelCategory: String? = null
}