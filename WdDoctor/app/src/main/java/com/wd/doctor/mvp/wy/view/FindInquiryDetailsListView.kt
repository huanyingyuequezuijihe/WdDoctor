package com.wd.doctor.mvp.wy.view

import com.wd.doctor.bean.wy.FindInquiryDetailsListBean

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/28 15:44
 * @classname :FindInquiryDetailsListView
 */
interface FindInquiryDetailsListView {
    //成功
    fun onFindInquiryDetailsListSuccess(response: FindInquiryDetailsListBean)
    //失败
    fun onFindInquiryDetailsListError(msg:String)
}