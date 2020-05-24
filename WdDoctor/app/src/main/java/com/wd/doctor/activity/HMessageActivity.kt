package com.wd.doctor.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wd.doctor.R
import com.wd.doctor.base.BaseActivity
import kotlinx.android.synthetic.main.activity_h_message.*

class HMessageActivity : BaseActivity() {
    override fun initLayoutId(): Int {
        return R.layout.activity_h_message
    }

    override fun initListener() {
        super.initListener()
        imgBackMessageH.setOnClickListener { finish() }
    }
}
