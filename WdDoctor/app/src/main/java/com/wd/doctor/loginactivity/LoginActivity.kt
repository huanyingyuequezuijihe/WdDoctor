package com.wd.doctor.loginactivity

import android.text.InputType
import android.text.TextUtils
import android.view.View
import android.widget.CompoundButton
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

    override fun initLayoutId(): Int {
        return R.layout.activity_login
    }

    override fun initData() {
        var userEmail=SpCacheUtil.spCacheUtil.getStringData("userEmail")
        var userPwd= SpCacheUtil.spCacheUtil.getStringData("userPwd")

        userEmail?.let {
            login_em.setText(userEmail)
        }
        userPwd?.let {
            login_pwd.setText(userPwd)
        }
    }

    override fun initListener() {
        login_img_yan.setOnCheckedChangeListener{View,isChecked ->
            if (isChecked){
                login_img_yan.setBackgroundResource(R.mipmap.ruzhu_yan_zhang)
                login_pwd.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD)
                //login_pwd.inputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD)
            }else{
                login_img_yan.setBackgroundResource(R.mipmap.ruzhu_yan)
                login_pwd.setInputType(InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD)
            }
        }

        login_tv_wang.setOnClickListener {
            startActivity<WangActivity>()
        }
        login_tv_ruzhu.setOnClickListener {
            startActivity<RuzhuTwoActivity>()

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
    }

    override fun onLoginError(msg: String) {
        println("Login"+msg)
    }
}