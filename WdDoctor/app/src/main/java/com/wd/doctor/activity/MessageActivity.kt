package com.wd.doctor.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wd.doctor.R
import com.wd.doctor.base.BaseActivity
import com.wd.doctor.bean.wy.ModifyAllStatusBean
import com.wd.doctor.mvp.wy.presenter.ModifyAllStatusPresenter
import com.wd.doctor.mvp.wy.presenterImpl.ModifyAllStatusPresenterImpl
import com.wd.doctor.mvp.wy.view.ModifyAllStatusView
import kotlinx.android.synthetic.main.activity_message.*

class MessageActivity : BaseActivity(), ModifyAllStatusView {
    val presenter by lazy { ModifyAllStatusPresenterImpl(this) }
    override fun initLayoutId(): Int {
        return R.layout.activity_message
    }

    override fun initListener() {
        super.initListener()
        imgBackMessage.setOnClickListener {
            finish()
        }
        //系统消息
        linearMessageX.setOnClickListener {
            startActivityTo<XiTongMessageActivity>()
        }
        //问诊消息
        linearMessageAsk.setOnClickListener {
            startActivityTo<AskMessageActivity>()
        }
        //H币 入账消息
        linearMessageH.setOnClickListener {
            startActivityTo<HMessageActivity>()
        }
        //已读 全部消息
        tvAllMessage.setOnClickListener {
            presenter.onModifyAllStatusData()
        }
    }

    override fun onModifyAllStatusViewError(message: String) {
    }

    override fun onModifyAllStatusViewSuccess(response: ModifyAllStatusBean) {
        val toString = response.message.toString()
        myToast(toString)
    }
}
