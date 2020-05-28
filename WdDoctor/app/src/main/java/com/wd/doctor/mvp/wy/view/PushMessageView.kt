package com.wd.doctor.mvp.wy.view

import com.wd.doctor.bean.wy.PushMessageBean

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/28 15:06
 * @classname :PushMessageView
 */
interface PushMessageView {
    //成功
    fun onPushMessageViewSuccess(response:PushMessageBean)
    //失败
    fun onPushMessageViewError(msg:String)
}