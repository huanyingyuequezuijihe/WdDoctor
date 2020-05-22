package com.wd.doctor.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.wd.doctor.R

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/22 16:29
 * @classname :LoadMoreView
 */
class LoadMoreView: RelativeLayout{
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )
    init{
        View.inflate(context, R.layout.item_loadmore,this)
    }
}