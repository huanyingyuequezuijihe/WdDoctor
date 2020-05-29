package com.wd.doctor.activity

import android.content.Intent
import android.os.Handler
import android.os.Message
import androidx.recyclerview.widget.LinearLayoutManager
import com.wd.doctor.R
import com.wd.doctor.adapter.wy.RecyclerViewUserChatAdapter
import com.wd.doctor.base.BaseActivity
import com.wd.doctor.bean.wy.FindInquiryDetailsListBean
import com.wd.doctor.bean.wy.PushMessageBean
import com.wd.doctor.mvp.wy.presenterImpl.FindInquiryDetailsListPresenterImpl
import com.wd.doctor.mvp.wy.presenterImpl.PushMessagePresenterImpl
import com.wd.doctor.mvp.wy.view.FindInquiryDetailsListView
import com.wd.doctor.mvp.wy.view.PushMessageView
import kotlinx.android.synthetic.main.activity_user_chat.*
//聊天页
class UserChatActivity : BaseActivity(), PushMessageView, FindInquiryDetailsListView{
    //发消息的presenter
    val presenter by lazy{ PushMessagePresenterImpl(this)}
    //聊天记录的presenter
    val presenterChat by lazy { FindInquiryDetailsListPresenterImpl(this) }
    //handler
    var handler: Handler = object : Handler() {
        override fun handleMessage(msg: Message) {}
    }
    var  runnable:Runnable=object:Runnable{
        override fun run() {
            SendRequestWithOkhttp() //发送请求
            handler.postDelayed(this,3000)
        }
    }
    fun SendRequestWithOkhttp(){
        Thread(){
            kotlin.run {
                val message = handler.obtainMessage()
                handler.sendMessage(message)
                presenterChat.onFindInquiryDetailsListSuccess(1,10,1)
            }
        }.start()
    }
    //adapter
    val adapter by lazy{ RecyclerViewUserChatAdapter() }
    override fun initLayoutId(): Int {
        return R.layout.activity_user_chat
    }

    override fun initListener() {
        super.initListener()
        val stringExtra = getIntent().getStringExtra("name")
        //返回
        myTitleView.back?.setOnClickListener { finish() }
        stringExtra?.let {
            myTitleView.title?.setText(stringExtra)
        }
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
        runnable.run()
    }

    override fun onPushMessageViewSuccess(response: PushMessageBean) {
        //成功
        etSendContent.text=null
        val message = response.message
        myToast(message)
    }

    override fun onPushMessageViewError(msg: String) {
    }
    //聊天记录
    override fun onFindInquiryDetailsListSuccess(response: FindInquiryDetailsListBean) {
        //成功
        val result = response.result
        recyclerChat.adapter=adapter
        adapter.updataData(result)
    }

    override fun onFindInquiryDetailsListError(msg: String) {
    }
}
