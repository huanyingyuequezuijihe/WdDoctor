package com.wd.doctor.loginactivity

import com.wd.doctor.R
import com.wd.doctor.base.BaseActivity
import com.wd.doctor.bean.cs.LoginBean
import com.wd.doctor.bean.cs.RegistBean
import com.wd.doctor.mvp.cs.csmodel.CsLoginRegistModel
import com.wd.doctor.mvp.cs.csview.CsRegistView
import com.wd.doctor.util.SpCacheUtil
import kotlinx.android.synthetic.main.activity_ru_zhu_succ.*

class RuZhuSuccActivity : BaseActivity(),CsRegistView {
    val presenter by lazy { CsLoginRegistModel (this) }
    override fun initLayoutId(): Int {
        return R.layout.activity_ru_zhu_succ
    }

    override fun initData() {
        var geren= SpCacheUtil.spCacheUtil.getStringData("grjl").toString()
        var shanchang= SpCacheUtil.spCacheUtil.getStringData("scly").toString()
        var name= SpCacheUtil.spCacheUtil.getStringData("name").toString()
        var yiyuan= SpCacheUtil.spCacheUtil.getStringData("yiyuan").toString()
        var keshiid= SpCacheUtil.spCacheUtil.getIntData("keshiid")
        var zhichengid= SpCacheUtil.spCacheUtil.getIntData("zhichengid")
        var ruzhupwd1= SpCacheUtil.spCacheUtil.getStringData("ruzhupwd1").toString()
        var email= SpCacheUtil.spCacheUtil.getStringData("email").toString()
        var yan= SpCacheUtil.spCacheUtil.getStringData("yan").toString()
        println("ccccccc------个人简历"+geren.toString())
        println("ccccccc------擅长领域"+shanchang.toString())
        println("ccccccc------名字"+name.toString())
        println("ccccccc------医院"+yiyuan.toString())
        println("ccccccc------科室id"+keshiid.toString())
        println("ccccccc------职称id"+zhichengid.toString())
        println("ccccccc------入驻密码"+ruzhupwd1.toString())
        println("ccccccc------邮箱"+email.toString())
        println("ccccccc------验证码"+yan.toString())
        presenter.onRegistSuccess(email,yan,ruzhupwd1,ruzhupwd1,name,yiyuan,keshiid,zhichengid,geren,shanchang)
    }

    override fun initListener() {
        back.setOnClickListener {
            finish()
        }
    }

    override fun onRegistSuccess(response: RegistBean) {
        println("申请入驻"+response)
    }

    override fun onRegistError(msg: String) {
        println("申请入驻"+msg)
    }


}
