package com.wd.doctor.mvp.wy.view

import com.wd.doctor.bean.wy.FindSystemImagePicBean

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/31 16:00
 * @classname :FindSystemImagePicView
 */
interface FindSystemImagePicView {
    //失败
    fun onFindSystemImagePicError(message: String?)
    //成功
    fun onFindSystemImagePicSuccess(reponse: FindSystemImagePicBean?)
}