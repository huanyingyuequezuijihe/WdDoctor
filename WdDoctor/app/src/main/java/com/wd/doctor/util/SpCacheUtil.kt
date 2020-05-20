package com.wd.doctor.util

import android.content.Context
import com.wd.doctor.net.App

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/20 16:05
 * @classname :SpCacheUtil
 */
class SpCacheUtil private constructor(){
    val sp by lazy { App.context!!.getSharedPreferences("user",Context.MODE_PRIVATE) }
    companion object{
        val spCacheUtil by lazy { SpCacheUtil }
    }
    //存储
    fun saveStringData(key:String,value:String){
        sp.edit().putString(key, value)
        sp.edit().commit()
    }
    fun saveIntData(key:String,value:Int){
        sp.edit().putInt(key, value)
        sp.edit().commit()
    }
    //取出
    fun getStringData(key:String): String? {
        val aString = sp.getString(key, "")
        return aString
    }
    fun getIntData(key:String): Int {
        val aInt = sp.getInt(key, -1)
        return aInt!!
    }
}