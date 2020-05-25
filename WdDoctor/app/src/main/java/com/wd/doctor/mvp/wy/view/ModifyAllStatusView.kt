package com.wd.doctor.mvp.wy.view

import com.wd.doctor.bean.wy.ModifyAllStatusBean

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/24 20:47
 * @classname :ModifyAllStatusView
 */
interface ModifyAllStatusView {
    //失败
    fun onModifyAllStatusViewError(message: String)
    //数据成功
    fun onModifyAllStatusViewSuccess(response: ModifyAllStatusBean)
}