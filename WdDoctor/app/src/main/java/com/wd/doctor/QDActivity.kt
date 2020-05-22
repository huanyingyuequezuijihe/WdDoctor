package com.wd.doctor

import android.content.Context
import android.content.Intent
import android.os.Handler
import com.wd.doctor.activity.HomeActivity
import com.wd.doctor.base.BaseActivity
import com.wd.doctor.loginactivity.LoginActivity
import kotlinx.android.synthetic.main.activity_q_d.*

class QDActivity : BaseActivity() {
    //不跟踪提交
    //不跟踪提交2

    private val handler= Handler()
    private var mCountNum=5
    private val countDown = object : Runnable{
        override fun run() {
            tv_dao.text = "${mCountNum}秒 立即跳转"
            tv_dao.isEnabled = false
            if (mCountNum > 0) {
                handler.postDelayed(this, 1000)
            } else {
                startActivityAndFinish<LoginActivity>()
            }
            mCountNum--
        }
    }
    override fun initLayoutId(): Int {
        return R.layout.activity_q_d
    }

    override fun initData() {
        handler.postDelayed(countDown,0)

    }

    override fun initListener() {
        tv_dao.setOnClickListener {
            startActivityAndFinish<LoginActivity>()
        }
    }
}