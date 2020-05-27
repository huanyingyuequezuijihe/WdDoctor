package com.wd.doctor.loginactivity

import com.wd.doctor.R
import com.wd.doctor.base.BaseActivity
import kotlinx.android.synthetic.main.activity_ruzhutwo_activity.*
import org.jetbrains.anko.startActivity

class RuzhuTwoActivity : BaseActivity() {


    override fun initLayoutId(): Int {
        return R.layout.activity_ruzhutwo_activity
    }

    override fun initData() {


    }

    override fun initListener() {

        ruzhu_back_two.setOnClickListener {
            finish()
        }
        ruzhu_btn_xia2.setOnClickListener {
            startActivity<RuzhuThreeActivity>()
        }

    }
}