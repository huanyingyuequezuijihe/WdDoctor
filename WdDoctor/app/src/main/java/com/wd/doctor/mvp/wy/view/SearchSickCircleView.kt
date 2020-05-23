package com.wd.doctor.mvp.wy.view

import com.wd.doctor.bean.wy.SearchSickCircleBean

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/23 16:45
 * @classname :SearchSickCircleView
 */
interface SearchSickCircleView {
    //成功
    fun onSearchSickCircleSucess(reponse: SearchSickCircleBean)
    //失败
    fun onSearchSickCircleError(message: String?)
}