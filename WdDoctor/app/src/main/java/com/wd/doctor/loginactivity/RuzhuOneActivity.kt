package com.wd.doctor.loginactivity

import com.wd.doctor.R
import com.wd.doctor.base.BaseActivity
import com.wd.doctor.net.NetManager
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_ruzhuone_activity.*
import kotlinx.android.synthetic.main.activity_ruzhuone_activity.view.*
import org.jetbrains.anko.startActivity

class RuzhuOneActivity : BaseActivity() {
    override fun initLayoutId(): Int {
        return R.layout.activity_ruzhuone_activity
    }

    override fun initData() {
        val keshi:String ="mobile.bwstudent.com/health/share/knowledgeBase/v1/findDepartment"
       //var keshi1=NetManager.netManager.retrofitUtil.baseUrl(keshi)
        //println("aaaaaaa"+keshi1)




    }

    override fun initListener() {
        ruzhu_back_one.setOnClickListener {
            finish()
        }
        ruzhu_btn_xia.setOnClickListener {
            startActivity<RuzhuTwoActivity>()
        }


    }
}