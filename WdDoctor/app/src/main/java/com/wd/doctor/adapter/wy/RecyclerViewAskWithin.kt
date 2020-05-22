package com.wd.doctor.adapter.wy

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.wd.doctor.R
import com.wd.doctor.activity.SickCircleInfoActivity
import com.wd.doctor.bean.wy.FindSickCircleListBean
import com.wd.doctor.util.TimeStampUtil
import java.util.*
import kotlin.collections.ArrayList

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/21 19:39
 * @classname :RecyclerViewAskWithin
 * recycler内科，条目，适配器
 */
class RecyclerViewAskWithin : RecyclerView.Adapter<RecyclerViewAskWithin.MyHolder> {
    private var list: List<FindSickCircleListBean.Result> = ArrayList()
    private var context : Context
    private var isChecked = -1
    //控制一段时间只触发一次事件
    private val lastOnClickTime=0;
    constructor(list: List<FindSickCircleListBean.Result>, context: Context) : super() {
        this.list = list
        this.context = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = View.inflate(context, R.layout.item_askwithin,null)
        val myHolder = MyHolder(view)
        return myHolder
    }
    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.tvTitleAskWithin.setText(list.get(position).title)
        holder.tvAmountAskWithin.setText(""+list.get(position).amount)
        holder.tvDetailAskWithin.setText(list.get(position).detail)
        holder.tvDetailAskWithin.setText(list.get(position).detail)
        val transToString = TimeStampUtil.transToString(list.get(position).releaseTime)
        holder.tvTimeAskWithin.setText(transToString)
        //点击  变色
        if (isChecked == position) {
            holder.itemView.setBackgroundColor(Color.GREEN)
        } else {
            holder.itemView.setBackgroundColor(Color.WHITE)
        }
        //跳转
        val sickCircleId = list.get(position).sickCircleId
        holder.itemView.setOnClickListener {
            isChecked = position
            notifyDataSetChanged()
            //第一次点击的时间（上一次）
            val timeInMillis = Calendar.getInstance().getTimeInMillis();
            if (timeInMillis - lastOnClickTime > 2000) {
                val intent = Intent()
                intent.setClass(context,SickCircleInfoActivity::class.java)
                val bundle = Bundle()
                bundle.putInt("sickCircleId",sickCircleId)
                intent.putExtras(bundle)
                context.startActivity(intent)
            }
        }
    }
    override fun getItemCount(): Int {
        return list.size
    }
    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitleAskWithin:TextView=itemView.findViewById(R.id.tvTitleAskWithin)
        val imgAmountAskWithin:ImageView=itemView.findViewById(R.id.imgAmountAskWithin)
        val tvAmountAskWithin:TextView=itemView.findViewById(R.id.tvAmountAskWithin)
        val tvDetailAskWithin:TextView=itemView.findViewById(R.id.tvDetailAskWithin)
        val tvTimeAskWithin:TextView=itemView.findViewById(R.id.tvTimeAskWithin)
    }
}