package com.wd.doctor.mvp.wy.view

import com.wd.doctor.bean.wy.FindDoctorWalletBean

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/31 21:38
 * @classname :FindDoctorWalletView
 */
interface FindDoctorWalletView {
    //失败
    fun onFindDoctorWalletError(message: String)
    //成功
    fun onFindDoctorWalletSuccess(response: FindDoctorWalletBean)
}