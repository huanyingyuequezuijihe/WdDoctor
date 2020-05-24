package com.wd.doctor.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wd.doctor.R
import com.wd.doctor.base.BaseActivity
import kotlinx.android.synthetic.main.activity_xi_tong_message.*

class XiTongMessageActivity : BaseActivity() {
    override fun initLayoutId(): Int {
        return R.layout.activity_xi_tong_message
    }

    override fun initListener() {
        super.initListener()
        imgBackMessageX.setOnClickListener { finish() }
    }
}
