package com.wd.doctor.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.wd.doctor.R
import com.wd.doctor.base.BaseActivity
import com.wd.doctor.bean.wy.PushMessageBean
import com.wd.doctor.mvp.wy.presenterImpl.PushMessagePresenterImpl
import com.wd.doctor.mvp.wy.view.PushMessageView
import kotlinx.android.synthetic.main.activity_user_chat.*

class UserChatActivity : BaseActivity(), PushMessageView{
    //发消息的presenter
    val presenter by lazy{ PushMessagePresenterImpl(this)}
    override fun initLayoutId(): Int {
        return R.layout.activity_user_chat
    }

    override fun initListener() {
        super.initListener()
        //返回
        myTitleView.back?.setOnClickListener { finish() }
        myTitleView.title?.setText("鞠婧祎")
        //发消息
        imgSendMessage.setOnClickListener {
            val etMessage = etSendContent.text.toString()
            etMessage?.let {
                presenter.onPushMessageSuccess(1,etMessage,1,256)
            }
        }
    }

    override fun initData() {
        super.initData()
        //布局管理器
        recyclerChat.layoutManager=LinearLayoutManager(this)
    }

    override fun onPushMessageViewSuccess(response: PushMessageBean) {
        //成功
        etSendContent.text=null
        val message = response.message
        myToast(message)
    }

    override fun onPushMessageViewError(msg: String) {
    }
}
