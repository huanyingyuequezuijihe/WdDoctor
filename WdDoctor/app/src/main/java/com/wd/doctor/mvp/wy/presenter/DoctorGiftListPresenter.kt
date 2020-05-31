package com.wd.doctor.mvp.wy.presenter

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/30 11:34
 * @classname :DoctorGiftListPresenter
 */
interface DoctorGiftListPresenter {
    //成功
    fun onFindDoctorByIdSuccess(page:Int,count:Int)
    //失败
    fun onFindDoctorByIdError(msg:String)
    //解除view 和 presenter
    fun destroyView()
}