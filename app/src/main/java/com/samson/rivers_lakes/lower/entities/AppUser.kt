package com.samson.rivers_lakes.lower.entities

import android.os.Parcel
import android.os.Parcelable

import com.ab.db.orm.annotation.Column
import com.ab.db.orm.annotation.Id
import com.ab.db.orm.annotation.Table


@Table(name = "app_user")
data class AppUser(@Id
                   @Column(name = "id")
                   var id: Long? = null,
                   @Column(name = "user_id")
                   var userId: String? = null,
                   @Column(name = "user_pwd")
                   var userPwd: String? = null,
                   @Column(name = "user_account")
                   var userAccount: String? = null,
        //信息填写状态 0，未填写  1，已填写
                   @Column(name = "info_status")
                   var infoStatus: String? = null,
                   @Column(name = "token")
                   var token: String? = null,
        //第三方登录标识
                   @Column(name = "three_id")
                   var threeId: String? = null,
        //第三方登录渠道
                   @Column(name = "three_channel")
                   var threeChannel: String? = null,
        //签名
                   @Column(name = "sig")
                   var sig: String? = null) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readValue(Long::class.java.classLoader) as? Long,
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(userId)
        parcel.writeString(userPwd)
        parcel.writeString(userAccount)
        parcel.writeString(infoStatus)
        parcel.writeString(token)
        parcel.writeString(threeId)
        parcel.writeString(threeChannel)
        parcel.writeString(sig)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<AppUser> {
        override fun createFromParcel(parcel: Parcel): AppUser {
            return AppUser(parcel)
        }

        override fun newArray(size: Int): Array<AppUser?> {
            return arrayOfNulls(size)
        }
    }


}

