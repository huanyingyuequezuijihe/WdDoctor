package com.wd.doctor.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wd.doctor.R
import com.wd.doctor.base.BaseActivity
import kotlinx.android.synthetic.main.activity_withdraw_deposit_next.*

//去提现
class WithdrawDepositNextActivity : BaseActivity() {
    /*override fun getOverridePendingTransitionMode(): TransitionMode? {
        return  TransitionMode.FADE
    }
*/
    override fun initLayoutId(): Int {
        return  R.layout.activity_withdraw_deposit_next
    }

    override fun initListener() {
        super.initListener()
        //完成后  先 销毁
        btn_finish.setOnClickListener { finish() }
    }
}
