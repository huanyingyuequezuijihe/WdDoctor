package com.wd.doctor.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wd.doctor.R
import com.wd.doctor.adapter.FragmentPagerAsk
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
    }

    override fun initData() {
        super.initData()
        //适配器
        val fragmentPagerAsk = FragmentPagerAsk(supportFragmentManager)
        viewPagerAskWy.adapter=fragmentPagerAsk
        tabAskWy.setupWithViewPager(viewPagerAskWy)
    }
}
