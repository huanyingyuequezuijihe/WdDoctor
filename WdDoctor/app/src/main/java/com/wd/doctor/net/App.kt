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
        private var instance:Application?=null
        fun instance()= instance!!
    }

    override fun onCreate() {
        super.onCreate()
        instance=this
    }
}