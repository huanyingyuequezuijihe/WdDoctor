package com.wd.doctor.loginactivity

import android.graphics.Color
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.wd.doctor.R
import com.wd.doctor.base.BaseActivity
import com.wd.doctor.util.SpCacheUtil
import kotlinx.android.synthetic.main.activity_ruzhuthree_activity.*
import org.jetbrains.anko.startActivity

class RuzhuThreeActivity : BaseActivity() {


    override fun initLayoutId(): Int {
        return R.layout.activity_ruzhuthree_activity
    }

    override fun initData() {



    }
    override fun initListener() {
        ruzhu_back_three.setOnClickListener {
            finish()
        }
        regist_btn_shen.setOnClickListener {
            var  grjl= doctor_resume.text.toString()
            var  scly= doctor_adept.text.toString()
            SpCacheUtil.spCacheUtil.saveStringData("grjl",grjl)
            SpCacheUtil.spCacheUtil.saveStringData("scly",scly)

            startActivityAndFinish<RuZhuSuccActivity>()

        }
        doctor_resume.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                var  countre=   doctor_resume.length()
                countre=500-countre
                resume_count.setText("${countre}/500")
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })
        doctor_adept.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                var  countad=   doctor_adept.length()
                countad=300-countad
                adept_count.setText("${countad}/300")
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })

        doctor_resume.setOnFocusChangeListener(object :View.OnFocusChangeListener{
            override fun onFocusChange(v: View?, hasFocus: Boolean) {
                if (hasFocus){
                    doctor_resume.setTextColor(Color.BLACK)
                }else{
                    doctor_resume.setTextColor(Color.GRAY)
                }
            }

        })
        doctor_adept.setOnFocusChangeListener(object :View.OnFocusChangeListener{
            override fun onFocusChange(v: View?, hasFocus: Boolean) {
                if (hasFocus){
                    doctor_adept.setTextColor(Color.BLACK)
                }else{
                    doctor_adept.setTextColor(Color.GRAY)
                }
            }

        })

    }

}