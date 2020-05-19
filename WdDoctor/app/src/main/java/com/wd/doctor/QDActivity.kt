package com.wd.doctor

import android.content.Intent
import com.wd.doctor.base.BaseActivity
import kotlinx.android.synthetic.main.activity_q_d.*

class QDActivity : BaseActivity() {


    override fun initLayoutId(): Int {
        return R.layout.activity_q_d
    }

    override fun initData() {
        tv_dao.setOnClickListener {
            tv_dao.context.startActivity(Intent(tv_dao.context,MainActivity::class.java))
        }

    }

    override fun initListener() {

    }
}