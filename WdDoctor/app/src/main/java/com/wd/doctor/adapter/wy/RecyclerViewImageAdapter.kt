package com.wd.doctor.adapter.wy

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wd.doctor.bean.wy.FindSystemImagePicBean
import com.wd.doctor.widget.MyImagePicItemLast
import com.wd.doctor.widget.MyImagePicItemView

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/31 16:18
 * @classname :RecyclerViewImageAdapter
 */
class RecyclerViewImageAdapter: RecyclerView.Adapter<RecyclerViewImageAdapter.MyImagePicHolder>(){
    val list=ArrayList<FindSystemImagePicBean.Result>()
    fun updateData(list:List<FindSystemImagePicBean.Result>){
        list?.let {
            this.list.clear()
            this.list.addAll(list)
            notifyDataSetChanged()
        }
    }
    class MyImagePicHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyImagePicHolder {
        if (viewType==0){
            return  MyImagePicHolder(MyImagePicItemLast(parent?.context))
        }else{
            return  MyImagePicHolder(MyImagePicItemView(parent?.context))
        }
    }

    override fun getItemCount(): Int {
        return  list.size+1
    }

    override fun onBindViewHolder(holder: MyImagePicHolder, position: Int) {
        if(position==list.size)return
        val data = list.get(position)
        val myImagePicItemView = holder.itemView as MyImagePicItemView
        myImagePicItemView.setData(data)
    }
    override fun getItemViewType(position: Int): Int {
        if (position==list.size){
            return 0
        }else{
            return  1
        }
    }
}