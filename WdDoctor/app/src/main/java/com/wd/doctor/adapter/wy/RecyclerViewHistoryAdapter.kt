package com.wd.doctor.adapter.wy

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wd.doctor.bean.wy.FindHistoryInquiryRecordBean
import com.wd.doctor.widget.HistoryItemView

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/25 15:00
 * @classname :RecyclerViewHistoryAdapter
 * 历史 问诊 适配器
 */
class RecyclerViewHistoryAdapter: RecyclerView.Adapter<RecyclerViewHistoryAdapter.MyHolder>() {
    private var list=ArrayList<FindHistoryInquiryRecordBean.Result>()
    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    //加载方法
    fun updateList(list: List<FindHistoryInquiryRecordBean.Result>){
        list?.let {
            this.list.addAll(list)
            notifyDataSetChanged()
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(HistoryItemView(parent?.context))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val data = list.get(position)
        val historyItemView = holder.itemView as HistoryItemView
        historyItemView.setData(data)
    }
}