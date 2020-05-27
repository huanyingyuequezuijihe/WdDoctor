package com.wd.doctor.mvp.cs.cspresenter

interface CsKeShiPresenter {
    //成功
    fun onKeShiSuccess(url:String)
    //失败
    fun onKeShiError(msg:String)
    //解除view 和 presenter
    fun destroyView()
}