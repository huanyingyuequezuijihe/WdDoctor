package com.wd.doctor.bean.cs

/**
 * @author: asus
 * @date: 20/5/27
 */
data class KeShiBean (
    val result: List<Result>,
    val message: String,
    val status: String
    ){
         class Result(
            val departmentName:String,
            val id:Int,
            val pic:String,
            val rank:Int
        )

}