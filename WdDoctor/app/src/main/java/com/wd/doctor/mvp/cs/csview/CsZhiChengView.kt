package com.wd.doctor.mvp.cs.csview

import com.wd.doctor.bean.cs.KeShiBean
import com.wd.doctor.bean.cs.ZhiChegBean

interface CsZhiChengView {
    //成功
    fun onZhiChengSuccess(response:ZhiChegBean?)
    //失败
    fun onZhiChengError(msg:String)
}