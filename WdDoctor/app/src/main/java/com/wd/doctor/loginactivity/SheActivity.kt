package com.wd.doctor.loginactivity

import android.text.TextUtils
import com.wd.doctor.R
import com.wd.doctor.base.BaseActivity
import com.wd.doctor.bean.cs.ChongZhiBean
import com.wd.doctor.mvp.cs.csmodel.CsChongZhiModel
import com.wd.doctor.mvp.cs.csview.CsChongZhiView
import com.wd.doctor.util.RsaCoder
import com.wd.doctor.util.SpCacheUtil
import kotlinx.android.synthetic.main.she_activity.*
import org.jetbrains.anko.startActivity

/**
 * @author: asus
 * @date: 20/5/26
 */
class SheActivity: BaseActivity(),CsChongZhiView {
    val presenter by lazy { CsChongZhiModel (this) }

    override fun initLayoutId(): Int {
        return R.layout.she_activity
    }

    override fun initData() {
        var bundle = this.intent.extras
        //bundle.get("name").toString()
        var zhang= bundle?.get("name").toString()
        println("aaaaaaa"+zhang)


    }


    override fun initListener() {
        ruzhu_back_she.setOnClickListener {
            finish()
        }
        wang_btn_ok.setOnClickListener {
            val pwd1=chongzhi_ed_pwd.text.toString()
            val pwd2=chongzhi_ed_pwd2.text.toString()

            if (TextUtils.isEmpty(pwd1)&&TextUtils.isEmpty(pwd2)){
                myToast("密码不能为空")
            }else{
                var bundle = this.intent.extras
                //bundle.get("name").toString()
                var zhang= bundle?.get("name").toString()
                val  encypwd1= RsaCoder.encryptByPublicKey(pwd1)
                SpCacheUtil.spCacheUtil.saveStringData("encypwd1",encypwd1)

                var encypwd2= SpCacheUtil.spCacheUtil.getStringData("encypwd1").toString()

                println("jjjjjjjj"+encypwd1)

                presenter.onChongZhiSuccess(zhang,encypwd1,encypwd2)
                startActivityAndFinish<LoginActivity>()
            }


        }
    }

    override fun onChongZhiSuccess(response: ChongZhiBean) {
        println("密码重置"+response)

    }

    override fun onChongZhiError(msg: String) {
        println("密码重置"+msg)
    }
}