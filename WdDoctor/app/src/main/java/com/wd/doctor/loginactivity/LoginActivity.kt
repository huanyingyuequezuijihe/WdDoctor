package com.wd.doctor.loginactivity

import com.wd.doctor.R
import com.wd.doctor.activity.HomeActivity
import com.wd.doctor.base.BaseActivity
import com.wd.doctor.bean.cs.LoginBean
import com.wd.doctor.mvp.cs.csmodel.CsLoginLoginModel
import com.wd.doctor.mvp.cs.csview.CsLoginView
import com.wd.doctor.net.App
import com.wd.doctor.util.RsaCoder
import com.wd.doctor.util.SpCacheUtil
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity(),CsLoginView {
    val presenter by lazy { CsLoginLoginModel (this) }
    var em:String =""
    var pwd:String =""


    override fun initLayoutId(): Int {
        return R.layout.activity_login
    }

    override fun initData() {
        var userEmail=SpCacheUtil.spCacheUtil.getStringData("userEmail")
       // println("dddddddd"+aa)
        userEmail?.let {
            var userPwd= SpCacheUtil.spCacheUtil.getStringData("userPwd")
            userPwd?.let {
                login_em.setText(userEmail)
                login_pwd.setText(userPwd)
            }

        }

/*
        if (!sp.getStringData("userEmail").isNullOrEmpty()){
            startActivityAndFinish<HomeActivity>()
        }else{
            sp.getStringData("userEmail")
            sp.getStringData("userPwd")
            login_em.setText(em)
            login_pwd.setText(pwd)

        }*/

    }

    override fun initListener() {
        login_tv_ruzhu.setOnClickListener {
            startActivityAndFinish<RuzhuOneActivity>()

        }
        login_btn.setOnClickListener {

            em=login_em.text.toString()
            pwd = login_pwd.text.toString()


            val pwdmi = RsaCoder.encryptByPublicKey(pwd)
            presenter.onLoginSuccess(em,pwdmi)
            println("++++"+pwdmi)
            //startActivityAndFinish<HomeActivity>()
        }

    }

    override fun onLoginSuccess(response: LoginBean) {
        println("Login"+response.message)

        SpCacheUtil.spCacheUtil.saveStringData("userEmail",em)
        SpCacheUtil.spCacheUtil.saveStringData("userPwd",pwd)

        val dovtorId=response.result.id.toString()
        SpCacheUtil.spCacheUtil.saveStringData("dovtorId",dovtorId)

        val sessionId=response.result.sessionId
        SpCacheUtil.spCacheUtil.saveStringData("sessionId",sessionId)

        startActivityAndFinish<HomeActivity>()

    }

    override fun onLoginError(msg: String) {
        println("Login"+msg)
    }
}