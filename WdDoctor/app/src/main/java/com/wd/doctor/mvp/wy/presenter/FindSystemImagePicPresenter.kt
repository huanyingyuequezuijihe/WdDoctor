package com.wd.doctor.mvp.wy.presenter

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/31 16:01
 * @classname :FindSystemImagePicPresenter
 */
interface FindSystemImagePicPresenter {
    fun onFindSystemImagePicSuccess()
    //解绑view和presenter
    fun destroyView()
}