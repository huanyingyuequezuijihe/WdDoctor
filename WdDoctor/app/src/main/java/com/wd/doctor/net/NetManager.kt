package com.wd.doctor.net

import android.util.Log
import com.wd.doctor.util.ThreadUtil
import okhttp3.*
import java.io.IOException

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/18 19:52
 * @classname :NetManager
 * 网络工具类
 */
class NetManager private constructor(){
    private val client by lazy { OkHttpClient() }
    companion object{
        val manager by lazy { NetManager() }
    }
    //发送网络请求
    fun<RESPONSE> sendRequest(myReq:MyRequest<RESPONSE>){
        val request=Request.Builder()
            .url(myReq.url)
            .header("userId","")
            .header("sessionId","")
            .get()
            .build()
        client.newCall(request).enqueue(object :Callback{
            override fun onFailure(call: Call, e: IOException) {
                myReq.resPoseHandler.onError(myReq.type,e.message)
            }

            override fun onResponse(call: Call, response: Response) {
                val result = response?.body?.string()
                Log.d("===",result)
                val parseResult=myReq.parseResult(result)
                ThreadUtil.runOnMainThread(Runnable {
                    myReq.resPoseHandler.onSuccess(myReq.type,parseResult)
                })
            }
        })
    }
}