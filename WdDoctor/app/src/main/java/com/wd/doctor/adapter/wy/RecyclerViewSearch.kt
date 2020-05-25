package com.wd.doctor.adapter.wy

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wd.doctor.activity.SickCircleInfoActivity
import com.wd.doctor.bean.wy.SearchSickCircleBean
import com.wd.doctor.net.App
import com.wd.doctor.widget.SearchItemView

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/23 17:01
 * @classname :RecyclerViewSearch
 */
class RecyclerViewSearch :RecyclerView.Adapter<RecyclerViewSearch.SearchHolder>(){
    private var list=ArrayList<SearchSickCircleBean.Result>()
    class SearchHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    //加载方法
    fun updateList(list: List<SearchSickCircleBean.Result>){
        list?.let {
            this.list.addAll(list)
            notifyDataSetChanged()
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchHolder {
        return  SearchHolder(SearchItemView(parent?.context))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: SearchHolder, position: Int) {
        //设置数据
        var data=list.get(position)
        var itemView= holder.itemView as SearchItemView
        itemView.setData(data)
        itemView.setOnClickListener {
            val  intent= Intent(App.context, SickCircleInfoActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            var bundle = Bundle()
            bundle.putInt("sickCircleId",list?.get(position)?.sickCircleId)
            intent.putExtras(bundle)
            App.context?.startActivity(intent)
            notifyDataSetChanged()
        }
    }
}