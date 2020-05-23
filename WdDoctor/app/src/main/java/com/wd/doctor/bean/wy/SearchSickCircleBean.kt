package com.wd.doctor.bean.wy

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/23 16:38
 * @classname :SearchSickCircleBean
 */
data class SearchSickCircleBean (
    val message: String,
    val result: List<Result>,
    val status: String
){

    class Result(
        val amount: Int,
        val detail: String,
        val releaseTime: Long,
        val sickCircleId: Int,
        val title: String
    )
}