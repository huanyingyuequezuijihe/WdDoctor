package com.wd.doctor.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.wd.doctor.R
import com.wd.doctor.bean.wy.FindInquiryDetailsListBean
import com.wd.doctor.net.NetManager
import com.wd.doctor.util.TimeStampUtil
import kotlinx.android.synthetic.main.chatdialogue_mine.view.*

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/28 19:44
 * @classname :FindInquiryDetailsListMyView
 */
class FindInquiryDetailsListMyView: RelativeLayout{
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )
    //初始化
    init {
        View.inflate(context, R.layout.chatdialogue_mine,this)
    }
    fun setData(list: FindInquiryDetailsListBean.Result){
        val transToString = TimeStampUtil.transToString(list.askTime)
        time.setText(transToString)
        mineContent.setText(list.content)
        NetManager.netManager.getCirclePhoto(list.doctorHeadPic,mineHead)
    }
}