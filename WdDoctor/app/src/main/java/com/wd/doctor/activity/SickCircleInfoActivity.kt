package com.wd.doctor.activity

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import com.wd.doctor.R
import com.wd.doctor.base.BaseActivity
import com.wd.doctor.bean.wy.FindSickCircleInfoBean
import com.wd.doctor.bean.wy.PublishCommentBean
import com.wd.doctor.mvp.wy.presenterImpl.PublishCommentPresenterImpl
import com.wd.doctor.mvp.wy.presenterImpl.SickCircleInfoPresenterImpl
import com.wd.doctor.mvp.wy.view.PublishCommentView
import com.wd.doctor.mvp.wy.view.SickCircleInfoView
import com.wd.doctor.net.NetManager
import com.wd.doctor.util.TimeStampUtil
import kotlinx.android.synthetic.main.activity_sick_circle_info.*

//病友圈详情   透明遮盖
class SickCircleInfoActivity : BaseActivity(), SickCircleInfoView, PublishCommentView{
    val presenter by lazy { SickCircleInfoPresenterImpl(this) }
    val presenterPublish by lazy { PublishCommentPresenterImpl(this) }
    override fun initLayoutId(): Int {
        return R.layout.activity_sick_circle_info
    }
    var content :String?=null
    override fun initListener() {
        super.initListener()
        imgBackSickCircle.setOnClickListener {
            finish()
        }
        //点击  隐藏
        know.setOnClickListener {
            know.visibility= View.GONE
            tishi.visibility= View.GONE
            arrow.visibility= View.GONE
            selsct.visibility= View.GONE
            constraintBg.setBackgroundColor(Color.WHITE)
            tvAmountSickCircle.setBackgroundColor(Color.WHITE)
            imgPhotoSickCircle.visibility= View.VISIBLE
        }
        //点击  解答
        btnAskCircle.setOnClickListener {
            //传入sickCircleId值
            val bundle = this.intent.extras
            var sickCircleId= bundle?.get("sickCircleId") as Int?
            //AlertDialog
            val dialog = AlertDialog.Builder(this).create()
            val view = View.inflate(this, R.layout.dialog_comment, null)
            dialog.setView(view)
            dialog.show()
            var etContent=view.findViewById<View>(R.id.etContent) as EditText
            val  biaoqing=view.findViewById<View>(R.id.biaoqing) as ImageView
            val  imgSend=view.findViewById<View>(R.id.imgSend) as ImageView
            imgSend.setOnClickListener {
                content = etContent.text.toString()
                presenterPublish.onPublishCommentData(sickCircleId!!,content!!)
                dialog.dismiss()
            }
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
    override fun onPublishCommentError(message: String) {
    }
    override fun onPublishCommentSuccess(response: PublishCommentBean) {
        if (response?.status.equals("0000")){
            linearDialog.visibility= View.VISIBLE
            lieanrAsk.visibility= View.GONE
            csend_content.setText(content)
            myToast(response?.message.toString())
        }else{
            myToast(response?.message.toString())
        }
    }
}
