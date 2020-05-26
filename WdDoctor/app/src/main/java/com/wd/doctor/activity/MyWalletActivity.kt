package com.wd.doctor.activity

import android.view.View
import com.wd.doctor.R
import com.wd.doctor.base.BaseActivity
import kotlinx.android.synthetic.main.activity_mywallet.*
import org.jetbrains.anko.startActivity
/*钱包*/
class MyWalletActivity : BaseActivity() {
   /* override fun getOverridePendingTransitionMode(): TransitionMode? {
        return  TransitionMode.TOP
    }*/
    val bd=2
    override fun initLayoutId(): Int {
        return  R.layout.activity_mywallet
    }

    override fun initListener() {
        super.initListener()
        //返回
        imgBackWallet.setOnClickListener { finish() }
        //绑定
        tvBinDing.setOnClickListener {
            startActivityTo<BindingWuActivity>()
        }
        my_money
        //提现
        btnTixian.setOnClickListener {  }
        my_money_recyclerView
    }

    override fun initData() {
    }
}
