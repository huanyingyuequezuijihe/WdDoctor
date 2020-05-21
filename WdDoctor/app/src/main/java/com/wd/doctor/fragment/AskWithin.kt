package com.wd.doctor.fragment

import android.view.View
import com.wd.doctor.R
import com.wd.doctor.base.BaseFragment

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/21 8:10
 * @classname :AskWithin
 * 内科
 */
class AskWithin :BaseFragment(){
    override fun initView(): View? {
        val view = View.inflate(context, R.layout.fragment_askwithin, null)
        return view
    }
}