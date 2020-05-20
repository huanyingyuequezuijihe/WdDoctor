package com.wd.doctor.net

import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import android.widget.ImageView
import com.squareup.picasso.Picasso
import com.wd.doctor.util.ThreadUtil
import jp.wasabeef.picasso.transformations.CropCircleTransformation
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
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
    /**
     * 设置头
     */
    //发送网络请求   get
    private val okHttpClient by lazy {
        OkHttpClient.Builder()
            .connectTimeout(5,TimeUnit.SECONDS)
            .readTimeout(5,TimeUnit.SECONDS)
            .writeTimeout(5,TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY))
            .addInterceptor {
                chain: Interceptor.Chain ->
                val originalRequest = chain.request()
                val requestBuilder = originalRequest.newBuilder()
                    // Provide your custom header here
                    .header("", "")
                val request = requestBuilder.build()
                chain.proceed(request)
            }
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
    //动态代理
    inline fun <reified ApiService> createService(service:Class<ApiService>):ApiService{
        return retrofitUtil.create<ApiService>()
    }
    //加载图片
    fun getPhoto(path:String,imageView:ImageView){
        Picasso.get().load(path).into(imageView)
    }
    //加载圆形图片
    fun getCirclePhoto(path:String,imageView:ImageView){
        Picasso.get()
            .load(path)
            .transform(CropCircleTransformation())
            .into(imageView)
    }
    //网络判断
    fun net(): Boolean {
        val connectivityManager:ConnectivityManager= App.instance().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        if(activeNetworkInfo!=null){
            val available = activeNetworkInfo.isAvailable
            return available
        }
        return false
    }
}