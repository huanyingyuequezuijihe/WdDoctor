package com.wd.doctor.activity

import android.view.View
import com.wd.doctor.R
import com.wd.doctor.base.BaseActivity
import com.wd.doctor.activity.WithdrawDepositActivity
import com.wd.doctor.bean.wy.FindDoctorWalletBean
import com.wd.doctor.mvp.wy.presenterImpl.FindDoctorWalletPresenterImpl
import com.wd.doctor.mvp.wy.view.FindDoctorWalletView
import kotlinx.android.synthetic.main.activity_mywallet.*
import org.jetbrains.anko.startActivity
/*钱包*/
class MyWalletActivity : BaseActivity(), FindDoctorWalletView{
   /* override fun getOverridePendingTransitionMode(): TransitionMode? {
        return  TransitionMode.TOP
    }*/
    val bd=2
    //presenter
    val presenter by lazy { FindDoctorWalletPresenterImpl(this) }
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
        //my_money
        //提现
        btnTixian.setOnClickListener {
            startActivityTo<WithdrawDepositActivity>()
        }
        //my_money_recyclerView
    }

    override fun initData() {
        presenter.onFindDoctorWalletSuccess()
    }

    override fun onFindDoctorWalletError(message: String) {
    }

    override fun onFindDoctorWalletSuccess(response: FindDoctorWalletBean) {
        //成功
        val result = response.result
        val whetherBindIdCard = result.whetherBindIdCard
        val whetherBindBankCard = result.whetherBindBankCard
        if(whetherBindIdCard!=1){
            tvBinDing.setText("查看绑定")
        }
        if(whetherBindBankCard!=1){
            tvBinDing.setText("查看绑定")
        }
        tvMyMoney.setText(""+result.balance)
    }
}
