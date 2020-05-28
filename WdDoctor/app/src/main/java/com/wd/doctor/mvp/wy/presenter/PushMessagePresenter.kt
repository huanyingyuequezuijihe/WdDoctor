package com.wd.doctor.mvp.wy.presenter

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/28 15:07
 * @classname :PushMessagePresenter
 */
interface PushMessagePresenter {
    //成功
    fun onPushMessageSuccess(inquiryId:Int,content:String,type:Int,userId:Int)
    //失败
    fun onPushMessageError(msg:String)
    //解除view 和 presenter
    fun destroyView()
}