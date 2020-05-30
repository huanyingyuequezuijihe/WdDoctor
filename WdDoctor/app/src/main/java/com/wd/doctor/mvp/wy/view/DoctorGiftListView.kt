package com.wd.doctor.mvp.wy.view

import com.wd.doctor.bean.wy.FindDoctorGiftListBean

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/30 11:33
 * @classname :DoctorGiftListView
 */
interface DoctorGiftListView {
    //成功
    fun onFindDoctorByIdSuccess(response:FindDoctorGiftListBean)
    //失败
    fun onFindDoctorByIdError(msg:String)
}