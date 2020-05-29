package com.wd.doctor.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.wd.doctor.R
import com.wd.doctor.bean.cs.SuggestBean
import com.wd.doctor.net.NetManager
import com.wd.doctor.util.TimeStampUtil
import kotlinx.android.synthetic.main.item_history.view.imgPerson
import kotlinx.android.synthetic.main.item_history.view.tvAskTime
import kotlinx.android.synthetic.main.item_history.view.tvPersonName
import kotlinx.android.synthetic.main.item_suggest.view.*

class SuggestItemView: RelativeLayout {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )
    init {
        View.inflate(context, R.layout.item_suggest,this)
    }

    fun setData(list: SuggestBean.Result){
        //头像
        NetManager.netManager.getCirclePhoto(list.releaseUserHeadPic,imgPerson)
        tvPersonName.setText(list.releaseUserNickName)
        tv_title.setText(list.title)
        tv_zhuyao.setText(list.disease)
        tv_myjianyi.setText(list.content)
        val transToString = TimeStampUtil.transToString(list.adoptTime)
        tvAskTime.setText(transToString)

    }
}