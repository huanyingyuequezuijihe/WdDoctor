package com.wd.doctor.widget

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.wd.doctor.R
import com.wd.doctor.activity.SickCircleInfoActivity
import com.wd.doctor.adapter.wy.RecyclerViewAskWithin
import com.wd.doctor.bean.wy.FindSickCircleListBean
import com.wd.doctor.net.App
import com.wd.doctor.util.TimeStampUtil
import kotlinx.android.synthetic.main.item_askwithin.view.*
import java.util.*

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/22 20:22
 * @classname :AskWithinView
 */
class AskWithinView: RelativeLayout{
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )
    //初始化方法
    init{
        View.inflate(context, R.layout.item_askwithin,this)
    }
    //刷新条目 view的数据
    fun setData(list: FindSickCircleListBean.Result) {
        tvTitleAskWithin.setText(list.title)
        tvAmountAskWithin.setText(list.amount.toString())
        tvDetailAskWithin.setText(list.detail)
        tvDetailAskWithin.setText(list.detail)
        val transToString = TimeStampUtil.transToString(list.releaseTime)
        tvTimeAskWithin.setText(transToString)
    }
}