package com.wd.doctor.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wd.doctor.R
import com.wd.doctor.base.BaseActivity
import kotlinx.android.synthetic.main.activity_binding_wu.*

//提现记录
class TixianRecordActivity : BaseActivity() {
    /*override fun getOverridePendingTransitionMode(): TransitionMode? {
        return  TransitionMode.RIGHT
    }*/
    override fun initLayoutId(): Int {
        return  R.layout.activity_tixian_record
    }
    override fun initListener() {
        title_view.back?.setOnClickListener {
            finish()
        }
        title_view.title?.setText("提现记录")
    }
}
