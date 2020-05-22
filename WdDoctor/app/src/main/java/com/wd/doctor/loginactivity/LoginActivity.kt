package com.wd.doctor.loginactivity

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.text.TextUtils
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


    override fun initLayoutId(): Int {
        return R.layout.activity_login
    }

    override fun initData() {
        var userEmail=SpCacheUtil.spCacheUtil.getStringData("userEmail")
        var userPwd= SpCacheUtil.spCacheUtil.getStringData("userPwd")
       // println("dddddddd"+aa)
        userEmail?.let {
            login_em.setText(userEmail)
        }
        userPwd?.let {
            login_pwd.setText(userPwd)
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
            val email=login_em.text.toString()
            val pwd=  login_pwd.text.toString()


            val pwdmi = RsaCoder.encryptByPublicKey(pwd)
            if (TextUtils.isEmpty(email)&&TextUtils.isEmpty(pwd)){
                myToast("邮箱或密码不能为空")
            } else{
                val  encypwd=RsaCoder.encryptByPublicKey(pwd)
                SpCacheUtil.spCacheUtil.saveStringData("userEmail",email)
                SpCacheUtil.spCacheUtil.saveStringData("userPwd",pwd)
                presenter.onLoginSuccess(email,encypwd)
            }

            //presenter.onLoginSuccess(eamil,pwdmi)
            println("++++"+pwdmi)
            //startActivityAndFinish<HomeActivity>()
        }

    }

    override fun onLoginSuccess(response: LoginBean) {
        if (response?.status.equals("0000")){
            val doctorId=response?.result?.id
            val sessionId=response?.result?.sessionId
            SpCacheUtil.spCacheUtil.saveIntData("doctorId", doctorId!!)
            SpCacheUtil.spCacheUtil.saveStringData("sessionId", sessionId!!)
            startActivityAndFinish<HomeActivity>()
            myToast(response?.message.toString())
        }else{
            myToast(response?.message.toString())
        }

        /*println("Login"+response.message)

        val doctorId=response.result.id
        SpCacheUtil.spCacheUtil.saveIntData("doctorId",doctorId)

        val sessionId=response.result.sessionId
        SpCacheUtil.spCacheUtil.saveStringData("sessionId",sessionId)

        val intent = Intent(this,HomeActivity::class.java)
        //intent.addFlags(FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)*/
    }

    override fun onLoginError(msg: String) {
        println("Login"+msg)
    }
}