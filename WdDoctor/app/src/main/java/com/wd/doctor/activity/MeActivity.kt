package com.wd.doctor.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wd.doctor.R
import com.wd.doctor.base.BaseActivity
import kotlinx.android.synthetic.main.activity_me.*

class MeActivity :BaseActivity() {
    override fun initLayoutId(): Int {
        return R.layout.activity_me
    }

    override fun initListener() {
        super.initListener()
        imgBackMe.setOnClickListener {
            finish()
        }
    }
}
