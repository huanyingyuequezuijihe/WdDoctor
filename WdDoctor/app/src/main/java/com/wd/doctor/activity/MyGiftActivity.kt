package com.wd.doctor.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wd.doctor.R
import com.wd.doctor.base.BaseActivity
import kotlinx.android.synthetic.main.activity_my_gift.*

class MyGiftActivity : BaseActivity() {
    override fun initLayoutId(): Int {
        return R.layout.activity_my_gift
    }

    override fun initListener() {
        super.initListener()
        imgBackGift.setOnClickListener { finish() }
    }
}
