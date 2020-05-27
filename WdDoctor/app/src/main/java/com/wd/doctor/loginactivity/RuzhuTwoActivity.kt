package com.wd.doctor.loginactivity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.os.SystemClock
import android.text.InputType
import android.text.TextUtils
import com.wd.doctor.R
import com.wd.doctor.base.BaseActivity
import com.wd.doctor.bean.SendEmailCodeBean
import com.wd.doctor.mvp.cs.csmodel.CsFaYanModel
import com.wd.doctor.mvp.cs.csview.CsFaYanView
import com.wd.doctor.util.RsaCoder
import com.wd.doctor.util.SpCacheUtil
import kotlinx.android.synthetic.main.activity_ruzhutwo_activity.*
import org.jetbrains.anko.startActivity

class RuzhuTwoActivity : BaseActivity(),CsFaYanView {
    val presenterfa by lazy { CsFaYanModel (this) }
    var time=60
    val handler=object : Handler(){
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            when(msg.what){
                100 -> {
                    tv_get_captcha.setEnabled(false)
                    tv_get_captcha.text= "(${time}s)后重新获取"
                }
                200->{
                    tv_get_captcha.setEnabled(true)
                    tv_get_captcha.text= "获取验证码"
                }
            }
        }
    }

    override fun initLayoutId(): Int {
        return R.layout.activity_ruzhutwo_activity
    }

    override fun initData() {


    }

    override fun initListener() {
        tv_get_captcha.setOnClickListener {
            val email=ruzhu_ed_zhang.text.toString()
            if (TextUtils.isEmpty(email)){
                myToast("邮箱不能为空")
            }else{
                send()
            }

        }
        ruzhu_img_yan_pwd1.setOnCheckedChangeListener{View,isChecked ->
            if (isChecked){
                ruzhu_img_yan_pwd1.setBackgroundResource(R.mipmap.ruzhu_yan_zhang)
                ruzhu_ed_pwd.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD)
                //login_pwd.inputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD)
            }else{
                ruzhu_img_yan_pwd1.setBackgroundResource(R.mipmap.ruzhu_yan)
                ruzhu_ed_pwd.setInputType(InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD)
            }
        }
        ruzhu_img_yan_pwd2.setOnCheckedChangeListener{View,isChecked ->
            if (isChecked){
                ruzhu_img_yan_pwd2.setBackgroundResource(R.mipmap.ruzhu_yan_zhang)
                ruzhu_ed_pwd2.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD)
                //login_pwd.inputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD)
            }else{
                ruzhu_img_yan_pwd2.setBackgroundResource(R.mipmap.ruzhu_yan)
                ruzhu_ed_pwd2.setInputType(InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD)
            }
        }

        ruzhu_back_two.setOnClickListener {
            finish()
        }
        ruzhu_btn_xia2.setOnClickListener {

            val zhang=ruzhu_ed_zhang.text.toString()
            val yan=ruzhu_ed_code.text.toString()
            val pwd1=ruzhu_ed_pwd.text.toString()
            val pwd2=ruzhu_ed_pwd2.text.toString()
            if (TextUtils.isEmpty(zhang)&&TextUtils.isEmpty(yan)){
                myToast("邮箱或验证码不能为空")
            }else{
                if (TextUtils.isEmpty(pwd1)&&TextUtils.isEmpty(pwd2)){
                    myToast("密码不能为空")
                }else{
                    val  encypwd1= RsaCoder.encryptByPublicKey(pwd1)
                    SpCacheUtil.spCacheUtil.saveStringData("ruzhupwd1",encypwd1)
                    //var encypwd2= SpCacheUtil.spCacheUtil.getStringData("ruzhupwd1").toString()

                    var intent = Intent(this,RuzhuOneActivity::class.java)
                    var bundle = Bundle()
                    bundle.putString("name",zhang)
                    bundle.putString("email",yan)
                    intent.putExtras(bundle)
                    startActivity(intent)
                    finish()

                }

            }

        }

    }
    //发送验证码
    private fun send() {
        time=60
        var  email= ruzhu_ed_zhang.text.toString()
        presenterfa.onFaYanSuccess(email)
        Thread(){
            kotlin.run {
                while (time>0){
                    handler.sendEmptyMessage(100)
                    time--
                    SystemClock.sleep(1000)

                }
                if (time==0){
                    handler.sendEmptyMessage(200)
                }
            }
        }.start()

    }

    override fun onFaYanSuccess(response: SendEmailCodeBean) {
        println("验证码"+response)
    }

    override fun onFaYanError(msg: String) {
        println("验证码"+msg)
    }
}