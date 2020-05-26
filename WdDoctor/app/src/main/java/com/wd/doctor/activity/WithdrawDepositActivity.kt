package com.wd.doctor.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.wd.doctor.R
import com.wd.doctor.base.BaseActivity
import kotlinx.android.synthetic.main.activity_withdraw_deposit.*
import org.jetbrains.anko.startActivity

/*提现*/
class WithdrawDepositActivity : BaseActivity() {
    override fun initListener() {
        super.initListener()
    /*    btn_tixian.setOnClickListener {
            startActivity<WithdrawDepositNextActivity>()
        }
        tixian_record.setOnClickListener {
            startActivity<TixianRecordActivity>()
        }*/
    }
    override fun initLayoutId(): Int {
        return R.layout.activity_withdraw_deposit
    }

    fun back(view: View) {
        finish()
    }
}
