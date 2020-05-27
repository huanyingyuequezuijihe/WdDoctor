package com.wd.doctor.loginactivity

import android.text.InputType
import com.wd.doctor.R
import com.wd.doctor.base.BaseActivity
import kotlinx.android.synthetic.main.activity_ruzhutwo_activity.*
import org.jetbrains.anko.startActivity

class RuzhuTwoActivity : BaseActivity() {


    override fun initLayoutId(): Int {
        return R.layout.activity_ruzhutwo_activity
    }

    override fun initData() {


    }

    override fun initListener() {
        ruzhu_img_yan_pwd1.setOnCheckedChangeListener{View,isChecked ->
            if (isChecked){
                ruzhu_img_yan_pwd1.setBackgroundResource(R.mipmap.ruzhu_yan_zhang)
                ruzhu_ed_pwd.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD)
                //login_pwd.inputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD)
            }else{
                ruzhu_img_yan_pwd1.setBackgroundResource(R.mipmap.ruzhu_yan)
                ruzhu_ed_pwd.setInputType(InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD)
            }
        }
        ruzhu_img_yan_pwd2.setOnCheckedChangeListener{View,isChecked ->
            if (isChecked){
                ruzhu_img_yan_pwd2.setBackgroundResource(R.mipmap.ruzhu_yan_zhang)
                ruzhu_ed_pwd2.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD)
                //login_pwd.inputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD)
            }else{
                ruzhu_img_yan_pwd2.setBackgroundResource(R.mipmap.ruzhu_yan)
                ruzhu_ed_pwd2.setInputType(InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD)
            }
        }

        ruzhu_back_two.setOnClickListener {
            finish()
        }
        ruzhu_btn_xia2.setOnClickListener {
            startActivity<RuzhuThreeActivity>()
        }

    }
}