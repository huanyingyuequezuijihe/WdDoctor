package com.wd.doctor.bean.wy

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/21 17:07
 * @classname :FindSickCircleListBean
 */
class FindSickCircleListBean (
    val result: List<Result>,
    val message: String,
    val status: String
){
    data class Result(
        val amount:Int,
        val detail:String,
        val releaseTime:Long,
        val sickCircleId:Int,
        val title:String
    )
}