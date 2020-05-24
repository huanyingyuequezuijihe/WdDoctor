package com.wd.doctor.mvp.wy.presenter

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/24 20:48
 * @classname :ModifyAllStatusPresenter
 */
interface ModifyAllStatusPresenter {
    fun onModifyAllStatusData()
    //解绑view和presenter
    fun destroyView()
}