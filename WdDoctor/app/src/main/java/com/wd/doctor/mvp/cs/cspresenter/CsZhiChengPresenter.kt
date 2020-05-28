package com.wd.doctor.mvp.cs.cspresenter

interface CsZhiChengPresenter {
    //成功
    fun onZhiChengSuccess()
    //失败
    fun onZhiChengError(msg:String)
    //解除view 和 presenter
    fun destroyView()
}