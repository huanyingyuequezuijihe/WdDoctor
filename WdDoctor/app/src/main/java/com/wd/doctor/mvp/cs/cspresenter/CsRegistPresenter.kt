package com.wd.doctor.mvp.cs.cspresenter

interface CsRegistPresenter {
    //成功
    fun onRegistSuccess(email:String,
                       code:String,
                       pwd1:String,
                       pwd2:String,
                       name:String,
                       inauguralHospital:String,
                       departmentId:Int,
                       jobTitleId:Int,
                       personalProfile:String,
                       goodField:String)
    //失败
    fun onRegistError(msg:String)
    //解除view 和 presenter
    fun destroyView()
}