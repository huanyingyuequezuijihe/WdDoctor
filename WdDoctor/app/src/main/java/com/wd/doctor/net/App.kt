package com.wd.doctor.net

import android.app.Application
import android.content.Context

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/19 21:32
 * @classname :App
 */
class App :Application(){
    companion object{
        var context:Context?=null
    }

    override fun onCreate() {
        super.onCreate()
        context=this
    }
}