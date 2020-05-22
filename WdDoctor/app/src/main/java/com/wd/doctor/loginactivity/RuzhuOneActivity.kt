package com.wd.doctor.loginactivity

import com.wd.doctor.R
import com.wd.doctor.base.BaseActivity
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_ruzhuone_activity.*
import kotlinx.android.synthetic.main.activity_ruzhuone_activity.view.*

class RuzhuOneActivity : BaseActivity() {



    override fun initLayoutId(): Int {
        return R.layout.activity_ruzhuone_activity
    }

    override fun initData() {
        val list = listOf<String>("111","222","333","444","555")


        keshi_nice_spinner.setBackgroundResource(R.color.colorPrimary)







    }

    override fun initListener() {
        ruzhu_btn_xia.setOnClickListener {
            startActivityAndFinish<RuzhuTwoActivity>()
        }

    }
}