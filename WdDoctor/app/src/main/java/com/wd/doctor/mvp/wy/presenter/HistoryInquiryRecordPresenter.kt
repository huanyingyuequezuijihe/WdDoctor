package com.wd.doctor.mvp.wy.presenter

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/25 15:13
 * @classname :HistoryInquiryRecordPresenter
 */
interface HistoryInquiryRecordPresenter {
    fun onHistoryInquiryRecordData(page: Int,count:Int)
    //解绑view和presenter
    fun destroyView()
}