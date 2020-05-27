package com.wd.doctor.loginactivity

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import com.wd.doctor.R
import com.wd.doctor.base.BaseActivity
import com.wd.doctor.bean.SendEmailCodeBean
import com.wd.doctor.bean.cs.YanEmailBean
import com.wd.doctor.mvp.cs.csmodel.CsFaYanModel
import com.wd.doctor.mvp.cs.csmodel.CsJiaoYanModel
import com.wd.doctor.mvp.cs.csview.CsFaYanView
import com.wd.doctor.mvp.cs.csview.CsJiaoYanView
import kotlinx.android.synthetic.main.wang_activity.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.startActivity

/**
 * @author: asus
 * @date: 20/5/26
 */
class WangActivity: BaseActivity(),CsJiaoYanView,CsFaYanView {
    val presenter by lazy { CsJiaoYanModel (this) }
    val presenterfa by lazy { CsFaYanModel (this) }

    override fun initLayoutId(): Int {
        return R.layout.wang_activity
    }

    override fun initListener() {
        ruzhu_back_wang.setOnClickListener {
            finish()
        }
        get_wang_yan.setOnClickListener {
            val email=wang_ed_zhang.text.toString()

            if (TextUtils.isEmpty(email)){
                myToast("邮箱不能为空")
            }else{
                presenterfa.onFaYanSuccess(email)
            }


        }
        wang_btn_xia.setOnClickListener {
            val zhang=wang_ed_zhang.text.toString()
            val yan=wang_ed_yan.text.toString()
            if (TextUtils.isEmpty(yan)){
                myToast("验证码不能为空")
            }else{
                presenter.onLoginSuccess(zhang,yan)

                var intent = Intent(this,SheActivity::class.java)
                var bundle = Bundle()
                bundle.putString("name",zhang)
                intent.putExtras(bundle)
                startActivity(intent)
                finish()

            }






        }
    }

    override fun onLoginSuccess(response: YanEmailBean) {
        println("校验"+response)
    }

    override fun onLoginError(msg: String) {
        println("校验"+msg)
    }

    override fun onFaYanSuccess(response: SendEmailCodeBean) {
        println("获取验证码"+response)

    }

    override fun onFaYanError(msg: String) {
        println("获取验证码"+msg)

    }
}