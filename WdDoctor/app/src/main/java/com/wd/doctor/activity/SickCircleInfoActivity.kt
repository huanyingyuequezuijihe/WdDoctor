package com.wd.doctor.activity

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.wd.doctor.R
import com.wd.doctor.base.BaseActivity
import com.wd.doctor.bean.wy.FindSickCircleInfoBean
import com.wd.doctor.mvp.wy.presenterImpl.SickCircleInfoPresenterImpl
import com.wd.doctor.mvp.wy.view.SickCircleInfoView
import com.wd.doctor.net.NetManager
import com.wd.doctor.util.TimeStampUtil
import kotlinx.android.synthetic.main.activity_sick_circle_info.*

//病友圈详情
class SickCircleInfoActivity : BaseActivity(), SickCircleInfoView{
    val presenter by lazy { SickCircleInfoPresenterImpl(this) }
    override fun initLayoutId(): Int {
        return R.layout.activity_sick_circle_info
    }
    override fun initListener() {
        super.initListener()
        imgBackSickCircle.setOnClickListener {
            finish()
        }
        know.setOnClickListener {
            know.visibility= View.GONE
            tishi.visibility= View.GONE
            arrow.visibility= View.GONE
            selsct.visibility= View.GONE
            constraintBg.setBackgroundColor(Color.WHITE)
            tvAmountSickCircle.setBackgroundColor(Color.WHITE)
            imgPhotoSickCircle.visibility= View.VISIBLE
        }
    }

    override fun initData() {
        super.initData()
        val bundle = this.intent.extras
        val sickCircleId = bundle?.getInt("sickCircleId")
        sickCircleId?.let { presenter.onSickCircleInfoSuccess(it) }
    }

    override fun onSickCircleInfoViewSuccess(response: FindSickCircleInfoBean) {
        //成功
        val result = response.result
        //H币
        tvAmountSickCircle.setText(""+result.amount+" H")
        //姓名
        tvNameSickCircle.setText(result.authorName)
        //病
        tvIllnessSickCircle.setText(result.disease)
        //科室
        tvSectionSickCircle.setText(result.departmentName)
        //病症详情
        tvDetailsSickCircle.setText(result.detail)
        //治疗经历
        //医院
        tvHospitalSickCircle.setText(result.treatmentHospital)
        //时间
        val transToString = TimeStampUtil.transToString(result.treatmentStartTime)
        tvTimeSickCircle.setText(transToString)
        //治疗的详细经历
        tvExperienceSickCircle.setText(result.treatmentProcess)

        //相关图片
        val picture = result.picture
        picture?.let {
            NetManager.netManager.getPhoto(result.picture,imgPhotoSickCircle)
        }
    }
    override fun onSickCircleInfoViewError(msg: String) {
    }
}
