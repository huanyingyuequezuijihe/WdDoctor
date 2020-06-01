package com.wd.doctor.bean.wy

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/31 21:28
 * @classname :FindDoctorWalletBean
 * 查询医生钱包
 */
class FindDoctorWalletBean (
    val result:Result,
    val message:String,
    val status:String
){
    data class Result(
        val balance:Int,
        val doctorId:Int,
        val id:Int,
        val version:Int,
        val whetherBindBankCard:Int,
        val whetherBindIdCard:Int
    )
}