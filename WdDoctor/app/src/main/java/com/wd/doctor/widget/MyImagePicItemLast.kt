package com.wd.doctor.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.wd.doctor.R
import com.wd.doctor.bean.wy.FindSystemImagePicBean
import com.wd.doctor.net.NetManager
import kotlinx.android.synthetic.main.item_myimagepiclast.view.*

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/31 16:25
 * @classname :MyImagePicItemLast
 */
class MyImagePicItemLast: RelativeLayout{
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )
    init {
        View.inflate(context, R.layout.item_myimagepiclast,this)
    }
}