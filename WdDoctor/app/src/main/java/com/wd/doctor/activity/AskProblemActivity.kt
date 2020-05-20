package com.wd.doctor.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wd.doctor.R
import com.wd.doctor.base.BaseActivity
import kotlinx.android.synthetic.main.activity_ask_problem.*

class AskProblemActivity : BaseActivity() {
    override fun initLayoutId(): Int {
        return R.layout.activity_ask_problem
    }

    override fun initListener() {
        super.initListener()
        imgBackAsk.setOnClickListener {
            finish()
        }
    }
}
