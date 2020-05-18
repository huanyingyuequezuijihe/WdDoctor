package com.wd.doctor.util

import android.os.Handler
import android.os.Looper

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/18 20:36
 * @classname :ThreadUtil
 */
object ThreadUtil {
    val handler= Handler(Looper.getMainLooper())
    fun runOnMainThread(runnable: Runnable){
        handler.post(runnable)
    }
}