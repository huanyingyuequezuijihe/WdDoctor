package com.wd.doctor.mvp.cs.cspresenter

interface CsFaYanPresenter {
    //成功
    fun onFaYanSuccess(email:String)
    //失败
    fun onFaYanError(msg:String)
    //解除view 和 presenter
    fun destroyView()
}