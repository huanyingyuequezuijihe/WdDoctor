package com.wd.doctor.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wd.doctor.R
import com.wd.doctor.base.BaseActivity
import kotlinx.android.synthetic.main.activity_automatic.*
//自动回复页面
class AutomaticActivity : BaseActivity() {
    override fun initLayoutId(): Int {
        return R.layout.activity_automatic
    }

    override fun initListener() {
        super.initListener()
        imgBackAutomatic.setOnClickListener { finish() }
        //消息页
        imgMessageAutomatic.setOnClickListener { startActivityTo<MessageActivity>() }
        //当选中一个，其他的不选中
        ckBox1.setOnClickListener {
            val checked = ckBox1.isChecked
            if(checked){
                ckBox2.isChecked=false
                ckBox3.isChecked=false
                ckBox4.isChecked=false
            }
        }
        ckBox2.setOnClickListener {
            val checked = ckBox2.isChecked
            if(checked){
                ckBox1.isChecked=false
                ckBox3.isChecked=false
                ckBox4.isChecked=false
            }
        }
        ckBox3.setOnClickListener {
            val checked = ckBox3.isChecked
            if(checked){
                ckBox2.isChecked=false
                ckBox1.isChecked=false
                ckBox4.isChecked=false
            }
        }
        ckBox4.setOnClickListener {
            val checked = ckBox4.isChecked
            if(checked){
                ckBox2.isChecked=false
                ckBox3.isChecked=false
                ckBox1.isChecked=false
            }
        }

    }

    override fun initData() {
        super.initData()
    }
}
