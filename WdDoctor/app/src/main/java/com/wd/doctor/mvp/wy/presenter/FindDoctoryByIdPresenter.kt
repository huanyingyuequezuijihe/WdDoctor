package com.wd.doctor.mvp.wy.presenter

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/21 15:18
 * @classname :FindDoctoryByIdPresenter
 */
interface FindDoctorByIdPresenter {
    //成功
    fun onFindDoctorByIdSuccess()
    //失败
    fun onFindDoctorByIdError(msg:String)
    //解除view 和 presenter
    fun destroyView()
}