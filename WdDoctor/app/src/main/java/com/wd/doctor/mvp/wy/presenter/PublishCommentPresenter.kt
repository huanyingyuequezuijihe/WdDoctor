package com.wd.doctor.mvp.wy.presenter

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/24 11:29
 * @classname :PublishCommentPresenter
 */
interface PublishCommentPresenter {
    fun onPublishCommentData(sickCircleId: Int,content:String)
    //解绑view和presenter
    fun destroyView()
}