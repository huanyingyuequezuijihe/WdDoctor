package com.wd.doctor.adapter.wy

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wd.doctor.bean.wy.FindInquiryDetailsListBean
import com.wd.doctor.widget.FindInquiryDetailsListMyView
import com.wd.doctor.widget.FindInquiryDetailsListUserView

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/28 19:31
 * @classname :RecyclerViewUserChatAdapter
 */
class RecyclerViewUserChatAdapter: RecyclerView.Adapter<RecyclerViewUserChatAdapter.MyHolder>() {
    var list=ArrayList<FindInquiryDetailsListBean.Result>()
    fun updataData(list: List<FindInquiryDetailsListBean.Result>){
        list?.let {
            this.list.clear()
            this.list.addAll(list)
            notifyDataSetChanged()
        }
    }
    fun loadMoreDate(list:List<FindInquiryDetailsListBean.Result>){
        list?.let {
            this.list.addAll(list)
            notifyDataSetChanged()
        }
    }
    class MyHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        if(viewType==0){
            return MyHolder(FindInquiryDetailsListMyView(parent?.context))
        }else{
            return MyHolder(FindInquiryDetailsListUserView(parent?.context))
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val data = list.get(position)
        val direction = list.get(position).direction
        if(direction==1){
            //医生
            val myItemView = holder.itemView as FindInquiryDetailsListMyView
            myItemView.setData(data)
        }else if (direction==2){
            //患者
            var useritemView=holder.itemView as FindInquiryDetailsListUserView
            useritemView.setData(data)
        }
    }

    override fun getItemViewType(position: Int): Int {
        val direction = list.get(position).direction
        if(direction==1){
            return 0//医生
        }else{
            return 1//患者
        }
    }
}