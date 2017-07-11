package com.samson.rivers_lakes.api

import com.samson.rivers_lakes.lower.entities.AppUser
import com.samson.rivers_lakes.lower.utils.Constants
import com.samson.rivers_lakes.lower.utils.net.BaseResponse

import retrofit2.http.POST
import retrofit2.http.Query
import rx.Observable

/**
 * 类描述：
 * 创建人：sam
 * 创建时间：2016/10/26 18:08
 * 邮箱：yhq1913@sina.com
 */
interface ApiService {
    //样例
    // @GET("users")
    // Observable<BaseResponse<User>> login(@Query("username") String username, @Query("password") String password);

    //登陆
    @POST(Constants.URL.USER_LOGIN)
    fun login(@Query(Constants.Param.DATA)
              data: String): Observable<BaseResponse<AppUser>>

}
