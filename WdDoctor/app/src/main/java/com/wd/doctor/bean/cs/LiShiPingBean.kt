package com.wd.doctor.bean.cs

/**
 * @author: asus
 * @date: 20/6/1
 */
data class LiShiPingBean (
    val result: List<Result>,
    val message: String,
    val status: String
    ){
         class Result(
            val content:String,
            val majorDegree:Int,
            val satisfactionDegree:Int,
            val giftPicUrl:String
        )

}