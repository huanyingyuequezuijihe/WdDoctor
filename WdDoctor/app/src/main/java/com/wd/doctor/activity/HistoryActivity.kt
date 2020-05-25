package com.wd.doctor.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.wd.doctor.R
import com.wd.doctor.adapter.wy.RecyclerViewHistoryAdapter
import com.wd.doctor.base.BaseActivity
import com.wd.doctor.bean.wy.FindHistoryInquiryRecordBean
import com.wd.doctor.mvp.wy.presenterImpl.HistoryInquiryRecordPresenterImpl
import com.wd.doctor.mvp.wy.view.HistoryInquiryRecordView
import kotlinx.android.synthetic.main.activity_history.*

//历史问诊 页面
class HistoryActivity : BaseActivity(), HistoryInquiryRecordView{
    val presenter by lazy { HistoryInquiryRecordPresenterImpl(this) }
    val adapter by lazy { RecyclerViewHistoryAdapter() }
    override fun initLayoutId(): Int {
        return R.layout.activity_history
    }

    override fun initListener() {
        super.initListener()
        imgBackHistory.setOnClickListener {finish()}
        //已收到的礼物
        tvGift.setOnClickListener {
            startActivityTo<MyGiftActivity>()
        }
    }

    override fun initData() {
        super.initData()
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerHistory.layoutManager= linearLayoutManager
        //请求
        presenter.onHistoryInquiryRecordData(1,10)
    }
    override fun onHistoryInquiryRecordError(message: String) {
    }

    override fun onHistoryInquiryRecordSuccess(response: FindHistoryInquiryRecordBean) {
        //适配器
        recyclerHistory.adapter=adapter
        val result = response.result
        adapter.updateList(result)
    }
}
