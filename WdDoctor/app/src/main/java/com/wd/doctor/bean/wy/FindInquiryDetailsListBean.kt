package com.wd.doctor.bean.wy

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/28 14:39
 * @classname :FindInquiryDetailsListBean
 * 查询问诊聊天记录
 */
class FindInquiryDetailsListBean (
    val result: List<Result>,
    val message: String,
    val status: String
){
    data class Result(
        val askTime:Long,
        val content:String,
        val direction:Int,
        val doctorHeadPic:String,
        val msgType:Int,
        val userHeadPic:String
    )
}