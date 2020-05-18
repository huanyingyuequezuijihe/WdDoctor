package com.wd.doctor.net

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/18 20:48
 * @classname :ApiUrl
 */
class ApiUrl private constructor(){
    //静态
    companion object{
        val apiUrl by lazy {ApiUrl()}
    }
    //发送给验证码
    fun sendEmailCode():String{
        val url:String="http://mobile.bwstudent.com/health/doctor/v1/sendEmailCode"
        return url
    }
    //申请入驻
    fun applyJoin():String{
        val url:String="http://mobile.bwstudent.com/health/doctor/v1/applyJoin"
        return url
    }
    //登录
    fun login():String{
        val url:String="http://mobile.bwstudent.com/health/doctor/v1/login"
        return url
    }
}