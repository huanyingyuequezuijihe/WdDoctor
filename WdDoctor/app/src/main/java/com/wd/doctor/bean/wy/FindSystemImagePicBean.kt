package com.wd.doctor.bean.wy

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/31 15:55
 * @classname :FindSystemImagePicBean
 */
class FindSystemImagePicBean (
    val result:List<Result>,
    val message:String,
    val status:String
){
    data class Result(
        val imagePic:String
    )
}