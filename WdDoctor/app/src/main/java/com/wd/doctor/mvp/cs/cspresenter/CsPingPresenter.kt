package com.wd.doctor.mvp.cs.cspresenter

interface CsPingPresenter {
    //成功
    fun onPingSuccess(doctorId:Int,sessionId:String,recordId:Int)
    //失败
    fun onPingError(msg:String)
    //解除view 和 presenter
    fun destroyView()
}