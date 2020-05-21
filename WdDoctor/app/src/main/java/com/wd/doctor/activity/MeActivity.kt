package com.wd.doctor.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.wd.doctor.R
import com.wd.doctor.adapter.RecyclerViewMe
import com.wd.doctor.base.BaseActivity
import kotlinx.android.synthetic.main.activity_me.*

class MeActivity :BaseActivity() {
    override fun initLayoutId(): Int {
        return R.layout.activity_me
    }

    override fun initListener() {
        super.initListener()
        imgBackMe.setOnClickListener {
            finish()
        }
    }

    override fun initData() {
        super.initData()
        val gridLayoutManager = GridLayoutManager(this, 2)
        recyclerMe.layoutManager=gridLayoutManager
        //适配器
        val list:List<String> = listOf("历史问诊","我的钱包","被采纳的建议","设置自动回复")
        val recyclerViewMe = RecyclerViewMe(list, this)
        recyclerMe.adapter=recyclerViewMe
    }
}
