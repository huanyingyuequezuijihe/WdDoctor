package com.wd.doctor.mvp.cs.csview

import com.wd.doctor.bean.cs.KeShiBean

interface CsKeShiView {
    //成功
    fun onKeShiSuccess(response:KeShiBean?)
    //失败
    fun onKeShiError(msg:String?)
}