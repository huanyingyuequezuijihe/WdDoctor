package com.wd.doctor.loginactivity

import android.text.TextUtils
import com.wd.doctor.R
import com.wd.doctor.activity.HomeActivity
import com.wd.doctor.base.BaseActivity
import com.wd.doctor.bean.cs.LoginBean
import com.wd.doctor.mvp.cs.csmodel.CsLoginLoginModel
import com.wd.doctor.mvp.cs.csview.CsLoginView
import com.wd.doctor.net.App
import com.wd.doctor.util.RegularUtil
import com.wd.doctor.util.RsaCoder
import com.wd.doctor.util.SpCacheUtil
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity

class LoginActivity : BaseActivity(),CsLoginView {
    val presenter by lazy { CsLoginLoginModel (this) }
   /* var em:String =""
    var pwd:String =""*/


    override fun initLayoutId(): Int {
        return R.layout.activity_login
    }

    override fun initData() {
        var userEmail=SpCacheUtil.spCacheUtil.getStringData("userEmail")
        var userPwd= SpCacheUtil.spCacheUtil.getStringData("userPwd")

        //https 为甚么  安全

       // println("dddddddd"+aa)
        /*userEmail?.let {
            var userPwd= SpCacheUtil.spCacheUtil.getStringData("userPwd")
            userPwd?.let {
                login_em.setText(userEmail)
                login_pwd.setText(userPwd)
            }

        }*/
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
            startActivity<RuzhuOneActivity>()

        }
        login_btn.setOnClickListener {
            val email=login_em.text.toString()
            val pwd=  login_pwd.text.toString()



            val pwdmi = RsaCoder.encryptByPublicKey(pwd)
            if (TextUtils.isEmpty(email)&& TextUtils.isEmpty(pwd)){
                myToast("邮箱或密码不能为空")
            } else{
                val  encypwd=RsaCoder.encryptByPublicKey(pwd)
                SpCacheUtil.spCacheUtil.saveStringData("userEmail",email)
                SpCacheUtil.spCacheUtil.saveStringData("userPwd",pwd)
                presenter.onLoginSuccess(email,encypwd)
            }

            //presenter.onLoginSuccess(eamil,pwdmi)
            println("++++"+pwdmi)
            /*val pwdmi = RsaCoder.encryptByPublicKey(pwd)
            presenter.onLoginSuccess(em,pwdmi)
            println("++++"+pwdmi)
            //startActivityAndFinish<HomeActivity>()*/
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

       /* SpCacheUtil.spCacheUtil.saveStringData("userEmail",em)
        SpCacheUtil.spCacheUtil.saveStringData("userPwd",pwd)

        val dovtorId=response.result.id.toString()
        SpCacheUtil.spCacheUtil.saveStringData("dovtorId",dovtorId)

        val sessionId=response.result.sessionId
        SpCacheUtil.spCacheUtil.saveStringData("sessionId",sessionId)

        startActivityAndFinish<HomeActivity>()*/

    }

    override fun onLoginError(msg: String) {
        println("Login"+msg)
    }
}