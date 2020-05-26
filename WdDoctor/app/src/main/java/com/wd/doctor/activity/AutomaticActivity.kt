package com.wd.doctor.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wd.doctor.R
import com.wd.doctor.base.BaseActivity
import kotlinx.android.synthetic.main.activity_automatic.*
//自动回复页面
class AutomaticActivity : BaseActivity() {
    override fun initLayoutId(): Int {
        return R.layout.activity_automatic
    }

    override fun initListener() {
        super.initListener()
        imgBackAutomatic.setOnClickListener { finish() }
        //消息页
        imgMessageAutomatic.setOnClickListener { startActivityTo<MessageActivity>() }
    }

    override fun initData() {
        super.initData()
    }
}
