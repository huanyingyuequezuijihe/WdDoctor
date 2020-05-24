package com.wd.doctor.activity

import androidx.recyclerview.widget.GridLayoutManager
import com.wd.doctor.R
import com.wd.doctor.adapter.wy.RecyclerViewMe
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
        //个人
        tvPersonalMe.setOnClickListener {
            startActivityTo<PersonalActivity>()
        }
        //消息
        img_message_black.setOnClickListener {
            startActivityTo<MessageActivity>()
        }
    }

    override fun initData() {
        super.initData()
        val gridLayoutManager = GridLayoutManager(this, 2)
        recyclerMe.layoutManager=gridLayoutManager
        //适配器
        val list:List<String> = listOf("历史问诊","我的钱包","被采纳的建议","设置自动回复")
        val recyclerViewMe = RecyclerViewMe(list, this)
        recyclerMe.adapter=recyclerViewMe
    }
}
