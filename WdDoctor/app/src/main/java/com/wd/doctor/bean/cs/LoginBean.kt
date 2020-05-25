package com.wd.doctor.bean.cs

import javax.xml.transform.Result

/**
 * @author: asus
 * @date: 20/5/22
 */
data class LoginBean (
    val result: Result,
    val message: String,
    val status: String
){
    data class Result(
        val id:Int,
        val sessionId:String,
        val name:String,
        val userName:String,
        val reviewStatus:Int,
        val jiGuangPwd:String,
        val imagePic:String,
        val inauguralHospital:String,
        val jobTitle:String,
        val departmentId:Int,
        val departmentName:String,
        val whetherHaveImagePic:Int
    )
}