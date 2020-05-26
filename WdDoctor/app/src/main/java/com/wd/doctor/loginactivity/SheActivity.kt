package com.wd.doctor.loginactivity

import com.wd.doctor.R
import com.wd.doctor.base.BaseActivity
import kotlinx.android.synthetic.main.she_activity.*

/**
 * @author: asus
 * @date: 20/5/26
 */
class SheActivity: BaseActivity() {
    override fun initLayoutId(): Int {
        return R.layout.she_activity
    }

    override fun initListener() {
        ruzhu_back_she.setOnClickListener {
            finish()
        }

        wang_btn_ok.setOnClickListener {
            startActivityAndFinish<LoginActivity>()
        }
    }
}