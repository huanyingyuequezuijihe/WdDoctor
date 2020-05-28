package com.wd.doctor

import android.content.Context
import android.content.Intent
import android.os.Handler
import android.os.Message
import android.os.SystemClock
import com.wd.doctor.activity.HomeActivity
import com.wd.doctor.base.BaseActivity
import com.wd.doctor.loginactivity.LoginActivity
import kotlinx.android.synthetic.main.activity_q_d.*

class QDActivity : BaseActivity() {
    //不跟踪提交
    //不跟踪提交2

    var time=3
    val  handler=object:Handler(){
        override fun handleMessage(msg: Message) {
            when(msg.what){
                100 -> tv_dao.text= "跳过(${time})秒"
                200->startActivityAndFinish<LoginActivity>()
            }
        }
    }
    override fun initLayoutId(): Int {
        return R.layout.activity_q_d
    }

    override fun initData() {


    }

    override fun initListener() {
        tv_dao.setOnClickListener {
            startActivityAndFinish<LoginActivity>()
        }
        //开启线程
        Thread(cutTask()).start()
    }
    //设置倒计时
    inner class cutTask(): Runnable {
        override fun run() {
            while (time>0){
                //每秒时间--
                handler.sendEmptyMessage(100)
                SystemClock.sleep(999)
                time--
            }
            //如果为0 跳转
            if (time==0){
                handler.sendEmptyMessage(200)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacksAndMessages(null)
    }
}