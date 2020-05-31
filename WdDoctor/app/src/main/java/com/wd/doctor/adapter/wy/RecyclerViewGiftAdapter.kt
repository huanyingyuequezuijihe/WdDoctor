package com.wd.doctor.adapter.wy

import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wd.doctor.bean.wy.FindDoctorGiftListBean
import com.wd.doctor.widget.DoctorGiftListItemView

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/29 20:54
 * @classname :RecyclerViewGiftAdapter
 */
class RecyclerViewGiftAdapter: RecyclerView.Adapter<RecyclerViewGiftAdapter.MyHolder>() {
    var list=ArrayList<FindDoctorGiftListBean.Result>()
    fun updetadate(list:List<FindDoctorGiftListBean.Result>){
        list?.let {
            this.list.clear()
            this.list.addAll(list)
            notifyDataSetChanged()
        }
    }
    fun loadmoredate(list:List<FindDoctorGiftListBean.Result>){
        list?.let {
            this.list.addAll(list)
            notifyDataSetChanged()
        }
    }
    class MyHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(
            DoctorGiftListItemView(parent?.context)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val data = list.get(position)
        val doctorGiftListItemView = holder.itemView as DoctorGiftListItemView
        doctorGiftListItemView.setData(data)
    }
}