package com.wd.doctor.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wd.doctor.R
import com.wd.doctor.base.BaseActivity
import com.wd.doctor.net.NetManager
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity(){
    override fun initLayoutId(): Int {
        return R.layout.activity_home
    }
    override fun initListener() {
        super.initListener()
        tvAskProblem.setOnClickListener {
            startActivityTo<AskProblemActivity>()
        }
        tvAnswerWy.setOnClickListener {
            startActivityTo<AnswerActivity>()
        }
        tvAdministrationWy.setOnClickListener {
            startActivityTo<MeActivity>()
        }
    }
    override fun initData() {
        super.initData()
        val net = NetManager.netManager.net()
        println("======"+net.toString())
    }
}
