package com.wd.doctor.loginactivity

import com.wd.doctor.R
import com.wd.doctor.base.BaseActivity
import kotlinx.android.synthetic.main.activity_ruzhuthree_activity.*
import org.jetbrains.anko.startActivity

class RuzhuThreeActivity : BaseActivity() {


    override fun initLayoutId(): Int {
        return R.layout.activity_ruzhuthree_activity
    }

    override fun initData() {


    }

    override fun initListener() {
        ruzhu_back_three.setOnClickListener {
            finish()
        }
        //startActivity<RuzhuOneActivity>()

    }
}