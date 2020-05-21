package com.wd.doctor.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentPagerAdapter
import com.wd.doctor.R
import com.wd.doctor.adapter.FragmentPagerAsk
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
    }

    override fun initData() {
        super.initData()
        //适配器
        val fragmentPagerAsk = FragmentPagerAsk(supportFragmentManager)
        viewPagerAskWy.adapter=fragmentPagerAsk
        tabAskWy.setupWithViewPager(viewPagerAskWy)
    }
}
