package com.wd.doctor.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.wd.doctor.R
import com.wd.doctor.adapter.wy.RecyclerViewGiftAdapter
import com.wd.doctor.base.BaseActivity
import com.wd.doctor.bean.wy.FindDoctorGiftListBean
import com.wd.doctor.mvp.wy.presenterImpl.DoctorGiftListPresenterImpl
import com.wd.doctor.mvp.wy.view.DoctorGiftListView
import kotlinx.android.synthetic.main.activity_my_gift.*

class MyGiftActivity : BaseActivity(), DoctorGiftListView{
    //懒
    val adapter by lazy { RecyclerViewGiftAdapter() }
    val presenter by lazy { DoctorGiftListPresenterImpl(this) }
    override fun initLayoutId(): Int {
        return R.layout.activity_my_gift
    }

    override fun initListener() {
        super.initListener()
        imgBackGift.setOnClickListener { finish() }
    }

    override fun initData() {
        super.initData()
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerGift.layoutManager= linearLayoutManager
        presenter.onFindDoctorByIdSuccess(1,10)
    }

    override fun onFindDoctorByIdSuccess(response: FindDoctorGiftListBean) {
        //成功
        val result = response.result
        recyclerGift.adapter=adapter
        adapter.updetadate(result)
    }

    override fun onFindDoctorByIdError(msg: String) {
    }
}
