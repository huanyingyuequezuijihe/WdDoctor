package com.wd.doctor.util

import java.util.regex.Pattern

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/20 8:04
 * @classname :RegularUtil
 * 正则 判断 手机号 密码
 */
object RegularUtil {
    fun isPhone(num: String): Boolean{
        val regExp="^1[0-9]{10}$"
        val compile = Pattern.compile(regExp);
        val matcher = compile.matcher(num)
        val matches = matcher.matches()
        return matches
    }
    fun isPwd(num: String): Boolean{
        val regExp="^[a-zA-Z][a-zA-Z0-9.]{5,10}$"
        val compile = Pattern.compile(regExp);
        val matcher = compile.matcher(num)
        val matches = matcher.matches()
        return matches
    }
}