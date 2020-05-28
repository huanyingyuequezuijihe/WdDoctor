package com.wd.doctor.mvp.wy.presenter

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/28 15:48
 * @classname :FindInquiryDetailsListPresenter
 */
interface FindInquiryDetailsListPresenter {
    //成功
    fun onFindInquiryDetailsListSuccess(page:Int,count:Int,inquiryId:Int)
    //失败
    fun onFindInquiryDetailsListError(msg:String)
    //解除view 和 presenter
    fun destroyView()
}