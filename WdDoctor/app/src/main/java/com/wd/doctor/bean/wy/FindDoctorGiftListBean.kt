package com.wd.doctor.bean.wy

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/29 21:03
 * @classname :FindDoctorGiftListBean
 */
class FindDoctorGiftListBean (
    val result: List<Result>,
    val message: String,
    val status: String
){
    data class Result(
        val giftId:Int,
        val giftPic:String,
        val sendTime:String,
        val userId:Int,
        val userNickName:String
    )
}