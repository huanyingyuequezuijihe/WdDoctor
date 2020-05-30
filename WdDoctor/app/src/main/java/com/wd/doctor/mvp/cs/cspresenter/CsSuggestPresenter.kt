package com.wd.doctor.mvp.cs.cspresenter

interface CsSuggestPresenter {
    //成功
    fun onSuggestSuccess(doctorId:Int,sessionId:String)
    //失败
    fun onSuggestError(msg:String)
    //解除view 和 presenter
    fun destroyView()
}