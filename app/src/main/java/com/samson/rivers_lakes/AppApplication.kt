package com.samson.rivers_lakes

import android.app.Application
import android.content.Context
import com.samson.rivers_lakes.api.ApiManager
import com.samson.rivers_lakes.api.ApiService

import com.samson.rivers_lakes.lower.entities.AppUser
import com.samson.rivers_lakes.lower.utils.AppUtils
import com.samson.rivers_lakes.lower.utils.Constants
import com.squareup.leakcanary.LeakCanary
import com.squareup.leakcanary.RefWatcher
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.fastjson.FastJsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * 类描述：程序入口
 * 创建人：sam
 * 创建时间：2016/10/26 17:15
 * 邮箱：yhq1913@sina.com
 */
class AppApplication : Application() {
    fun provideOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            builder.addInterceptor(logging)
        }
        builder.connectTimeout((60 * 1000).toLong(), TimeUnit.MILLISECONDS)
                .readTimeout((60 * 1000).toLong(), TimeUnit.MILLISECONDS)
        return builder.build()
    }

    fun provideRestAdapter(): Retrofit {
        var okHttpClient = provideOkHttpClient();
        val builder = Retrofit.Builder()
        builder.client(okHttpClient)
                .baseUrl(Constants.URL.BASE)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(FastJsonConverterFactory.create())
        return builder.build()
    }

    fun provideApiService(): ApiService {
        return provideRestAdapter().create(ApiService::class.java)
    }

    fun provideApiManager(): ApiManager {
        return ApiManager(provideApiService(), this)
    }

    //当前登陆用户
    var u: AppUser? = null

    //在自己的Application中添加如下代码
    private var refWatcher: RefWatcher? = null


    override fun onCreate() {
        super.onCreate()
        /**初始化全局上下文 */
        AppUtils.appContext = this
        //在自己的Application中添加如下代码 直白的展现Android中的内存泄露
        refWatcher = LeakCanary.install(this)
    }

    companion object {
        //在自己的Application中添加如下代码
        fun getRefWatcher(context: Context): RefWatcher? {
            val application = context
                    .applicationContext as AppApplication
            return application.refWatcher
        }

        /**
         * 获取全局对象实例

         * @作者 :	sam
         * *
         * @创建日期 :	2016/10/26 17:46
         */
        operator fun get(context: Context): AppApplication {
            return context.applicationContext as AppApplication
        }
    }
}
