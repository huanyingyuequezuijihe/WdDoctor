package com.wd.doctor.mvp.cs.csview

import com.wd.doctor.bean.cs.LiShiPingBean

interface CsPingView {
    //成功
    fun onPingSuccess(response:LiShiPingBean?)
    //失败
    fun onPingError(msg:String?)
}