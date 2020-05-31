package com.wd.doctor.mvp.wy.presenter

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/31 21:39
 * @classname :FindDoctorWalletPresenter
 */
interface FindDoctorWalletPresenter {
    fun onFindDoctorWalletSuccess()
    //解绑view和presenter
    fun destroyView()
}