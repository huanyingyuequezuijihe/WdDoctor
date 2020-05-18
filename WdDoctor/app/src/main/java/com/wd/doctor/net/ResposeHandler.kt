package com.wd.doctor.net

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/18 19:58
 * @classname :ResposeHandler
 */
interface ResposeHandler<RESPONSE> {
    fun onSuccess(type:Int,response:RESPONSE)
    fun onError(type:Int,string:String?)
}