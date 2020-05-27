package com.wd.doctor.mvp.cs.csview

import com.wd.doctor.bean.cs.YanEmailBean

interface CsJiaoYanView {
    //成功
    fun onLoginSuccess(response: YanEmailBean)
    //失败
    fun onLoginError(msg:String)
}