package com.wd.doctor.bean.wy

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/25 15:07
 * @classname :FindHistoryInquiryRecordBean
 */
class FindHistoryInquiryRecordBean (
    val result: List<Result>,
    val message: String,
    val status: String
){
    data class Result(
        val userHeadPic:String,
        val doctorHeadPic:String,
        val nickName:String,
        val inquiryTime:Long,
        val status:Int
    )
}