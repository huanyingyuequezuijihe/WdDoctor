package com.wd.doctor.mvp.cs.csview

import com.wd.doctor.bean.cs.RegistBean

interface CsRegistView {
    //成功
    fun onRegistSuccess(response:RegistBean)
    //失败
    fun onRegistError(msg:String)
}