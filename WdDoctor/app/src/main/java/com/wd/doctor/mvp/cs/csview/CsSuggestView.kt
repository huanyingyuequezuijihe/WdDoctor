package com.wd.doctor.mvp.cs.csview

import com.wd.doctor.bean.cs.KeShiBean
import com.wd.doctor.bean.cs.SuggestBean
import com.wd.doctor.bean.cs.ZhiChegBean

interface CsSuggestView {
    //成功
    fun onSuggestSuccess(response:SuggestBean?)
    //失败
    fun onSuggestError(msg:String)
}