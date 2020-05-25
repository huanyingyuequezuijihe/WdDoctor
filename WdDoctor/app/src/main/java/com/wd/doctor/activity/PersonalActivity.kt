package com.wd.doctor.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wd.doctor.R
import com.wd.doctor.base.BaseActivity
import com.wd.doctor.bean.wy.FindDoctorByIdBean
import com.wd.doctor.mvp.wy.presenterImpl.FindDoctorByIdPresenterImpl
import com.wd.doctor.mvp.wy.view.FindDoctorByIdView
import kotlinx.android.synthetic.main.activity_personal.*

//个人资料页面
class PersonalActivity : BaseActivity(), FindDoctorByIdView {
    val presenter by lazy { FindDoctorByIdPresenterImpl(this) }
    override fun initLayoutId(): Int {
        return R.layout.activity_personal
    }

    override fun initListener() {
        super.initListener()
        imgBackPersonal.setOnClickListener {
            finish()
        }
    }

    override fun initData() {
        super.initData()
        presenter.onFindDoctorByIdSuccess()
    }

    override fun onFindDoctorByIdSuccess(response: FindDoctorByIdBean) {
        //成功
        val result = response.result
        tvNamePersonal.setText(result.name)
        tvHospitalPersonal.setText(result.inauguralHospital)
        tvDepartmentPersonal.setText(result.departmentName)
        tvJobTitlePersonal.setText(result.jobTitle)
        tvProfilePersonal.setText(result.personalProfile)
        tvGoodFieldPersonal.setText(result.goodField)
    }

    override fun onFindDoctorByIdError(msg: String) {
    }
}
