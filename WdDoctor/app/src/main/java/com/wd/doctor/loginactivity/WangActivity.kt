package com.wd.doctor.loginactivity

import com.wd.doctor.R
import com.wd.doctor.base.BaseActivity
import com.wd.doctor.bean.cs.YanEmailBean
import com.wd.doctor.mvp.cs.csmodel.CsFaYanModel
import com.wd.doctor.mvp.cs.csmodel.CsJiaoYanModel
import com.wd.doctor.mvp.cs.csview.CsJiaoYanView
import kotlinx.android.synthetic.main.wang_activity.*
import org.jetbrains.anko.startActivity

/**
 * @author: asus
 * @date: 20/5/26
 */
class WangActivity: BaseActivity(),CsJiaoYanView {
    val presenter by lazy { CsJiaoYanModel (this) }
    //val presenterfa by lazy { CsFaYanModel (this) }

    override fun initLayoutId(): Int {
        return R.layout.wang_activity
    }

    override fun initListener() {
        ruzhu_back_wang.setOnClickListener {
            finish()
        }
        get_wang_yan.setOnClickListener {


        }
        wang_btn_xia.setOnClickListener {
            val zhang=wang_ed_zhang.text.toString()
            val yan=wang_ed_yan.text.toString()



            startActivity<SheActivity>()
        }
    }

    override fun onLoginSuccess(response: YanEmailBean) {

    }

    override fun onLoginError(msg: String) {

    }
}