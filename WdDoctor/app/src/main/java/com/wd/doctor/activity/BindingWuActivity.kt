package com.wd.doctor.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wd.doctor.R
import com.wd.doctor.base.BaseActivity
import kotlinx.android.synthetic.main.activity_binding_wu.*
import org.jetbrains.anko.startActivity

/*绑定*/
class BindingWuActivity : BaseActivity() {
    override fun initLayoutId(): Int {
        return R.layout.activity_binding_wu
    }
    override fun initListener() {
        super.initListener()
        title_view.back?.setOnClickListener {
            finish()
        }
        title_view.title?.setText("绑定消息")
       /* bangding_presioncard.setOnClickListener {
            startActivityTo<BangingIdcardActivity>()
        }
        bangding_backcard.setOnClickListener {
            startActivityTo<BangdingBackcardActivity>()
        }*/
    }
}
