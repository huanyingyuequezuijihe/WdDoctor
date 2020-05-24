package com.wd.doctor.activity

import androidx.recyclerview.widget.LinearLayoutManager
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
        //消息
        img_message_black.setOnClickListener {
            startActivityTo<MessageActivity>()
        }
    }

    override fun initData() {
        super.initData()
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerAsk.layoutManager=linearLayoutManager
        //适配器
    }
}
