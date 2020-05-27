package com.wd.doctor.mvp.cs.csview

import com.wd.doctor.bean.SendEmailCodeBean

interface CsFaYanView {
    //成功
    fun onFaYanSuccess(response:SendEmailCodeBean)
    //失败
    fun onFaYanError(msg:String)
}