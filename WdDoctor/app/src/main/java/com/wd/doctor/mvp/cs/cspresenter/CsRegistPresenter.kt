package com.wd.doctor.mvp.cs.cspresenter

interface CsRegistPresenter {
    //成功
    fun onLoginSuccess(email:String,
                       code:String,
                       pwd1:String,
                       pwd2:String,
                       name:String,
                       inauguralHospital:String,
                       departmentId:String,
                       jobTitleId:String,
                       personalProfile:String,
                       goodField:String)
    //失败
    fun onLoginError(msg:String)
    //解除view 和 presenter
    fun destroyView()
}