package com.wd.doctor.util

import java.text.SimpleDateFormat

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/21 20:20
 * @classname :TimeStampUtil
 * 时间戳
 */
object TimeStampUtil {
    fun transToString(time:Long):String{
        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd-hh-MM-ss")
        val format = simpleDateFormat.format(time)
        return format
    }
}