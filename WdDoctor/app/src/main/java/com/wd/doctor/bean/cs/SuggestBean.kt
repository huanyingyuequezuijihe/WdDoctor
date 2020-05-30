package com.wd.doctor.bean.cs

/**
 * @author: asus
 * @date: 20/5/29
 */
class SuggestBean (
    val result: List<Result>,
    val message: String,
    val status: String
) {
    class Result(
        val releaseUserId:Int,
        val releaseUserNickName:String,
        val releaseUserHeadPic:String,
        val title:String,
        val disease:String,
        val content:String,
        val adoptTime:Long

    )
}