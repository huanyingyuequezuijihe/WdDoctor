package com.wd.doctor.bean.cs

/**
 * @author: asus
 * @date: 20/5/28
 */
class WenBean (
    val result: List<Result>,
    val message: String,
    val status: String
){
    class Result(
        val recordId:Int,
        val userId:Int,
        val userHeadPic:String,
        val doctorHeadPic:String,
        val lastContent:String,
        val nickName:String,
        val inquiryTime:Long,
        val status:Int
    )

}