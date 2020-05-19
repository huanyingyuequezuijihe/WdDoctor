package com.wd.doctor.net

import com.google.gson.Gson
import java.lang.reflect.ParameterizedType

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/18 19:57
 * @classname :MyRequest
 */
open class MyRequest<RESPONSE>(val type:Int,var url:String, val resPoseHandler: ResposeHandler<RESPONSE>) {
    fun parseResult(result:String?):RESPONSE{
        val gson=Gson()
        val type = (this.javaClass
            .genericSuperclass as ParameterizedType).actualTypeArguments[0]
        val list = gson.fromJson<RESPONSE>(result,type)
        return list
    }
    //发送网络请求
    fun execute(){
        //NetManager.manager.sendRequest<RESPONSE>(this)
    }
}