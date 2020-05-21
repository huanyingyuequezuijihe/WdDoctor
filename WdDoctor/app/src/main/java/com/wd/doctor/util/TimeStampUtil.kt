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
class TimeStampUtil {
    fun transToString(time:Long):String{
        val simpleDateFormat = SimpleDateFormat("YY-MM-DD-hh-mm-ss")
        val format = simpleDateFormat.format(time)
        return format
    }
}