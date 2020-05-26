package com.wd.doctor.mvp.cs.cspresenter

interface CsChongZhiPresenter {
    //成功
    fun onChongZhiSuccess(email:String,pwd1:String,pwd2:String)
    //失败
    fun onChongZhiError(msg:String)
    //解除view 和 presenter
    fun destroyView()
}