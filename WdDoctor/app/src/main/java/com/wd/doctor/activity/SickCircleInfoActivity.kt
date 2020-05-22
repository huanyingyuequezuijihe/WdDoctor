package com.wd.doctor.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wd.doctor.R
import com.wd.doctor.base.BaseActivity
import kotlinx.android.synthetic.main.activity_sick_circle_info.*

//病友圈详情
class SickCircleInfoActivity : BaseActivity() {
    override fun initLayoutId(): Int {
        return R.layout.activity_sick_circle_info
    }

    override fun initListener() {
        super.initListener()
        imgBackSickCircle.setOnClickListener {
            finish()
        }
    }

    override fun initData() {
        super.initData()
        val bundle = this.intent.extras
        val sickCircleId = bundle?.getInt("sickCircleId")
    }
}
