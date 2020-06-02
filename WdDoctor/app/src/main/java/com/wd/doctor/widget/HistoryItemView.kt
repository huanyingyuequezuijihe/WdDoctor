package com.wd.doctor.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.wd.doctor.R
import com.wd.doctor.activity.LiShiPingActivity
import com.wd.doctor.bean.wy.FindHistoryInquiryRecordBean
import com.wd.doctor.net.NetManager
import com.wd.doctor.util.TimeStampUtil
import kotlinx.android.synthetic.main.item_history.view.*
import org.jetbrains.anko.startActivity

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/25 15:27
 * @classname :HistoryItemView
 * 历史 问诊 条目
 */
class HistoryItemView: RelativeLayout {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )
    init {
        View.inflate(context, R.layout.item_history,this)
    }

    fun setData(list: FindHistoryInquiryRecordBean.Result){
        //头像
        NetManager.netManager.getCirclePhoto(list.userHeadPic,imgPerson)
        tvPersonName.setText(list.nickName)
        val transToString = TimeStampUtil.transToString(list.inquiryTime)
        tvAskTime.setText(transToString)
        //查看问诊记录
        btnSelectHistory.setOnClickListener {  }
        //查看评论
        btnEvaluate.setOnClickListener {
            context.startActivity<LiShiPingActivity>()
        }
    }
}