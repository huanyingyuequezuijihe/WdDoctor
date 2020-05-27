package com.wd.doctor.bean.cs

/**
 * @author: asus
 * @date: 20/5/27
 */
data class ZhiChegBean (
    val result: List<Result>,
    val message: String,
    val status: String
    ){
        data class Result(
            val id:Int,
            val jobTitle:String
        )

}