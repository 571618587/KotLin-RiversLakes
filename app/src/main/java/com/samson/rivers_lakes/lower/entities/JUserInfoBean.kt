package com.samson.rivers_lakes.lower.entities


import android.os.Parcel
import android.os.Parcelable

import com.ab.db.orm.annotation.Column
import com.ab.db.orm.annotation.Id
import com.ab.db.orm.annotation.Table

import java.util.Date

@Table(name = "j_user_info")
class JUserInfoBean : Parcelable {

    @Id
    @Column(name = "id")
    var id: Long? = null
    @Column(name = "user_id")
    var userId: String? = null

    //昵称
    @Column(name = "nick_name")
    var nickName: String? = null

    //头像地址
    @Column(name = "img_path")
    var imgPath: String? = null

    //性别
    @Column(name = "sex")
    var sex: Int? = null

    //真实姓名
    @Column(name = "name")
    var name: String? = null

    //城市id
    @Column(name = "city_id")
    var cityId: String? = null

    //城市名称
    @Column(name = "city_name")
    var cityName: String? = null

    //组织机构
    @Column(name = "org_ins")
    var orgIns: String? = null

    //部门名称
    @Column(name = "department")
    var department: String? = null

    //个人说明
    @Column(name = "description")
    var description: String? = null

    //名片图片地址， 逗号隔开
    @Column(name = "mp_path")
    var mpPath: String? = null

    //标签
    @Column(name = "xq_label")
    var xqLabel: String? = null

    //电话号码
    @Column(name = "telphone")
    var telphone: String? = null

    @Column(name = "create_time")
    var createTime: Date? = null

    @Column(name = "update_time")
    var updateTime: Date? = null

    @Column(name = "user_account")
    var userAccount: String? = null

    @Column(name = "first_label")
    var firstLabel: String? = null

    constructor(id: Long?, userId: String, nickName: String, imgPath: String,
                sex: Int?, name: String, cityId: String, cityName: String,
                orgIns: String, department: String, description: String, mpPath: String,
                xqLabel: String, telphone: String, createTime: Date, updateTime: Date,
                userAccount: String, firstLabel: String) {
        this.id = id
        this.userId = userId
        this.nickName = nickName
        this.imgPath = imgPath
        this.sex = sex
        this.name = name
        this.cityId = cityId
        this.cityName = cityName
        this.orgIns = orgIns
        this.department = department
        this.description = description
        this.mpPath = mpPath
        this.xqLabel = xqLabel
        this.telphone = telphone
        this.createTime = createTime
        this.updateTime = updateTime
        this.userAccount = userAccount
        this.firstLabel = firstLabel
    }

    constructor() {}

    protected constructor(`in`: Parcel) {
        userId = `in`.readString()
        nickName = `in`.readString()
        imgPath = `in`.readString()
        name = `in`.readString()
        cityId = `in`.readString()
        cityName = `in`.readString()
        orgIns = `in`.readString()
        department = `in`.readString()
        description = `in`.readString()
        mpPath = `in`.readString()
        xqLabel = `in`.readString()
        telphone = `in`.readString()
        userAccount = `in`.readString()
        firstLabel = `in`.readString()
    }


    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, i: Int) {
        parcel.writeString(userId)
        parcel.writeString(nickName)
        parcel.writeString(imgPath)
        parcel.writeString(name)
        parcel.writeString(cityId)
        parcel.writeString(cityName)
        parcel.writeString(orgIns)
        parcel.writeString(department)
        parcel.writeString(description)
        parcel.writeString(mpPath)
        parcel.writeString(xqLabel)
        parcel.writeString(telphone)
        parcel.writeString(userAccount)
        parcel.writeString(firstLabel)
    }

    companion object {

        val CREATOR: Parcelable.Creator<JUserInfoBean> = object : Parcelable.Creator<JUserInfoBean> {
            override fun createFromParcel(`in`: Parcel): JUserInfoBean {
                return JUserInfoBean(`in`)
            }

            override fun newArray(size: Int): Array<JUserInfoBean?> {
                return arrayOfNulls(size)
            }
        }
    }
}