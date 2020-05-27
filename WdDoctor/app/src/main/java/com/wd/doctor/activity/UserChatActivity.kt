package com.wd.doctor.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wd.doctor.R
import com.wd.doctor.base.BaseActivity
import kotlinx.android.synthetic.main.activity_user_chat.*

class UserChatActivity : BaseActivity() {
    override fun initLayoutId(): Int {
        return R.layout.activity_user_chat
    }

    override fun initListener() {
        super.initListener()
        //返回
        myTitleView.back?.setOnClickListener { finish() }
        myTitleView.title?.setText("鞠婧祎")
    }
}
