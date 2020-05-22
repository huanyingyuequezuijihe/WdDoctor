package com.wd.doctor.mvp.wy.view

import com.wd.doctor.bean.wy.FindSickCircleInfoBean

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/22 14:31
 * @classname :SickCircleInfoView
 */
interface SickCircleInfoView {
    //成功
    fun onSickCircleInfoViewSuccess(response: FindSickCircleInfoBean)
    //失败
    fun onSickCircleInfoViewError(msg:String)
}