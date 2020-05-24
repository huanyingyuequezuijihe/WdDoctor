package com.wd.doctor.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wd.doctor.R
import com.wd.doctor.base.BaseActivity
import kotlinx.android.synthetic.main.activity_message.*

class MessageActivity : BaseActivity() {
    override fun initLayoutId(): Int {
        return R.layout.activity_message
    }

    override fun initListener() {
        super.initListener()
        imgBackMessage.setOnClickListener {
            finish()
        }
        //系统消息
        linearMessageX.setOnClickListener {
            startActivityTo<XiTongMessageActivity>()
        }
        //问诊消息
        linearMessageAsk.setOnClickListener {
            startActivityTo<AskMessageActivity>()
        }
        //H币 入账消息
        linearMessageH.setOnClickListener {
            startActivityTo<HMessageActivity>()
        }
    }
}
