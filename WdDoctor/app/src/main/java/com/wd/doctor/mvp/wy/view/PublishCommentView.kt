package com.wd.doctor.mvp.wy.view

import com.wd.doctor.bean.wy.PublishCommentBean

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/24 11:28
 * @classname :PublishCommentView
 */
interface PublishCommentView {
    //失败
    fun onPublishCommentError(message: String)
    //数据成功
    fun onPublishCommentSuccess(response: PublishCommentBean)
}