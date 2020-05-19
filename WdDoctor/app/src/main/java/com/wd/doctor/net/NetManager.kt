package com.wd.doctor.net

import android.util.Log
import android.widget.ImageView
import com.squareup.picasso.Picasso
import com.wd.doctor.util.ThreadUtil
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/18 19:52
 * @classname :NetManager
 * 网络工具类
 */
class NetManager private constructor(){
    val httpLoggingInterceptor by lazy { HttpLoggingInterceptor() }
    companion object{
        val netManager by lazy { NetManager() }
    }
    //发送网络请求   get
    private val okHttpClient by lazy {
        OkHttpClient.Builder()
            .connectTimeout(5,TimeUnit.SECONDS)
            .readTimeout(5,TimeUnit.SECONDS)
            .writeTimeout(5,TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
    }
    val retrofitUtil by lazy {
        Retrofit.Builder()
            .baseUrl(ApiUrl.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }
    //加载图片
    fun getPhoto(path:String,imageView:ImageView){
        Picasso.get().load(path).into(imageView)
    }
    //加载圆形图片
    fun getCirclePhoto(){
    }
}