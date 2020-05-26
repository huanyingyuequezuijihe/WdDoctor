package com.wd.doctor.activity

import com.wd.doctor.R
import com.wd.doctor.adapter.wy.FragmentPagerAsk
import com.wd.doctor.base.BaseActivity
import kotlinx.android.synthetic.main.activity_answer.*

class AnswerActivity : BaseActivity() {
    override fun initLayoutId(): Int {
        return R.layout.activity_answer
    }

    override fun initListener() {
        super.initListener()
        imgBackAnswer.setOnClickListener {
            finish()
        }
        //消息
        img_message_black.setOnClickListener {
            startActivityTo<MessageActivity>()
        }
        //搜索
        imgSearchCircle.setOnClickListener {
            startActivityTo<SearchActivity>()
        }
    }

    override fun initData() {
        super.initData()
        //适配器
        val fragmentPagerAsk = FragmentPagerAsk(supportFragmentManager)
        viewPagerAskWy.adapter=fragmentPagerAsk
        tabAskWy.setupWithViewPager(viewPagerAskWy)
    }
}
