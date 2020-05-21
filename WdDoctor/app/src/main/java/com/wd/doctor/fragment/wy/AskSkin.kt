package com.wd.doctor.fragment.wy

import android.view.View
import com.wd.doctor.R
import com.wd.doctor.base.BaseFragment

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/21 14:36
 * @classname :AskSkin
 * 皮肤科
 */
class AskSkin :BaseFragment(){
    override fun initView(): View? {
        val view = View.inflate(context, R.layout.fragment_askskin, null)
        return view
    }
}