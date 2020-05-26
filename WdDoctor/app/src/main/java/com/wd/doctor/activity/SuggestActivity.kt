package com.wd.doctor.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wd.doctor.R
import com.wd.doctor.base.BaseActivity
import kotlinx.android.synthetic.main.activity_suggest.*

//被采纳的建议页面
class SuggestActivity : BaseActivity() {
    override fun initLayoutId(): Int {
        return R.layout.activity_suggest
    }

    override fun initListener() {
        super.initListener()
    }

    override fun initData() {
        super.initData()
        myTitleSuggest.title?.setText("被采纳的建议")
        myTitleSuggest.back?.setOnClickListener { finish() }
    }
}
