package com.wd.doctor.mvp.wy.view

import com.wd.doctor.bean.wy.FindHistoryInquiryRecordBean

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/25 15:12
 * @classname :HistoryInquiryRecordView
 */
interface HistoryInquiryRecordView { //失败
    fun onHistoryInquiryRecordError(message: String)
    //数据成功
    fun onHistoryInquiryRecordSuccess(response: FindHistoryInquiryRecordBean)

}