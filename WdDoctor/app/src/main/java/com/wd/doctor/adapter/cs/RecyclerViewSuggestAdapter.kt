package com.wd.doctor.adapter.cs

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wd.doctor.bean.cs.SuggestBean
import com.wd.doctor.bean.wy.FindHistoryInquiryRecordBean
import com.wd.doctor.widget.HistoryItemView
import com.wd.doctor.widget.SuggestItemView

class RecyclerViewSuggestAdapter: RecyclerView.Adapter<RecyclerViewSuggestAdapter.MyHolder>() {
    private var list=ArrayList<SuggestBean.Result>()
    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    //加载方法
    fun updateList(list: List<SuggestBean.Result>){
        list?.let {
            this.list.addAll(list)
            notifyDataSetChanged()
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(SuggestItemView(parent?.context))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        //val data = list.get(position)
        val title=list.get(position)
        val historyItemView = holder.itemView as SuggestItemView
        historyItemView.setData(title)
    }
}