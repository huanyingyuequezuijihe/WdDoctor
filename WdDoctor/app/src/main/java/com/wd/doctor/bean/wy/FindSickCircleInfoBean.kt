package com.wd.doctor.bean.wy

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/22 9:31
 * @classname :FindSickCircleInfoBean
 */
data class FindSickCircleInfoBean (
    val result: Result,
    val message: String,
    val status: String
){
    data class Result(
        val amount:Int,
        val authorName:String,
        val content:String,
        val departmentId:Int,
        val departmentName:String,
        val detail:String,
        val disease:String,
        val id:Int,
        val picture:String,
        val title:String,
        val treatmentEndTime:Long,
        val treatmentHospital:String,
        val treatmentProcess:String,
        val treatmentStartTime:Long,
        val userId:Int,
        val whetherContent:Int
    )
}