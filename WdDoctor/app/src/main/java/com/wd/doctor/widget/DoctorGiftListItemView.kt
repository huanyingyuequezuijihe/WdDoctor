package com.wd.doctor.widget

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.wd.doctor.R
import com.wd.doctor.bean.wy.FindDoctorGiftListBean
import com.wd.doctor.net.NetManager
import kotlinx.android.synthetic.main.item_giftlist.view.*

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/29 21:10
 * @classname :DoctorGiftListItemView
 */
class DoctorGiftListItemView: RelativeLayout{
    var inflate :View?=null
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )
    init {
        inflate = View.inflate(context, R.layout.item_giftlist, this)
    }
    //设置
    fun setData(list: FindDoctorGiftListBean.Result){
        //图片
        val giftPic = list.giftPic
        var giftPicok=giftPic.substring(20,giftPic.length)
        NetManager.netManager.getCirclePhoto("http://mobile.bwstudent.com/"+giftPicok,imgGift)
        tvNameGift.setText(list.userNickName)
        tvGiftTime.setText(list.sendTime)
        //背景
        val giftId = list.giftId
        if(giftId==1001){
            inflate?.setBackgroundColor(Color.BLUE)
        }else  if(giftId==1002){
            inflate?.setBackgroundColor(Color.RED)
        }else  if(giftId==1003){
            inflate?.setBackgroundColor(Color.GREEN)
        }
    }
}