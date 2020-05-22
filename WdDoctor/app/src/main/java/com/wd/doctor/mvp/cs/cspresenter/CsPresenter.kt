package com.wd.doctor.mvp.cs.cspresenter

interface CsPresenter {
    //成功
    fun onLoginSuccess(email:String,pwd:String)
    //失败
    fun onLoginError(msg:String)
    //解除view 和 presenter
    fun destroyView()
}