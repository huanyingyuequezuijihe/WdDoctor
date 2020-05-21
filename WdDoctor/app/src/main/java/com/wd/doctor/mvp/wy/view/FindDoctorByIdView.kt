package com.wd.doctor.mvp.wy.view

import com.wd.doctor.bean.wy.FindDoctorByIdBean

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/21 15:13
 * @classname :FindDoctorByIdView
 */
interface FindDoctorByIdView {
    //成功
    fun onFindDoctorByIdSuccess(response:FindDoctorByIdBean)
    //失败
    fun onFindDoctorByIdError(msg:String)
}