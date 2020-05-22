package com.wd.doctor.loginactivity

import com.wd.doctor.R
import com.wd.doctor.activity.HomeActivity
import com.wd.doctor.base.BaseActivity
import com.wd.doctor.bean.cs.LoginBean
import com.wd.doctor.mvp.cs.csmodel.CsModel
import com.wd.doctor.mvp.cs.csview.CsView
import com.wd.doctor.util.RsaCoder
import com.wd.doctor.util.SpCacheUtil
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.toast

class LoginActivity : BaseActivity(),CsView {
    val presenter by lazy { CsModel (this) }
    val sp by lazy { SpCacheUtil  }


    override fun initLayoutId(): Int {
        return R.layout.activity_login
    }

    override fun initData() {

    }

    override fun initListener() {
        login_tv_ruzhu.setOnClickListener {
            startActivityAndFinish<RuzhuOneActivity>()

        }
        login_btn.setOnClickListener {
            val em = login_em.text.toString()
            val pwd = login_pwd.text.toString()
            val pwdmi = RsaCoder.encryptByPublicKey(pwd)
            presenter.onLoginSuccess(em,pwdmi)
            println("++++"+pwdmi)
        }

    }

    override fun onLoginSuccess(response: LoginBean) {
        println("Login"+response.message)
        startActivityAndFinish<HomeActivity>()


    }

    override fun onLoginError(msg: String) {
        println("Login"+msg)
    }
}