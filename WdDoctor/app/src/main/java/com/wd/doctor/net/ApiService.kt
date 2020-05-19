package com.wd.doctor.net

import com.wd.doctor.bean.SendEmailCodeBean
import retrofit2.Call
import retrofit2.http.*

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/19 14:48
 * @classname :ApiService
 */
interface ApiService {
    //发送验证码
    @POST()
    @FormUrlEncoded
    fun sendEmailCode(@Url url: String,@Field("email") email:String):Call<SendEmailCodeBean>
}