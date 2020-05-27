package com.wd.doctor.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wd.doctor.R
import com.wd.doctor.base.BaseActivity
import com.wd.doctor.bean.wy.FindDoctorByIdBean
import com.wd.doctor.mvp.wy.presenter.FindDoctorByIdPresenter
import com.wd.doctor.mvp.wy.presenterImpl.FindDoctorByIdPresenterImpl
import com.wd.doctor.mvp.wy.view.FindDoctorByIdView
import com.wd.doctor.net.NetManager
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.item_me.*

class HomeActivity : BaseActivity(),FindDoctorByIdView{
    val presenter by lazy { FindDoctorByIdPresenterImpl(this) }
    override fun initLayoutId(): Int {
        return R.layout.activity_home
    }
    override fun initListener() {
        super.initListener()
        tvAskProblem.setOnClickListener {
            startActivityTo<AskProblemActivity>()
        }
        //答疑
        tvAnswerWy.setOnClickListener {
            startActivityTo<AnswerActivity>()
        }
        //我的
        tvAdministrationWy.setOnClickListener {
            startActivityTo<MeActivity>()
        }
        //消息
        img_message_black.setOnClickListener {
            startActivityTo<MessageActivity>()
        }
    }
    override fun initData() {
        super.initData()
        val net = NetManager.netManager.net()
        println("======"+net.toString())
        presenter.onFindDoctorByIdSuccess()
    }

    override fun onFindDoctorByIdSuccess(response: FindDoctorByIdBean) {
        //成功
        println("====="+response.message)
        val result = response.result
        result?.let {
            //头像
            NetManager.netManager.getPhoto(result.imagePic,imgUserHeadPic)
            //名字
            tvName.setText(result.name)
            //医院
            tvHospital.setText(result.inauguralHospital)
            //医师等级   工作
            tvDoctor.setText(result.jobTitle)
            //科室
            tvDepartment.setText(result.departmentName)
        }
    }

    override fun onFindDoctorByIdError(msg: String) {
        //失败
        println("====="+msg)
    }
}
