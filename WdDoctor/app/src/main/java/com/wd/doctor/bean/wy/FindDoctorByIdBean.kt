package com.wd.doctor.bean.wy

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/21 15:04
 * @classname :FindDoctorByIdBean
 */
data class FindDoctorByIdBean (
    val result: Result,
    val message: String,
    val status: String
){
    data class Result(
        val departmentId:Int,
        val departmentName:String,
        val goodField:String,
        val id:Int,
        val inauguralHospital:String,
        val imagePic:String,
        val jobTitle:String,
        val name:String,
        val personalProfile:String
    )
}