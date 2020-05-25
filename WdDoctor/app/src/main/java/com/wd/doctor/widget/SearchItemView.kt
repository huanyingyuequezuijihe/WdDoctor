package com.wd.doctor.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.wd.doctor.R
import com.wd.doctor.bean.wy.SearchSickCircleBean
import com.wd.doctor.util.TimeStampUtil
import kotlinx.android.synthetic.main.search_item.view.*

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/23 17:05
 * @classname :SearchItemView
 */
class SearchItemView: RelativeLayout {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )
    init {
        View.inflate(context, R.layout.search_item,this)
    }

    fun setData(data: SearchSickCircleBean.Result){
        lesion_title.setText(data.title)
        lesion_content.setText(data.detail)
        var time= TimeStampUtil.transToString(data.releaseTime)
        var t1=time.substring(0,time.length-5)
        var t2=time.substring(time.length-5,time.length)
        lesion_time.setText(t1)
        lesion_timehs.setText(t2)
    }
}