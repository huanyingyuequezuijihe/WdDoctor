package com.wd.doctor.MyView

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.wd.doctor.R
import kotlinx.android.synthetic.main.title.view.*

/**
 * @author 吴健
 * Pseudonym:䦦鬰
 * @description:标题栏
 * @date :2020/5/25 8:18
 * @classname :
 */
class MyTitleView :RelativeLayout{
  var  back:ImageView?=null
  var  title: TextView?=null
  var view:View?=null
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )
    init {
        view =   View.inflate(context, R.layout.title,this)
        back=  view?.back
        title=  view?.title
    }
}