package com.wd.doctor.mvp.wy.presenter

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/22 14:32
 * @classname :SickCircleInfoPresenter
 */
interface SickCircleInfoPresenter {
    //成功
    fun onSickCircleInfoSuccess(sickCircleId:Int)
    //失败
    fun onSickCircleInfoError(msg:String)
    //解除view 和 presenter
    fun destroyView()
}