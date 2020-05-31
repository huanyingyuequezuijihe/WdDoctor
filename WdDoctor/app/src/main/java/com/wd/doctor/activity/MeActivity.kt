package com.wd.doctor.activity

import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.PopupWindow
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wd.doctor.R
import com.wd.doctor.adapter.wy.RecyclerViewMe
import com.wd.doctor.base.BaseActivity
import kotlinx.android.synthetic.main.activity_me.*


class MeActivity :BaseActivity() {
    override fun initLayoutId(): Int {
        return R.layout.activity_me
    }

    override fun initListener() {
        super.initListener()
        //形象照
        constraintMe.setOnClickListener {
            initPopWindow(constraintMe)
        }
        imgBackMe.setOnClickListener {
            finish()
        }
        //个人
        tvPersonalMe.setOnClickListener {
            startActivityTo<PersonalActivity>()
        }
        //消息
        img_message_black.setOnClickListener {
            startActivityTo<MessageActivity>()
        }
    }
    private fun initPopWindow(v: View) {
        val view: View =
            LayoutInflater.from(this).inflate(R.layout.item_popwindow, null, false)
        val btn_start: Button = view.findViewById(R.id.btn_start)
        val btn_cancle: Button = view.findViewById(R.id.btn_cancle)
        //1.构造一个PopupWindow，参数依次是加载的View，宽高
        val popupWindow = PopupWindow(
            view,
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT,
            true
        )
        popupWindow.animationStyle = R.anim.anim_pop //设置加载动画
        //点击非PopupWindow区域，PopupWindow会消失的
        popupWindow.isTouchable = true
        popupWindow.setTouchInterceptor { v, event ->
            false
            // 这里如果返回true的话，touch事件将被拦截
            // 拦截后 PopupWindow的onTouchEvent不被调用，这样点击外部区域无法dismiss
        }
        //要为popWindow设置一个背景才有效
        popupWindow.setBackgroundDrawable(ColorDrawable(0x00000000))
        //设置popupWindow显示的位置，参数依次是参照View，x轴的偏移量，y轴的偏移量
        val inflate: View =
            LayoutInflater.from(this).inflate(R.layout.activity_me, null)
        popupWindow.showAtLocation(inflate, Gravity.BOTTOM, 0, 0)
        //点击事件
        btn_start.setOnClickListener{
            popupWindow.dismiss()
            startActivityTo<ImagePhotoActivity>()
        }
        //取消
        btn_cancle.setOnClickListener{
            popupWindow.dismiss()
        }
    }
    override fun initData() {
        super.initData()
        val gridLayoutManager = GridLayoutManager(this, 2)
        recyclerMe.layoutManager= gridLayoutManager as RecyclerView.LayoutManager?
        //适配器
        val list:List<String> = listOf("历史问诊","我的钱包","被采纳的建议","设置自动回复")
        val recyclerViewMe = RecyclerViewMe(list, this)
        recyclerMe.adapter=recyclerViewMe
    }
}
