package com.wd.doctor.mvp.cs.csview

import com.wd.doctor.bean.cs.LoginBean

interface CsRegistView {
    //成功
    fun onLoginSuccess(response:LoginBean)
    //失败
    fun onLoginError(msg:String)
}