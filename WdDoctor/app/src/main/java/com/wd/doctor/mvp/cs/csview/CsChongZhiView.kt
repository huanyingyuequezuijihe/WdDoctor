package com.wd.doctor.mvp.cs.csview

import com.wd.doctor.bean.cs.ChongZhiBean

interface CsChongZhiView {
    //成功
    fun onChongZhiSuccess(response:ChongZhiBean)
    //失败
    fun onChongZhiError(msg:String)
}