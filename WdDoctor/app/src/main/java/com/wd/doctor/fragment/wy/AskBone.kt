package com.wd.doctor.fragment.wy

import android.view.View
import com.wd.doctor.R
import com.wd.doctor.base.BaseFragment

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/21 14:33
 * @classname :AskBone
 * 骨科
 */
class AskBone :BaseFragment(){
    override fun initView(): View? {
        val view = View.inflate(context, R.layout.fragment_askbone, null)
        return view
    }
}