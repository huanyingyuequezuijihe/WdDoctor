package com.wd.doctor.mvp.wy.presenter

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/23 16:49
 * @classname :SearchSickCirclePresenter
 */
interface SearchSickCirclePresenter {
    fun onSearchSickCircleDatas(keyWord: String)
    //解绑
    fun destroyView()
}